package com.example.c.t19_json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String strJson="{\"Employee\" :[{\"id\":\"01\",\"name\":\"Gopal Varma\",\"salary\":\"500000\"},{\"id\":\"02\",\"name\":\"Sairamkrishna\",\"salary\":\"500000\"},{\"id\":\"03\",\"name\":\"Sathish kallakuri\",\"salary\":\"600000\"}]}";

        String data= "";
        TextView textView = (TextView)findViewById(R.id.textView);

        try {
            JSONObject jsonRootObject = new JSONObject(strJson);
            JSONArray jsonArray = jsonRootObject.optJSONArray("Employee");

            for(int i=0; i<jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                int id = jsonObject.getInt("id");
                String name = jsonObject.getString("name");
                double salary = jsonObject.getDouble("salary");

                data += "Node"+i+" : \n id="+id+"\n Name="+name+"\n Salary="+salary+"\n";

            }
            textView.setText(data);

        } catch (JSONException e) {
            e.printStackTrace();
        }



    }
}
