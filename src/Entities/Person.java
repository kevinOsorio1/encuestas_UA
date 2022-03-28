package Entities;

import Enums.Gender;

public class Person {
    private String name;
    private int age;
    private Gender gender;
    private Job job;

    public Person(String name, int age, Gender gender,Job job) {
        this.setName(name);
        this.setAge(age);
        this.setGender(gender);
        this.setJob(job);
    }

    public Person() {
        this.setName("");
        this.setAge(0);
        this.setGender(null);
        this.setJob(null);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
