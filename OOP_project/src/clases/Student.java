package clases;

import helper.*;
import interfaces.Specialization;
import java.util.Scanner;

public class Student extends Human implements Specialization {

    private static int numberOfStudents = 0; //increases automatically
    private final int id; //increases automatically
    private String university;
    private String college;
    private String specialization;
    private float gpa;

    public Student() {
        id = ++numberOfStudents;
    }

    public Student(Name name, Address address, Gender gender, PerthDate perthDate, String university, String college, String specialization, float gpa) {
        super(name, address, gender, perthDate);
        id = ++numberOfStudents;
        this.university = university;
        this.college = college;
        this.specialization = specialization;
        setGpa(gpa);
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }

    public int getId() {
        return id;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    @Override
    public void setSpecialization(String specialization){
        this.specialization = specialization;
    }

    @Override
    public String getSpecialization(){
        return specialization;
    }

    @Override
    public boolean hasSpecialization(){
        return specialization != null;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        // check if gpa is wrong
        if (gpa > 4.0 || gpa < 0.0){
            System.out.println("wrong gpa! gpa must be between 0 and 4");
            // re-enter the gpa
            setGpa();
        }
        this.gpa = gpa;
    }

    public void setGpa(){
        Scanner in = new Scanner(System.in);
        try{
            gpa = in.nextFloat();
        } catch (Exception e) {
            System.out.println("wrong input! enter only numbers like 4.0");
            setGpa();
        }
        if (gpa > 4.0 || gpa < 0.0){
            System.out.println("wrong gpa!\ngpa must be between 0 and 4");
            setGpa();
        }
    }

    @Override
    public void getRecord(){
        System.out.printf("%-3.3s ", id);
        super.getRecord();
        System.out.printf(" %-15.15s %-4.4s\n",(hasSpecialization() ? specialization : college), gpa);
    }

    @Override
    public void getMetadata(){
        System.out.printf("%-3.3s ", "id");
        super.getMetadata();
        System.out.printf(" %-15.15s %-4.4s\n", "specialization", "gpa");
    }

    @Override
    public void getFullRecord(){
        System.out.printf("%-3.3s ", id);
        super.getFullRecord();
        System.out.printf(" %-13.13s %-10.10s %-15.14s %-3.3s\n",university, college, specialization, gpa);
    }

    @Override
    public void getFullMetadata(){
        System.out.printf("%-3.3s ", "id");
        super.getFullMetadata();
        System.out.printf(" %-13.13s %-10.10s %-15.14s %-3.3s\n" ,"university", "college", "specialization", "gpa");

    }


}
