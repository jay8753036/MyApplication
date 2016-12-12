package com.example.a1039_jay.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private Spinner spinner1;
    private Spinner spinner2;
    private Spinner spinner3;
    private Spinner spinner4;
    private Spinner spinner5;
    private Spinner spinner6;
    private Spinner spinner7;
    private Spinner spinner8;
    private Spinner spinner9;
    private Spinner spinner10;
    private Button button1;
    private Switch switch1;
    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private EditText editText6;
    private EditText editText7;
    private EditText editText8;
    private EditText editText9;
    private EditText editText10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinner7 = (Spinner) findViewById(R.id.spinner7);
        spinner8 = (Spinner) findViewById(R.id.spinner8);
        spinner9 = (Spinner) findViewById(R.id.spinner9);
        spinner10 = (Spinner) findViewById(R.id.spinner10);
        switch1 = (Switch) findViewById(R.id.switch1);
        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        editText3 = (EditText) findViewById(R.id.editText3);
        editText4 = (EditText) findViewById(R.id.editText4);
        editText5 = (EditText) findViewById(R.id.editText5);
        editText6 = (EditText) findViewById(R.id.editText6);
        editText7 = (EditText) findViewById(R.id.editText7);
        editText8 = (EditText) findViewById(R.id.editText8);
        editText9 = (EditText) findViewById(R.id.editText9);
        editText10 = (EditText) findViewById(R.id.editText10);

        button1 = (Button) findViewById(R.id.button1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);
        spinner3.setAdapter(adapter);
        spinner4.setAdapter(adapter);
        spinner5.setAdapter(adapter);
        spinner6.setAdapter(adapter);
        spinner7.setAdapter(adapter);
        spinner8.setAdapter(adapter);
        spinner9.setAdapter(adapter);
        spinner10.setAdapter(adapter);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(Main2Activity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("play1", spinner1.getSelectedItem().toString());
                if (!"".equals(editText1.getText().toString())) {
                    bundle.putString("play1", editText1.getText().toString());
                }
                bundle.putString("play2", spinner2.getSelectedItem().toString());
                if (!"".equals(editText2.getText().toString())) {
                    bundle.putString("play2", editText2.getText().toString());
                }
                bundle.putString("play3", spinner3.getSelectedItem().toString());
                if (!"".equals(editText3.getText().toString())) {
                    bundle.putString("play3", editText3.getText().toString());
                }
                bundle.putString("play4", spinner4.getSelectedItem().toString());
                if (!"".equals(editText4.getText().toString())) {
                    bundle.putString("play4", editText4.getText().toString());
                }
                bundle.putString("play5", spinner5.getSelectedItem().toString());
                if (!"".equals(editText5.getText().toString())) {
                    bundle.putString("play5", editText5.getText().toString());
                }
                bundle.putString("play6", spinner6.getSelectedItem().toString());
                if (!"".equals(editText6.getText().toString())) {
                    bundle.putString("play6", editText6.getText().toString());
                }
                bundle.putString("play7", spinner7.getSelectedItem().toString());
                if (!"".equals(editText7.getText().toString())) {
                    bundle.putString("play7", editText7.getText().toString());
                }
                bundle.putString("play8", spinner8.getSelectedItem().toString());
                if (!"".equals(editText8.getText().toString())) {
                    bundle.putString("play8", editText8.getText().toString());
                }
                bundle.putString("play9", spinner9.getSelectedItem().toString());
                if (!"".equals(editText9.getText().toString())) {
                    bundle.putString("play9", editText9.getText().toString());
                }
                bundle.putString("play10", spinner10.getSelectedItem().toString());
                if (!"".equals(editText10.getText().toString())) {
                    bundle.putString("play10", editText10.getText().toString());
                }
                bundle.putBoolean("notifyFlag", switch1.isChecked());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
