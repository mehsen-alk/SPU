package clases;

import helper.Address;
import helper.Gender;
import helper.Name;
import helper.PerthDate;
import interfaces.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Doctor extends Human implements Specialization, Work {
    private static int numberOfDoctors = 0; //increases automatically
    private final int id; //increases automatically
    private String specialization;
    private ArrayList<String> courses;
    private float salary;

    public Doctor(Name name, Address address, Gender gender, PerthDate perthDate, String specialization, ArrayList<String> courses, float salary) {
        super(name, address, gender, perthDate);
        id = ++numberOfDoctors;
        this.specialization = specialization;
        this.courses = courses;
        this.salary = salary;
        if (salary < 0) {
            setSalary(salary);
        }
    }

    public int getId(){
        return id;
    }

    @Override
    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    @Override
    public String getSpecialization() {
        return specialization;
    }

    @Override
    public boolean hasSpecialization() {
        return specialization != null;
    }

    public void setCourses(ArrayList<String> courses){
        this.courses = courses;
    }



    public ArrayList<String> getCourses(){
        return courses;
    }

    public void printCourses(){
        for (String c: courses) {
            System.out.print(c + ", ");
        }
    }

    @Override
    public void setSalary(float salary) {
        // check if salary was negative
        if (salary < 0){
            Scanner in = new Scanner(System.in);
            System.out.println("wrong input! salary must be positive");
            try {
                setSalary(in.nextFloat());
            } catch (Exception e){
                System.out.println("wrong input! enter numbers like 1234.56");
                //re_enter the salary
                setSalary(salary);
            }
            return ;
        }
        this.salary = salary;
    }

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    public boolean hasWork() {
        return courses.size() > 0;
    }

    @Override
    public void getRecord(){
        System.out.printf("%-3.3s ", id);
        super.getRecord();
        System.out.printf(" %-10.10s\n", (hasWork() ? "yes" : "no"));
    }

    @Override
    public void getMetadata(){
        System.out.printf("%-3.3s ", "id");
        super.getMetadata();
        System.out.printf(" %-10.10s\n", "teaching");
    }

    @Override
    public void getFullRecord(){
        System.out.printf("%-3.3s ", getId());
        super.getFullRecord();
        System.out.printf(" %-16.16s %-10.10s ", specialization, salary);
        if (hasWork()) {
            printCourses();
        } else {
            System.out.print("not teaching");
        }
        System.out.println();
    }

    @Override
    public void getFullMetadata(){
        System.out.printf("%-3.3s ", "id");
        super.getFullMetadata();
        System.out.printf(" %-16.16s %-10.10s %-10.10s", "specialization", "salary", "courses");
        System.out.println();
    }
}
