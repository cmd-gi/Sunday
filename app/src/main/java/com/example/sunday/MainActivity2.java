package com.example.sunday;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.sunday.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ActivityMain2Binding sp;
        sp= DataBindingUtil.setContentView(this,R.layout.activity_main2);

        String res=   getIntent().getStringExtra("a");
        Toast.makeText(this, res, Toast.LENGTH_SHORT).show();

        sp.textView2.setText(res);


    }
}