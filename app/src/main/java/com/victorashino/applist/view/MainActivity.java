package com.victorashino.applist.view;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.victorashino.applist.R;
import com.victorashino.applist.controller.PersonController;
import com.victorashino.applist.databinding.ActivityMainBinding;
import com.victorashino.applist.model.Person;

public class MainActivity extends AppCompatActivity {

    SharedPreferences preferences;
    public static final String NOME_PREFERENCIAS = "pref_viplist";

    PersonController controller;

    Person pessoa;

    EditText editFirstName;
    EditText editLastName;
    EditText editDesiredCourse;
    EditText editContactPhone;

    Button btnClear;
    Button btnSave;
    Button btnDone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        EdgeToEdge.enable(this);
        setContentView(binding.getRoot());
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        preferences = getSharedPreferences(NOME_PREFERENCIAS, 0);
        SharedPreferences.Editor vipList = preferences.edit();

        controller = new PersonController();

        pessoa = new Person();
        pessoa.setFirstName(preferences.getString("firstName", ""));
        pessoa.setLastName(preferences.getString("lastName", ""));
        pessoa.setDesiredCourse(preferences.getString("desiredCourse", ""));
        pessoa.setContactPhone(preferences.getString("contactPhone", ""));

        editFirstName = binding.editFirstName;
        editLastName = binding.editLastName;
        editDesiredCourse = binding.editDesiredCourse;
        editContactPhone = binding.editContactPhone;

        editFirstName.setText(pessoa.getFirstName());
        editLastName.setText(pessoa.getLastName());
        editDesiredCourse.setText(pessoa.getDesiredCourse());
        editContactPhone.setText(pessoa.getContactPhone());

        btnClear = binding.btnClear;
        btnSave = binding.btnSave;
        btnDone = binding.btnDone;

        btnClear.setOnClickListener(view -> {
            editFirstName.setText("");
            editLastName.setText("");
            editDesiredCourse.setText("");
            editContactPhone.setText("");
        });

        btnSave.setOnClickListener(view -> {
            pessoa.setFirstName(editFirstName.getText().toString());
            pessoa.setLastName(editLastName.getText().toString());
            pessoa.setDesiredCourse(editDesiredCourse.getText().toString());
            pessoa.setContactPhone(editContactPhone.getText().toString());

            Toast.makeText(MainActivity.this, "Salvo " + pessoa.toString(), Toast.LENGTH_SHORT).show();

            vipList.putString("firstName", pessoa.getFirstName());
            vipList.putString("lastName", pessoa.getLastName());
            vipList.putString("desiredCourse", pessoa.getDesiredCourse());
            vipList.putString("contactPhone", pessoa.getContactPhone());
            vipList.apply();

            controller.save(pessoa);
        });

        btnDone.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "Volte Sempre", Toast.LENGTH_SHORT).show();
            finish();
        });

        Log.i("POOAndroid", pessoa.toString());
    }
}