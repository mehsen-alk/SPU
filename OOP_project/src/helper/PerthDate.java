package helper;

import java.util.Scanner;
import java.util.Date;

public class PerthDate {
    public int year;
    public int month;
    public int day;

    public PerthDate() {}

    public PerthDate(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public void setPerthDay(){
        setYear();
        setMonth();
        setDay();
    }

    public void setYear(){
        Scanner in = new Scanner(System.in);
        Date date = new Date();

        System.out.print("enter year number: ");
        try{
            year = in.nextInt();
        } catch (Exception e){
            System.out.println("enter number only");
            setYear();
        }
        if (date.getYear() + 1900 < year){
            System.out.println("wrong date!\n year must be equal or less than " + (date.getYear() + 1900));
            setYear();
        }
    }

    public void setMonth(){
        Scanner in = new Scanner(System.in);
        Date date = new Date();

        System.out.print("enter month number: ");
        try{
            month = in.nextInt();
        } catch (Exception e){
            System.out.println("enter number only");
            setMonth();
        }

        if (month > 12 || month < 1){
            System.out.println("wrong date!\nmonth should be between 1 and 12");
            setMonth();
        }
        else if(date.getYear() + 1900 == year && (date.getMonth() + 1) < month){
            System.out.println("wrong date!\nmonth must be  equal or less than " + (date.getMonth() + 1));
            setMonth();
        }
    }

    public void setDay(){
        Scanner in = new Scanner(System.in);
        Date date = new Date();

        System.out.print("enter day number: ");
        try{
            day = in.nextInt();
        } catch (Exception e) {
            System.out.println("enter numbers only");

        }
        if (day > 31 || day < 1){
            System.out.println("wrong date!\n" +
                    "enter numbers between 1 and 31");
            setDay();
        }
    }

    public int getAge(){
        Date date = new Date();
        return (date.getYear() + 1900) - year;
    }
}
