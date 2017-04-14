package com.example.rajnunes.dbms;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //set the content of the activity to use activity_main_menu.xml layout file
        setContentView(R.layout.activity_main_menu);

        //Find views
        TextView insert = (TextView) findViewById(R.id.insert);
        TextView delete = (TextView) findViewById(R.id.delete);
        TextView modify = (TextView) findViewById(R.id.modify);
        final TextView display = (TextView) findViewById(R.id.display);
        TextView search = (TextView) findViewById(R.id.search);

        //set insert onClickListener
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Insert", Toast.LENGTH_SHORT).show();
                Intent insertIntent = new Intent(MainMenuActivity.this, InsertMenuActivity.class);
                startActivity(insertIntent);
            }
        });

        //set delete onClickListener
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Delete", Toast.LENGTH_SHORT).show();
                Intent deleteIntent = new Intent(MainMenuActivity.this, DeleteActivity.class);
                startActivity(deleteIntent);
            }
        });

        //set modify onClickListener
        modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Modify", Toast.LENGTH_SHORT).show();
                Intent updateIntent =new Intent(MainMenuActivity.this, UpdateActivity.class);
                startActivity(updateIntent);
            }
        });

        //set Display onCLickListener
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Display", Toast.LENGTH_SHORT).show();
                Intent displayIntent = new Intent(MainMenuActivity.this, DisplayMenuActivity.class);
                startActivity(displayIntent);
            }
        });

        //set Search onCLickListener
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Search", Toast.LENGTH_SHORT).show();

            }
        });
    }

   /* public  void search(View view){

        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Search", Toast.LENGTH_SHORT).show();
        }

    }*/

}
