package com.saniazt.springCRUD.models;


import javax.validation.constraints.*;

public class Person {

    private int id;
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    private String name;
    @Min(value = 0, message = "Age should be greater than 0")
    private int age;
    @NotEmpty(message = "Email should not be empty")
    @Email(message = "Email should be valid")
    private String email;
    private int adminOrNot;

    // Страна, Город, Индекс(6 цифр)
    @Pattern(regexp = "[A-Z]\\w+, [A-Z]\\w+, \\d{6}", message = "Your address should be in thi format: Country, City, Postal Code(6 digits)")
    private String address;


    public Person() {
    }

    public Person(int id, String name, int age, String email, String address, int adminOrNot) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
        this.adminOrNot = adminOrNot;

    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAdminOrNot() {
        return adminOrNot;
    }

    public void setAdminOrNot(int adminOrNot) {
        this.adminOrNot = adminOrNot;
    }
}
