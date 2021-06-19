package clases;

import helper.Address;
import helper.Gender;
import helper.Name;
import helper.PerthDate;
import interfaces.Work;

import java.util.Scanner;

public class Employee extends Human implements Work {
    private static int numberOfEmployee; //increases automatically
    private final int id; //increases automatically
    private String jobTitle;
    private float salary;

    public Employee(Name name, Address address, Gender gender, PerthDate perthDate, String jobTitle, float salary) {
        super(name, address, gender, perthDate);
        id = ++numberOfEmployee;
        this.jobTitle = jobTitle;
        this.salary = salary;
        if (salary < 0) {
            setSalary(salary);
        }
    }

    public int getId() {
        return id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public float getSalary() {
        return salary;
    }

    @Override
    public void setSalary(float salary) {
        if (salary < 0){
            Scanner in = new Scanner(System.in);
            System.out.println("wrong input! salary must be positive");
            try {
                setSalary(in.nextFloat());
            } catch (Exception e){
                System.out.println("wrong input! enter numbers like 1234.56");
                setSalary(salary);
            }
            return ;
        }
        this.salary = salary;
    }

    @Override
    public boolean hasWork(){
        return jobTitle != null;
    }

    @Override
    public void getMetadata(){
        System.out.printf("%-3.3s ", "id");
        super.getMetadata();
        System.out.printf(" %-14.14s %-6.6s\n", "jop title", "salary");
    }

    @Override
    public void getRecord(){
        System.out.printf("%-3.3s ", id);
        super.getRecord();
        System.out.printf(" %-14.14s %-6.6s\n",(jobTitle == null ? "not working" : jobTitle), salary);
    }

    @Override
    public void getFullMetadata(){
        System.out.printf("%-3.3s ", "id");
        super.getFullMetadata();
        System.out.printf(" %-14.14s %-6.6s\n", "jop title", "salary");
    }

    @Override
    public void getFullRecord(){
        System.out.printf("%-3.3s ", id);
        super.getFullRecord();
        System.out.printf(" %-14.14s %-6.6s\n",(jobTitle == null ? "not working" : jobTitle), salary);
    }

}
