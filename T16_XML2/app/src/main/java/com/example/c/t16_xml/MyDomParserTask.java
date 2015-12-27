package com.example.c.t16_xml;

import android.content.Context;
import android.os.AsyncTask;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * Created by c on 2015-12-20.
 */
public class MyDomParserTask extends AsyncTask<String, Void, Document> {

    TestSqliteHandler handler;

    public MyDomParserTask(Context context){
        handler = new TestSqliteHandler(context);
    }

    private String getElementText(Element dataElement, String tag){
        NodeList tagNodeList = dataElement.getElementsByTagName(tag);
        Element tagElment = (Element) tagNodeList.item(0);

        NodeList tagTextNodeList = tagElment.getChildNodes();
        //return tag+" : "+tagTextNodeList.item(0).getNodeValue();
        return tagTextNodeList.item(0).getNodeValue();
    }

    @Override
    protected void onPostExecute(Document document) {
        super.onPostExecute(document);

        String str = "";
        NodeList nodeList = document.getElementsByTagName("data");
        for(int i=0; i<nodeList.getLength(); i++){
            Element dataElement = (Element)nodeList.item(i);

            String day = getElementText(dataElement, "day");
            String hour = getElementText(dataElement, "hour");
            String temp = getElementText(dataElement, "temp");
            String wfKor = getElementText(dataElement, "wfKor");
            handler.insert(day, hour, temp, wfKor);

//                str += getElementText(dataElement, "day");
//                str += getElementText(dataElement, "hour");
//                str += getElementText(dataElement, "temp");
//                str += getElementText(dataElement, "wfKor");


            str += "\n";
        }

        //textView.setText(str);
        handler.selectAll();
    }

    @Override
    protected Document doInBackground(String... params) {
        URL url = null;
        Document doc = null;

        try {
            url = new URL(params[0]);
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            doc = db.parse(url.openStream());

        }catch (Exception e){
            e.printStackTrace();
        }
        return doc;
    }
}
