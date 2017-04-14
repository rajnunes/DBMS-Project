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

public class DiagnosisActivity extends AppCompatActivity {
    public EditText inputName;
    public EditText inputId;
    public EditText inputGen;

    //Button
    Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagnosis);

        /// Edit Text
        inputName = (EditText) findViewById(R.id.editName);
        inputId = (EditText) findViewById(R.id.editId);

        inputGen = (EditText) findViewById(R.id.editGender);


        buttonAdd = (Button) findViewById(R.id.insertButton);
        //buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        // buttonAdd.setOnClickListener(this);
        //buttonView.setOnClickListener(this);
        buttonAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //Toast.makeText(v.getContext(), "Insert into table", Toast.LENGTH_SHORT).show();

                addPatient();
            }
        });
    }

    //Adding an employee
    private void addPatient() {

        final String name = inputName.getText().toString().trim();
        final String id = inputId.getText().toString().trim();

        final String gender = inputGen.getText().toString().trim();

        /*final String name = editTextName.getText().toString().trim();
        final String desg = editTextDesg.getText().toString().trim();
        final String sal = editTextSal.getText().toString().trim();*/


        class AddPatient extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(DiagnosisActivity.this, "Adding...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(DiagnosisActivity.this, s, Toast.LENGTH_LONG).show();
            }


            @Override
            protected String doInBackground(Void... v) {
                /*HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_DESG,desg);
                params.put(Config.KEY_EMP_SAL,sal);*/

                //Toast.makeText(InsertActivity.this,"hello",Toast.LENGTH_LONG).show();

                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME, name);
                params.put(Config.KEY_EMP_ID, id);
                params.put(Config.KEY_EMP_GEN, gender);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD_DIAGNOSIS, params);
                return res;
            }
        }

        AddPatient ae = new AddPatient();
        ae.execute();
    }

}
