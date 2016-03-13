package com.abhinavankur.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userName, password;
    TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (EditText) findViewById(R.id.userName);
        password = (EditText) findViewById(R.id.password);
        showText = (TextView) findViewById(R.id.showText);
    }

    public void saveInfo(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("username", userName.getText().toString());
        editor.putString("password",password.getText().toString());
        editor.apply();

        Toast.makeText(this,"Saved",Toast.LENGTH_SHORT).show();
    }

    public void displayInfo(View view){
        SharedPreferences sharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
        String name = sharedPreferences.getString("username","");       /*Second parameter is what is returned when the key doesn't exist in the shared preferences file.*/
        String pwd = sharedPreferences.getString("password","");

        showText.setText(name + " " + pwd);
    }
}