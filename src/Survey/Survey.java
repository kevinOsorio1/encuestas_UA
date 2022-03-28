package Survey;

import Entities.Job;
import Entities.Person;

public class Survey {
    private Person person;
    private Form form;

    public Survey() {
        this.person = new Person();
        this.form = new Form();
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Form getForm() {
        return form;
    }

    public void setForm(Form form) {
        this.form = form;
    }

    public void makeForm(){
        form.setName();
        form.setAge();
        form.setGender();
        form.setCareer();
        form.setSalary();
        Person newPerson = new Person(form.getName(),form.getAge(),form.getGender(),new Job(form.getCareer(),form.getSalary()));
        setPerson(newPerson);
    }
    public void resetData(){
        setPerson(new Person());
        setForm(new Form());
    }
}
