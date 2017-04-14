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

public class DeleteActivity extends AppCompatActivity {

    public  EditText inputId;
    public Button buttonDelete;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        inputId = (EditText) findViewById(R.id.editID);

        buttonDelete = (Button) findViewById(R.id.deleteButton);


        buttonDelete.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "update table", Toast.LENGTH_SHORT).show();

                deletePatient();
            }
        });
    }

    private void deletePatient(){

        final String id   = inputId.getText().toString();



        class DeletePatient extends AsyncTask<Void,Void,String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DeleteActivity.this,"Deleting...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(DeleteActivity.this,s,Toast.LENGTH_LONG).show();
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
                //params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_ID,id);
                //params.put(Config.KEY_EMP_PHONE,phone);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_DELETE_EMP, params);
                return res;
            }
        }

        DeletePatient ae = new DeletePatient();
        ae.execute();
    }
}
