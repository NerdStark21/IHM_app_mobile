package com.example.aurel.app_project;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    Button saveButton;
    EditText editTextName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        initViews();
    }

    private void initViews(){
        saveButton = findViewById(R.id.activity_form_button);
        editTextName = findViewById(R.id.activity_form_edit_name);
        saveButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                saveData();
            }
        });

    }

    private void saveData(){

        String name = editTextName.getText().toString();

        if(!name.isEmpty()){
            DataManager.getInstance().addItem(name);
        }else{
            Toast.makeText(this, "Veuillez saisir votre nom", Toast.LENGTH_SHORT).show();
        }

        finish();
    }
}
