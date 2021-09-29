package com.example.android.mowik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView n = (TextView) findViewById(R.id.number);
        n.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "opening number", Toast.LENGTH_SHORT).show();
                Intent intentNumbers= new Intent(getApplicationContext(),number.class);
                startActivity(intentNumbers);

            }
        });

     TextView p= (TextView) findViewById(R.id.phrase);
     p.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(MainActivity.this, "opening phrases", Toast.LENGTH_SHORT).show();
             Intent  intentphrase= new Intent(getApplicationContext(),phrases.class);
             startActivity(intentphrase);

         }
     });

     TextView f=(TextView) findViewById(R.id.family);
     f.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(MainActivity.this, "opening family  ", Toast.LENGTH_SHORT).show();
             Intent intentfamily= new Intent(getApplicationContext(),family.class);
             startActivity(intentfamily);
         }
     });

     TextView c= (TextView) findViewById(R.id.color);
     c.setOnClickListener(new OnClickListener() {
         @Override
         public void onClick(View v) {
             Toast.makeText(MainActivity.this, "opening colors", Toast.LENGTH_SHORT).show();
             Intent intentcolor= new Intent(getApplicationContext(),colors.class);
             startActivity(intentcolor);

         }
     });



    }
}


//    public void NumbersOnClick(View view )
//    {
//        Intent intentNumbers= new Intent(getApplicationContext(),numbers.class);
//        startActivity(intentNumbers);
//    }
//}