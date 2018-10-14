package com.sheygam.java_221_14_10_18_cw;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button saveBtn, loadBtn;
    private EditText inputMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saveBtn = findViewById(R.id.save_btn);
        loadBtn = findViewById(R.id.load_btn);
        inputMsg = findViewById(R.id.inputMsg);
        saveBtn.setOnClickListener(this);
        loadBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.save_btn){
            saveData();
        }else if(v.getId() == R.id.load_btn){
            loadData();
        }
    }

    private void loadData() {
        SharedPreferences sp = getSharedPreferences("MY_DATA",MODE_PRIVATE);
        String data = sp.getString("DATA",null);
        if(data != null){
            inputMsg.setText(data);
        }else{
            Toast.makeText(this, "No data for loading", Toast.LENGTH_SHORT).show();
        }
    }

    private void saveData() {
        String msg = String.valueOf(inputMsg.getText());
        SharedPreferences sp = getSharedPreferences("MY_DATA",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();

        editor.putString("DATA",msg);
        editor.putString("MY_DATA","Vasya");
        if(editor.commit()){
            Toast.makeText(this, "Data Saved", Toast.LENGTH_SHORT).show();
            inputMsg.setText("");
        }
    }
}
