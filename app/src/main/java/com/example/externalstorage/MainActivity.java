package com.example.externalstorage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText uname;
    Button saveBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},23);
        uname = findViewById(R.id.txtName);
        saveBtn = findViewById(R.id.btnSave);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = uname.getText().toString()+"\n";
                File mydir=getExternalFilesDir(null);
                File directory=new File(mydir.getAbsoluteFile(),"/MyFiles");
                directory.mkdirs();
                //File dir= Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
                File myfile=new File(directory,"amit.txt");
                try {
                    FileOutputStream fos=new FileOutputStream(myfile);
                    fos.write(username.getBytes());
                    fos.close();
                    Toast.makeText(getApplicationContext(), "Details Saved in "+myfile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,Detail.class);
                    startActivity(intent);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}