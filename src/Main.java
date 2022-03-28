import Enums.Careers;
import Repository.PersonsRepository;
import Survey.Survey;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PersonsRepository personsRepository = new PersonsRepository();
        Survey survey = new Survey();
        Scanner scan = new Scanner(System.in);

        int option = -1;

        System.out.println("Bienvenido al sistema de encuestas!\n");
        System.out.println("\n-------------------------------------\n");

        do {

            System.out.println("Encuestas Realizadas: "
                    + personsRepository.getTotalPersons()
                    + "\n Encuesta numero: "
                    + (personsRepository.getTotalPersons() + 1));

            survey.makeForm();

            if(!survey.getPerson().getName().isEmpty()){
                personsRepository.addPerson(survey.getPerson().getJob().getCareer(),survey.getPerson());
            }

            System.out.println("¿Deseas entrevistar a otra persona?");
            System.out.println("1.- SI");
            System.out.println("0.- No");

            option = scan.nextInt();

            if(option == 1){
                survey.resetData();
            }
        }while(option!=0);

        System.out.println("\n-----------------------------------------------------\n");
        personsRepository.getPercentagesByCareer();
        System.out.println("el salario promedio de los ingenieros es de: " + personsRepository.getCareerSalary(Careers.INGENIERO));
        System.out.println("el salario promedio de los abogados es de: " + personsRepository.getCareerSalary(Careers.ABOGADO));
        System.out.println("el salario promedio de las otras profesiones es de: " + personsRepository.getCareerSalary(Careers.OTRA));
    }
}