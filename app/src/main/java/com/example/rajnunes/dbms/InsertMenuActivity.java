package com.example.rajnunes.dbms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class InsertMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_menu);

        TextView patient = (TextView) findViewById(R.id.Patient);
        TextView doctor = (TextView) findViewById(R.id.Doctor);
        TextView nurse = (TextView) findViewById(R.id.Nurse);
        TextView diagnosis= (TextView) findViewById(R.id.Diagnosis);

        patient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Insert", Toast.LENGTH_SHORT).show();
                Intent insertIntent = new Intent(InsertMenuActivity.this, InsertActivity.class);
                startActivity(insertIntent);
            }
        });

        doctor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Insert", Toast.LENGTH_SHORT).show();
                Intent insertIntent = new Intent(InsertMenuActivity.this, DoctorActivity.class);
                startActivity(insertIntent);
            }
        });

        nurse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Insert", Toast.LENGTH_SHORT).show();
                Intent insertIntent = new Intent(InsertMenuActivity.this, NurseActivity.class);
                startActivity(insertIntent);
            }
        });

        diagnosis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Insert", Toast.LENGTH_SHORT).show();
                Intent insertIntent = new Intent(InsertMenuActivity.this, DiagnosisActivity.class);
                startActivity(insertIntent);
            }
        });
    }
}
