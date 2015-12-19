package com.mycompany.t16_xml;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.net.URL;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    TestSqliteHandler handler;
    class MyXMLTask extends AsyncTask<String, Void, Document>{

        private String getElementText(Element dataElement, String tag) {
            NodeList tagNodeList = dataElement.getElementsByTagName(tag);
            Element tagElement =  (Element) tagNodeList.item(0);

            NodeList tagTextNodeList = tagElement.getChildNodes();
            return tagTextNodeList.item(0).getNodeValue();
        }

        @Override
        protected void onPostExecute(Document document) {
            super.onPostExecute(document);

            String str = "";
            NodeList  nodeList
                    = document.getElementsByTagName("data");

            for (int i=0; i<nodeList.getLength(); i++){
                Element dataElement = (Element) nodeList.item(i);

                //str += getElementText(dataElement, "day");
                //str += getElementText(dataElement, "hour");
                //str += getElementText(dataElement, "temp");
                //str += getElementText(dataElement, "wfKor");

                handler.insert(getElementText(dataElement, "day"),
                        getElementText(dataElement, "hour"),
                        getElementText(dataElement, "temp"),
                        getElementText(dataElement, "wfKor"));
            }
            //textView.setText(str);
            handler.selectAll();
        }


        @Override
        protected Document doInBackground(String... params) {
            URL url =  null;
            Document doc = null;

            try {
                url = new URL(params[0]);
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                doc = db.parse(url.openStream());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return doc;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new TestSqliteHandler(this);

        textView = (TextView) findViewById(R.id.textView);
        Button btnStart = (Button) findViewById(R.id.btnsStart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new MyXMLTask().execute("http://www.kma.go.kr/wid/queryDFSRSS.jsp?zone=1153054000");
            }
        });
    }
}
