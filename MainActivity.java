package com.example.emicalculater;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
TextView out;
EditText n1,n2,n3,n4;
Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        out=findViewById(R.id.out);
        n1=findViewById(R.id.n1);
        n2=findViewById(R.id.n2);
        n3=findViewById(R.id.n3);
        n4=findViewById(R.id.n4);
        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "request is submitted!!", Toast.LENGTH_SHORT).show();
                double price=Integer.parseInt(n1.getText().toString()) ;
                double donp=Integer.parseInt(n2.getText().toString());
                int month=Integer.parseInt(n3.getText().toString());
                double intrest=Integer.parseInt(n4.getText().toString());
                double remain=price-donp;
                double total=remain*intrest/100;
                double total2=total+remain;
                double total3=total2/month;
                out.setText("monthly payment is " +total3);
            }
        });
    }
}