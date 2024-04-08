package com.victorashino.applist.model;

import androidx.annotation.NonNull;

public class Person {

    private String firstName;
    private String lastName;
    private String desiredCourse;
    private String contactPhone;

    public Person() {}

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDesiredCourse() {
        return desiredCourse;
    }

    public void setDesiredCourse(String desiredCourse) {
        this.desiredCourse = desiredCourse;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    @NonNull
    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", desiredCourse='" + desiredCourse + '\'' +
                ", contactPhone='" + contactPhone + '\'' +
                '}';
    }
}
