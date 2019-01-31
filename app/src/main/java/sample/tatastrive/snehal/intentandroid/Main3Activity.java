package sample.tatastrive.snehal.intentandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main3Activity extends AppCompatActivity {
     Button buttonAdmin, buttonEmp, buttonStud;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        buttonAdmin = findViewById(R.id.admin);
        buttonEmp = findViewById(R.id.emp);
        buttonStud = findViewById(R.id.stud);
        buttonAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Main3Activity.this,LoginActivity.class);
                startActivity(intent2);

            }
        });
        buttonEmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(Main3Activity.this,LoginActivity.class);
                startActivity(intent3);
            }
        });
        buttonStud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent4 = new Intent(Main3Activity.this,StudentDashboard.class);
                startActivity(intent4);
            }
        });

    }
}
