package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Detail extends AppCompatActivity {
TextView textView;
Button bck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        textView = (TextView) findViewById(R.id.resultView);
        bck = (Button)findViewById(R.id.btnBack);
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(folder,"amit.txt");
        try {
            FileInputStream fis = new FileInputStream(myFile);
            StringBuffer sbuffer = new StringBuffer();
            int i;
            while ((i = fis.read())!= -1){
                sbuffer.append((char)i);
            }
            fis.close();
            textView.setText(sbuffer.toString());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        bck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Detail.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}