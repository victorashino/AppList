package com.victorashino.applist.controller;

import android.content.SharedPreferences;
import android.util.Log;

import com.victorashino.applist.model.Person;
import com.victorashino.applist.view.MainActivity;

public class PersonController {

    SharedPreferences preferences;
    SharedPreferences.Editor vipList;
    public static final String NOME_PREFERENCIAS = "pref_viplist";

    public PersonController(MainActivity mainActivity) {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCIAS, 0);
        vipList = preferences.edit();
    }

    public void save(Person pessoa) {
        vipList.putString("firstName", pessoa.getFirstName());
        vipList.putString("lastName", pessoa.getLastName());
        vipList.putString("desiredCourse", pessoa.getDesiredCourse());
        vipList.putString("contactPhone", pessoa.getContactPhone());
        vipList.apply();
        Log.d("MVC_Controller", "Salvo " + pessoa);
    }

    public Person find(Person pessoa) {
        pessoa.setFirstName(preferences.getString("firstName", "NA"));
        pessoa.setLastName(preferences.getString("lastName", "NA"));
        pessoa.setDesiredCourse(preferences.getString("desiredCourse", "NA"));
        pessoa.setContactPhone(preferences.getString("contactPhone", "NA"));
        return pessoa;
    }

    public void clearSharedPreferences() {
        vipList.clear();
        vipList.apply();
    }

}
