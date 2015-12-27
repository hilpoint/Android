package com.example.c.t16_xml;

import android.content.Context;
import android.os.AsyncTask;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by c on 2015-12-20.
 */
public class MyPullParserTask extends AsyncTask<String, Void, Void> {
    class MyData{
        HashMap<String, String> dataMap = new HashMap<>();
    }

    ArrayList<MyData> list = new ArrayList<>();

    TestSqliteHandler handler;
    public MyPullParserTask(Context context){
        handler = new TestSqliteHandler(context);
    }
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        for(MyData data : list){
            String hour = data.dataMap.get("hour");
            String day = data.dataMap.get("day");
            String temp = data.dataMap.get("temp");
            String wfKor = data.dataMap.get("wfKor");
            handler.insert(day, hour,temp, wfKor);
        }

        handler.selectAll();

    }

    @Override
    protected Void doInBackground(String... params) {


        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xpp = factory.newPullParser();
            xpp.setInput(new URL(params[0]).openStream(), "utf-8");

            String[] keywords = {"hour", "day", "temp", "wfKor"};
            int eventType = xpp.getEventType();
            boolean bRead = false;
            String strResult = "";

            MyData myData = null;
            String tagName = "";
            while(eventType != XmlPullParser.END_DOCUMENT){
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        tagName = xpp.getName();
                        for(String s : keywords){
                            if(s.equals(tagName)){
                                if(s.equals("hour")){
                                    myData = new MyData();
                                    list.add(myData);
                                }
                                bRead = true;
                                strResult += s;
                            }
                        }
                        break;

                    case XmlPullParser.TEXT:
                        if(bRead == true){
                            strResult += " : "+xpp.getText();
                            bRead = false;

                            myData.dataMap.put(tagName, xpp.getText());
                        }
                        break;

                    case XmlPullParser.END_TAG:
                        break;
                }
                eventType = xpp.next();
            }

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
