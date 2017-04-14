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

public class InsertActivity extends AppCompatActivity {

    public EditText inputName;
    public EditText inputId;
    public EditText inputPhone;
    public EditText inputAdd;
    public EditText inputGen;
    public EditText inputAge;

    //Button
    Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        /// Edit Text
        inputName = (EditText) findViewById(R.id.editName);
        // inputId = (EditText) findViewById(R.id.editId);
        inputPhone = (EditText) findViewById(R.id.editPhone);
        inputAdd = (EditText) findViewById(R.id.editAdd);
        inputAge = (EditText) findViewById(R.id.editDesignation);
        inputGen = (EditText) findViewById(R.id.editGender);


        buttonAdd = (Button) findViewById(R.id.insertButton);

        //Setting listeners to button
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
        // final String id = inputId.getText().toString().trim();
        final String phone = inputPhone.getText().toString().trim();
        final String age = inputAge.getText().toString().trim();
        final String gender = inputGen.getText().toString().trim();
        final String add = inputAdd.getText().toString().trim();


        class AddPatient extends AsyncTask<Void, Void, String> {

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(InsertActivity.this, "Adding...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(InsertActivity.this, s, Toast.LENGTH_LONG).show();
            }


            @Override
            protected String doInBackground(Void... v) {

                HashMap<String, String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME, name);
                // params.put(Config.KEY_EMP_ID, id);
                params.put(Config.KEY_EMP_PHONE, phone);
                params.put(Config.KEY_EMP_AGE, age);
                params.put(Config.KEY_EMP_ADD, add);
                params.put(Config.KEY_EMP_GEN, gender);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddPatient ae = new AddPatient();
        ae.execute();
    }
}

