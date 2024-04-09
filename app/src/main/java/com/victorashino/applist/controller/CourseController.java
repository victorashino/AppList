package com.victorashino.applist.controller;

import com.victorashino.applist.model.Course;

import java.util.ArrayList;
import java.util.List;

public class CourseController {

    private List listCourses;

    public List getListCourses() {
        listCourses = new ArrayList<Course>();

        listCourses.add(new Course("Java"));
        listCourses.add(new Course("Android"));
        listCourses.add(new Course("PHP"));
        listCourses.add(new Course("Python"));
        listCourses.add(new Course("Kotlin"));
        listCourses.add(new Course("Java EE"));
        listCourses.add(new Course("C#"));

        return listCourses;
    }

    public ArrayList<String> dataForSpiner() {

        ArrayList<String> data = new ArrayList<>();

        for (int i = 0; i < getListCourses().size(); i++) {
            Course object = (Course) getListCourses().get(i);
            data.add(object.getDesiredCourse());
        }
        return data;
    }

}
