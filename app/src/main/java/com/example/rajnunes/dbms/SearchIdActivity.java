package com.example.rajnunes.dbms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SearchIdActivity extends AppCompatActivity {


    public EditText inputName;
    public Button buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_id);

        inputName = (EditText) findViewById(R.id.editName);


        buttonAdd = (Button) findViewById(R.id.insertButton);
        //buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        // buttonAdd.setOnClickListener(this);
        //buttonView.setOnClickListener(this);
        buttonAdd.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                final String id = inputName.getText().toString();
                //Toast.makeText(v.getContext(), "Insert into table", Toast.LENGTH_SHORT).show();
                Intent newIntent = new Intent(SearchIdActivity.this, DiagnosisDisplayActivity.class);
                newIntent.putExtra("ID", id);
                startActivity(newIntent);
            }
        });
    }
}