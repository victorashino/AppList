package com.victorashino.applist.controller;

import android.util.Log;

import com.victorashino.applist.model.Person;

public class PersonController {

    public void save(Person pessoa) {
        Log.d("MVC_Controller", "Salvo " + pessoa.toString());
    }

}
