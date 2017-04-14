package com.example.rajnunes.dbms;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class UpdateActivity extends AppCompatActivity {

    public EditText inputId;
    public EditText inputName;
    public Button   buttonUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        //edit text
        inputId = (EditText) findViewById(R.id.editID);
        inputName = (EditText) findViewById(R.id.editName);

        //inputPhone = (EditText) findViewById(R.id.enterPhone);
        buttonUpdate = (Button) findViewById(R.id.updateButton);

        buttonUpdate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "update table", Toast.LENGTH_SHORT).show();

                updatePatient();
            }
        });

    }

    private void updatePatient(){
        final String name = inputName.getText().toString();
        final String id   = inputId.getText().toString();



        class UpdatePatient extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(UpdateActivity.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(UpdateActivity.this,s,Toast.LENGTH_LONG).show();
            }


            @Override
            protected String doInBackground(Void... v) {
                /*HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_DESG,desg);
                params.put(Config.KEY_EMP_SAL,sal);
                */
                //Toast.makeText(InsertActivity.this,"hello",Toast.LENGTH_LONG).show();

                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_ID,id);
                //params.put(Config.KEY_EMP_PHONE,phone);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_UPDATE_EMP, params);
                return res;
            }
        }

        UpdatePatient ae = new UpdatePatient();
        ae.execute();
    }
}