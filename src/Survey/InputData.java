package Survey;

import java.util.Arrays;
import java.util.Scanner;

public class InputData {
    private String text;
    private int number;
    private Scanner scan;

    public InputData() {
        this.text = "";
        this.number = -1;
        this.scan = new Scanner(System.in);
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void numberScan(String requestText){
        do {
            System.out.println(requestText);
            this.number = scan.nextInt();
        }while (this.number == -1);
    }

    public void textScan(String requestText){
        do{
            System.out.println(requestText);
            this.text = scan.nextLine();
        }while(this.text.equals(""));
    }

    public void optionScan(String requestText, int[] options){
        do {
            System.out.println(requestText);
            this.number = scan.nextInt();
        }while(Arrays.binarySearch(options,this.number) <0);
    }
}



















