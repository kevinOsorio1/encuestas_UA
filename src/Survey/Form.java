package Survey;

import Enums.Careers;
import Enums.Gender;

import java.util.Scanner;

public class Form {
    private String name;
    private int age;
    private Gender gender;
    private Careers career;
    private int salary;
    private InputData input;

    public Form() {
        this.name = "";
        this.age = 0;
        this.gender = null;
        this.career = null;
        this.salary = 0;
        this.input = new InputData();
    }

    public String getName() {
        return name;
    }

    private void inputReset(){
        this.input = new InputData();
    }
    public void setName() {
        this.input.textScan("Ingresa el nombre del encuestado");
        this.name = this.input.getText();
        this.inputReset();
    }

    public int getAge() {
        return age;
    }

    public void setAge() {
        this.input.numberScan("Ingresa la edad del encuestado");
        this.age = this.input.getNumber();
        this.inputReset();
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender() {
        int[] options = {1,2};
        this.input.optionScan("Ingresa el genero del encuestado \n 1.- Masculino\n 2.- Femenino",options);
        if(this.input.getNumber() == 1){
            this.gender = Gender.MASCULINO;
            return;
        }
        this.gender= Gender.FEMENINO;
        this.inputReset();
    }

    public Careers getCareer() {
        return career;
    }

    public void setCareer() {
        int[] options = {1,2,3};
        this.input.optionScan("Ingresa la profesion del encuestado \n 1.- Ingeniero\n 2.- Abogado\n 3.- Otra",options);
        this.career = switch (this.input.getNumber()) {
            case 1 -> Careers.INGENIERO;
            case 2 -> Careers.ABOGADO;
            default -> Careers.OTRA;
        };
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary() {
        this.input.numberScan("Ingresa el salario del encuestado");
        this.salary = this.input.getNumber();
        this.inputReset();

    }
}
