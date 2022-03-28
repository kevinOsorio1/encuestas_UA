package Repository;

import Entities.Person;
import Enums.Careers;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class PersonsRepository {
    private HashMap<Careers,LinkedList<Person>> personsHashMap;

    public PersonsRepository() {
        this.personsHashMap = new HashMap<>();
    }

    public int getTotalPersons(){
        AtomicInteger total = new AtomicInteger();
        this.personsHashMap.values().forEach(people -> total.set(total.get() + people.size()));
        return total.get();
    }

    public void addPerson(Careers career,Person person){
        LinkedList<Person> persons = new LinkedList<>();
        persons.add(person);
        if(this.personsHashMap.containsKey(career)){
            persons.addAll(this.personsHashMap.get(career));
            this.personsHashMap.replace(career,persons);
            return;
        }
        this.personsHashMap.put(career,persons);
    }

    private LinkedList<Person> filterPersonsByCareer(Careers career){
        LinkedList<Person> filteredPersons = new LinkedList<>();
        if(this.personsHashMap.containsKey(career)){
            filteredPersons.addAll(this.personsHashMap.get(career));
        }
        return filteredPersons;
    }

    private float getCareerPercentage(Careers careers){
        if(this.getTotalPersons() >0){
            return (float) this.filterPersonsByCareer(careers).size()/ (float)this.getTotalPersons() * 100;
        }
        return 0;
    }

    public void getPercentagesByCareer(){
        System.out.println("% correspondiente a ingenieria : " + this.getCareerPercentage(Careers.INGENIERO) +"%"
                +  " \n % correspondiente a Abogado : " + this.getCareerPercentage(Careers.ABOGADO) + "%"
                +  " \n % correspondiente a Otro : " + this.getCareerPercentage(Careers.OTRA) + "%") ;
    }

    private float getSalaries(LinkedList<Person> persons){
        return (float) persons.stream().mapToInt(value -> value.getJob().getSalary()).reduce(0, Integer::sum);
    }

    public float getCareerSalary(Careers career){
        if(this.personsHashMap.containsKey(career)){
            return getSalaries(this.personsHashMap.get(career)) /  this.filterPersonsByCareer(career).size();
        }
        return 0;
    }
}
