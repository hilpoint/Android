package com.mycompany.t10_asynctask;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    class MyAsyncTask extends AsyncTask<Integer, Integer, String> {
        ProgressDialog dialog;

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

            int value = values[0];
            progressBar.setProgress(value);
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            dialog = new ProgressDialog(MainActivity.this);
            dialog.setTitle("ProgressDialog");
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
           dialog.setButton(DialogInterface.BUTTON_NEGATIVE,
                   "Cancel", new DialogInterface.OnClickListener() {
                       @Override
                       public void onClick(DialogInterface dialog, int whitch) {
                           dialog.dismiss();
                       }
                   });
            dialog.show();
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
            dialog.dismiss();
        }

        @Override
        protected String doInBackground(Integer... params) {
            int progress = params[0];

            while (progress <= 100) {
                publishProgress(progress);
                progress++;

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            return "DONE";
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        Button btnStart = (Button) findViewById(R.id.btnstart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyAsyncTask myTask = new MyAsyncTask();
                myTask.execute(30);
            }
        });

    }
}
