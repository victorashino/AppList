package com.victorashino.applist.view;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.victorashino.applist.R;
import com.victorashino.applist.model.Person;

public class MainActivity extends AppCompatActivity {

    Person pessoa;

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
        pessoa = new Person();
        pessoa.setFirstName("Victor");
        pessoa.setLastName("Ashino");
        pessoa.setDesiredCourse("Java");
        pessoa.setContactPhone("11-995048410");

        Log.i("POOAndroid", pessoa.toString());
    }
}