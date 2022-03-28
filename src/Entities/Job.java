package Entities;

import Enums.Careers;

public class Job {
    private Careers career;
    private int salary;

    public Job(Careers career, int salary) {
        this.setCareer(career);
        this.setSalary(salary);
    }

    public Careers getCareer() {
        return career;
    }

    public void setCareer(Careers career) {
        this.career = career;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
