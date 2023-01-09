package com.rising.demoyt;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.android.AndroidPlatform;


public class MainActivity extends AppCompatActivity {

    Button downloadBTN;
    EditText urlET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        downloadBTN=findViewById(R.id.download);
        urlET=findViewById(R.id.url);

        if(!Python.isStarted())
            Python.start(new AndroidPlatform(this));
/*
        Python py=Python.getInstance();
        final PyObject pyObj=py.getModule("Convert");
*/


        downloadBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //PyObject obj=pyObj.callAttr("DownloadURL",urlET.getText().toString());
                new LongRuningTask().execute();
            }
        });


    }

    private  class LongRuningTask extends AsyncTask<Void,Void,Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
        }

        @Override
        protected Void doInBackground(Void... voids) {

            Python py=Python.getInstance();
            final PyObject pyObj=py.getModule("Convert");
            PyObject obj=pyObj.callAttr("DownloadURL",urlET.getText().toString());
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }
    }
}


