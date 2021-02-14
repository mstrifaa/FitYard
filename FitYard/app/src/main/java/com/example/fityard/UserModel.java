package com.example.fityard;

public class UserModel {

    public String lastName;
    public String firstName;
    public int id;

    public UserModel(int id, String firstName, String lastName){

        this.id=id;
        this.firstName=firstName;
        this.lastName=lastName;

    }

    @Override
    public String toString() {
        return "userModel{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", id=" + id +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
