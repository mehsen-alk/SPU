import clases.*;
import helper.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    static public void main(String []args){
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Doctor> doctors = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;
        boolean end = false;
        boolean addPresetRecords = false;
        while (!end){
            System.out.println("------------------------------------------------------------------------------------");
            System.out.println("enter:\n\n" +
                    "1_ add new object\n" +
                    "2_ edit an object\n" +
                    "3_ delete an object\n" +
                    "4_ search for an object\n" +
                    "5_ get records from an object type\n" +
                    "6_ get records from all object's type\n" +
                    "7_ add preset records\n" +
                    "8_ exit\n");
            choice = Input.getInt("enter your choice: ", "wrong input! enter number only");
            System.out.println("\n------------------------------------------------------------------------------------");
            switch (choice){
                case 1: // add new object
                    boolean done = false;
                    while (!done){
                        System.out.println("what type of object you want to add ?\n" +
                                "1_ Student\n" +
                                "2_ Doctor\n" +
                                "3_ Employee");
                        choice = Input.getInt("enter your choice: ", "wrong input! enter number only");
                        System.out.println("\n-------------------------------");
                        Name name = new Name();
                        Address address = new Address();
                        Gender gender = Gender.not_set;
                        PerthDate perthDate = new PerthDate();

                        if(!(choice < 1 || choice > 3)) {

                            name.setName();

                            System.out.println("\n\t* address *");
                            address.setAddress();

                            System.out.println("\n\t* gender * \n" +
                                    "1_ male\n" +
                                    "2_ female\n" +
                                    "3_not set");
                            int choice1 = 0;
                            while (choice1 < 1 || choice1 > 3) {
                                choice1 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                switch (choice1) {
                                    case 1 -> gender = Gender.male;
                                    case 2 -> gender = Gender.female;
                                    case 3 -> gender = Gender.not_set;
                                }
                            }

                            System.out.println("\n\t* berth date *");
                            perthDate.setPerthDay();
                        }

                        switch (choice){
                            case 1: // add student
                                System.out.println("\n\t* student data *");
                                String university = Input.getString("enter university name: ", "wrong input! enter again");
                                String college = Input.getString("enter college name: ", "wrong input! enter again");
                                String specialization = Input.getString("enter specialization name: ", "wrong input! enter again");

                                float gpa = -1;
                                while(gpa < 0 || gpa > 4){
                                    gpa = Input.getFloat("enter gpa: ", "wrong input! enter numbers from 0.0 to 4.0");
                                }
                                Student student = new Student(name, address, gender, perthDate, university, college, specialization, gpa);
                                students.add(student);
                                done = true;
                                break; // case 1 break

                            case 2: // add doctor
                                String specializatioN = Input.getString("enter specialization name: ", "wrong input! enter again");
                                ArrayList<String> courses = new ArrayList<>();
                                boolean done1 = false;
                                while (!done1){
                                    String temp = Input.getString("enter course name or 0 to skip", "wrong input! enter again");
                                    if (temp == null) done1 = true;
                                    else courses.add(temp);
                                }

                                float salary = Input.getFloat("enter salary: ", "wrong input! enter again");
                                while (salary < 0){
                                    System.out.println("salary must be positive");
                                    salary = Input.getFloat("enter salary: ", "wrong input! enter again");
                                }

                                Doctor doctor = new Doctor(name, address, gender, perthDate, specializatioN, courses, salary);
                                doctors.add(doctor);
                                done = true;
                                break;

                            case 3: // add employee
                                String jobTitle = Input.getString("enter job title", "wrong input enter again");
                                float salary1 = Input.getFloat("enter salary: ", "wrong input! enter again");
                                while (salary1 < 0){
                                    System.out.println("salary must be positive");
                                    salary1 = Input.getFloat("enter salary: ", "wrong input! enter again");
                                }
                                Employee employee = new Employee(name, address, gender, perthDate, jobTitle, salary1);
                                employees.add(employee);
                                done = true;
                                break;

                            default :
                                System.out.println("enter number from 1 to 3!");

                        }
                    }
                    break; // end case 1 (add new object);

                case 2: // edit an object
                    System.out.println("what type of object you want to edit ?\n" +
                            "1_ Student\n" +
                            "2_ Doctor\n" +
                            "3_ Employee");

                    choice = Input.getInt("enter your choice: ", "wrong input! enter number only");
                    switch (choice){
                        case 1: //edit student
                            int studentId = Input.getInt("enter student id: " , "wrong input! enter numbers only");
                            Student student = null;
                            int i = 0;
                            for (Student temp: students){
                                if (temp.getId() == studentId){
                                    student = temp;
                                    break;
                                }
                                i++;
                            }
                            if(student == null) {
                                System.out.println("\n------------------\n" +
                                        "student not found!\n" +
                                        "------------------\n");
                                break;
                            }
                            else{
                                System.out.println("1_ edit full record\n" +
                                        "2_ edit one field");
                                choice = Input.getInt("enter your choice: ", "wrong input! enter number only");
                                switch (choice){
                                    case 1: // edit full record
                                        Name name = new Name();
                                        name.setName();
                                        student.setName(name);

                                        Address address = new Address();
                                        address.setAddress();
                                        student.setAddress(address);

                                        Gender gender = Gender.not_set  ;
                                        System.out.println("select gender: \n" +
                                                "1_ male\n" +
                                                "2_ female\n" +
                                                "3_not set");
                                        int choice1 = 0;
                                        while (choice1 < 1 || choice1 > 3) {
                                            choice1 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                            switch (choice1) {
                                                case 1 -> gender = Gender.male;
                                                case 2 -> gender = Gender.female;
                                                case 3 -> gender = Gender.not_set;
                                            }
                                        }
                                        student.setGender(gender);

                                        PerthDate perthDate = new PerthDate();
                                        perthDate.setPerthDay();
                                        student.setPerthDate(perthDate);

                                        String university = Input.getString("enter university name: ", "wrong input! enter again");
                                        student.setUniversity(university);

                                        String college = Input.getString("enter college name: ", "wrong input! enter again");
                                        student.setCollege(college);

                                        String specialization = Input.getString("enter specialization name: ", "wrong input! enter again");
                                        student.setSpecialization(specialization);

                                        student.setGpa();
                                        students.set(i, student);
                                        System.out.println("Success!");
                                        break;

                                    case 2: //edit one field
                                        System.out.println("select field to edit\n" +
                                                "1_ Name\n" +
                                                "2_ Address\n" +
                                                "3_ Gender\n" +
                                                "4_ perth date\n" +
                                                "5_ university\n" +
                                                "6_ college\n" +
                                                "7_ specialization\n" +
                                                "8_ gpa");
                                        choice = Input.getInt("enter your choice", "wrong input! enter number only");
                                        switch (choice){
                                            case 1:
                                                Name name1 = new Name();
                                                name1.setName();
                                                student.setName(name1);
                                                System.out.println("Success!");
                                                break;

                                            case 2:
                                                Address address1 = new Address();
                                                address1.setAddress();
                                                student.setAddress(address1);
                                                System.out.println("Success!");
                                                break;

                                            case 3:
                                                Gender gender1 = Gender.not_set  ;
                                                System.out.println("select gender: \n" +
                                                        "1_ male\n" +
                                                        "2_ female\n" +
                                                        "3_not set");
                                                int choice2 = 0;
                                                while (choice2 < 1 || choice2 > 3) {
                                                    choice2 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                                    switch (choice2) {
                                                        case 1 -> gender1 = Gender.male;
                                                        case 2 -> gender1 = Gender.female;
                                                        case 3 -> gender1 = Gender.not_set;
                                                    }
                                                }
                                                student.setGender(gender1);
                                                System.out.println("Success!");
                                                break;

                                            case 4:
                                                PerthDate perthDate1 = new PerthDate();
                                                perthDate1.setPerthDay();
                                                student.setPerthDate(perthDate1);
                                                System.out.println("Success!");
                                                break;

                                            case 5:
                                                String university1 = Input.getString("enter university name: ", "wrong input! enter again");
                                                student.setUniversity(university1);
                                                System.out.println("Success!");
                                                break;

                                            case 6:
                                                String college1 = Input.getString("enter college name: ", "wrong input! enter again");
                                                student.setCollege(college1);
                                                System.out.println("Success!");
                                                break;

                                            case 7:
                                                String specialization1 = Input.getString("enter specialization name: ", "wrong input! enter again");
                                                student.setSpecialization(specialization1);
                                                System.out.println("Success!");
                                                break;

                                            case 8:
                                                student.setGpa();
                                                students.set(i, student);
                                                System.out.println("Success!");
                                                break;

                                            default:
                                                System.out.println("wrong input you return to main list");
                                        }// end of select field
                                        break;

                                    default:
                                        System.out.println("wrong input you return to main list");
                                }
                            }
                            break; // end of  case 1 (student edit)

                        case 2: //edit doctor
                            int doctorId = Input.getInt("enter doctor id: " , "wrong input! enter numbers only");
                            Doctor doctor = null;
                            int i1 = 0;
                            for (Doctor temp: doctors){
                                if (temp.getId() == doctorId){
                                    doctor = temp;
                                    break;
                                }
                                i1++;
                            }
                            if(doctor == null) {
                                System.out.println("\n-----------------\n" +
                                        "doctor not found!\n" +
                                        "-----------------\n");
                                break;
                            }
                            else{
                                System.out.println("1_ edit full record\n" +
                                        "2_ edit one field");
                                choice = Input.getInt("enter your choice: ", "wrong input! enter number only");
                                switch (choice){
                                    case 1: //edit full record
                                        Name name = new Name();
                                        name.setName();
                                        doctor.setName(name);

                                        Address address = new Address();
                                        address.setAddress();
                                        doctor.setAddress(address);

                                        Gender gender = Gender.not_set  ;
                                        System.out.println("select gender: \n" +
                                                "1_ male\n" +
                                                "2_ female\n" +
                                                "3_not set");
                                        int choice1 = 0;
                                        while (choice1 < 1 || choice1 > 3) {
                                            choice1 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                            switch (choice1) {
                                                case 1 -> gender = Gender.male;
                                                case 2 -> gender = Gender.female;
                                                case 3 -> gender = Gender.not_set;
                                            }
                                        }
                                        doctor.setGender(gender);

                                        PerthDate perthDate = new PerthDate();
                                        perthDate.setPerthDay();
                                        doctor.setPerthDate(perthDate);

                                        String specialization = Input.getString("enter doctor specialization", "wrong input enter again");
                                        doctor.setSpecialization(specialization);

                                        ArrayList<String> courses = new ArrayList<>();
                                        boolean done1 = false;
                                        while (!done1){
                                            String temp = Input.getString("enter course name or 0 to skip", "wrong input! enter again");
                                            if (temp == null) done1 = true;
                                            else courses.add(temp);
                                        }
                                        doctor.setCourses(courses);

                                        float salary = Input.getFloat("enter salary: ", "wrong input! enter again");
                                        while (salary < 0){
                                            System.out.println("salary must be positive");
                                            salary = Input.getFloat("enter salary: ", "wrong input! enter again");
                                        }
                                        doctor.setSalary(salary);

                                        doctors.set(i1, doctor);
                                        System.out.println("Success!");
                                        break;

                                    case 2: //edit one field
                                        System.out.println("select field to edit\n" +
                                                "1_ Name\n" +
                                                "2_ Address\n" +
                                                "3_ Gender\n" +
                                                "4_ perth date\n" +
                                                "5_ specialization\n" +
                                                "6_ courses\n" +
                                                "7_ salary\n");
                                        choice = Input.getInt("enter your choice", "wrong input! enter number only");
                                        switch (choice){
                                            case 1:
                                                Name name1 = new Name();
                                                name1.setName();
                                                doctor.setName(name1);
                                                System.out.println("Success!");
                                                break;

                                            case 2:
                                                Address address1 = new Address();
                                                address1.setAddress();
                                                doctor.setAddress(address1);
                                                System.out.println("Success!");
                                                break;

                                            case 3:
                                                Gender gender1 = Gender.not_set  ;
                                                System.out.println("select gender: \n" +
                                                        "1_ male\n" +
                                                        "2_ female\n" +
                                                        "3_not set");
                                                int choice2 = 0;
                                                while (choice2 < 1 || choice2 > 3) {
                                                    choice2 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                                    switch (choice2) {
                                                        case 1 -> gender1 = Gender.male;
                                                        case 2 -> gender1 = Gender.female;
                                                        case 3 -> gender1 = Gender.not_set;
                                                    }
                                                }
                                                doctor.setGender(gender1);
                                                System.out.println("Success!");
                                                break;

                                            case 4:
                                                PerthDate perthDate1 = new PerthDate();
                                                perthDate1.setPerthDay();
                                                doctor.setPerthDate(perthDate1);
                                                System.out.println("Success!");
                                                break;

                                            case 5:
                                                String specialization1 = Input.getString("enter specialization1 name: ", "wrong input! enter again");
                                                doctor.setSpecialization(specialization1);
                                                System.out.println("Success!");
                                                break;

                                            case 6:
                                                ArrayList<String> courses1 = new ArrayList<>();
                                                boolean done2 = false;
                                                while (!done2){
                                                    String temp = Input.getString("enter course name or 0 to skip", "wrong input! enter again");
                                                    if (temp == null) done2 = true;
                                                    else courses1.add(temp);
                                                }
                                                doctor.setCourses(courses1);
                                                System.out.println("Success!");
                                                break;

                                            case 7:
                                                float salary1 = Input.getFloat("enter salary: ", "wrong input! enter again");
                                                while (salary1 < 0){
                                                    System.out.println("salary must be positive");
                                                    salary1 = Input.getFloat("enter salary: ", "wrong input! enter again");
                                                }
                                                doctor.setSalary(salary1);
                                                System.out.println("Success!");
                                                break;

                                            default:
                                                System.out.println("wrong input you return to main list");
                                        }// end of select field
                                        break;

                                    default:
                                    System.out.println("wrong input you return to main list");
                                }
                            }
                            break; // end of case 2 (doctor edit)

                        case 3: // edit employee
                            int employeeId = Input.getInt("enter doctor id: " , "wrong input! enter numbers only");
                            Employee employee = null;
                            int i2 = 0;
                            for (Employee temp: employees){
                                if (temp.getId() == employeeId){
                                    employee = temp;
                                    break;
                                }
                                i2++;
                            }
                            if(employee == null) {
                                System.out.println("\n-------------------\n" +
                                        "employee not found!\n" +
                                        "-------------------\n");
                                break;
                            }
                            else{
                                System.out.println("1_ edit full record\n" +
                                        "2_ edit one field");
                                choice = Input.getInt("enter your choice: ", "wrong input! enter number only");
                                switch (choice){
                                    case 1: //edit full record
                                        Name name = new Name();
                                        name.setName();
                                        employee.setName(name);

                                        Address address = new Address();
                                        address.setAddress();
                                        employee.setAddress(address);

                                        Gender gender = Gender.not_set  ;
                                        System.out.println("select gender: \n" +
                                                "1_ male\n" +
                                                "2_ female\n" +
                                                "3_not set");
                                        int choice1 = 0;
                                        while (choice1 < 1 || choice1 > 3) {
                                            choice1 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                            switch (choice1) {
                                                case 1 -> gender = Gender.male;
                                                case 2 -> gender = Gender.female;
                                                case 3 -> gender = Gender.not_set;
                                            }
                                        }
                                        employee.setGender(gender);

                                        PerthDate perthDate = new PerthDate();
                                        perthDate.setPerthDay();
                                        employee.setPerthDate(perthDate);

                                        String jopTitle = Input.getString("enter doctor jop title: ", "wrong input enter again");
                                        employee.setJobTitle(jopTitle);

                                        float salary = Input.getFloat("enter salary: ", "wrong input! enter again");
                                        while (salary < 0){
                                            System.out.println("salary must be positive");
                                            salary = Input.getFloat("enter salary: ", "wrong input! enter again");
                                        }
                                        employee.setSalary(salary);

                                        employees.set(i2, employee);
                                        System.out.println("Success!");
                                        break;

                                    case 2: //edit one field
                                        System.out.println("select field to edit\n" +
                                                "1_ Name\n" +
                                                "2_ Address\n" +
                                                "3_ Gender\n" +
                                                "4_ perth date\n" +
                                                "5_ jop title\n" +
                                                "6_ salary\n");
                                        choice = Input.getInt("enter your choice", "wrong input! enter number only");
                                        switch (choice){
                                            case 1:
                                                Name name1 = new Name();
                                                name1.setName();
                                                employee.setName(name1);
                                                System.out.println("Success!");
                                                break;

                                            case 2:
                                                Address address1 = new Address();
                                                address1.setAddress();
                                                employee.setAddress(address1);
                                                System.out.println("Success!");
                                                break;

                                            case 3:
                                                Gender gender1 = Gender.not_set  ;
                                                System.out.println("select gender: \n" +
                                                        "1_ male\n" +
                                                        "2_ female\n" +
                                                        "3_not set");
                                                int choice2 = 0;
                                                while (choice2 < 1 || choice2 > 3) {
                                                    choice2 = Input.getInt("your choice: ", "wrong input! enter number from 1 to 3");
                                                    switch (choice2) {
                                                        case 1 -> gender1 = Gender.male;
                                                        case 2 -> gender1 = Gender.female;
                                                        case 3 -> gender1 = Gender.not_set;
                                                    }
                                                }
                                                employee.setGender(gender1);
                                                System.out.println("Success!");
                                                break;

                                            case 4:
                                                PerthDate perthDate1 = new PerthDate();
                                                perthDate1.setPerthDay();
                                                employee.setPerthDate(perthDate1);
                                                System.out.println("Success!");
                                                break;

                                            case 5:
                                                String jopTitle1 = Input.getString("enter jop title: ", "wring input! enter again");
                                                employee.setJobTitle(jopTitle1);
                                                System.out.println("Success!");
                                                break;

                                            case 6:
                                                float salary1 = Input.getFloat("enter salary: ", "wrong input! enter again");
                                                while (salary1 < 0){
                                                    System.out.println("salary must be positive");
                                                    salary1 = Input.getFloat("enter salary: ", "wrong input! enter again");
                                                }
                                                employee.setSalary(salary1);
                                                System.out.println("Success!");
                                                break;

                                            default:
                                                System.out.println("wrong input you return to main list");
                                        }// end of select field
                                        break;

                                    default:
                                        System.out.println("wrong input you return to main list");
                                }
                            }
                            break; // end of  case 3 (employee edit)

                        default:
                            System.out.println("wrong input you return to main list");
                    }
                    break;// end of case 2 (edit an object)

                case 3: // delete an object
                    System.out.println("what type of object you want to delete ?\n" +
                            "1_ Student\n" +
                            "2_ Doctor\n" +
                            "3_ Employee");
                    choice = Input.getInt("your choice: ");
                    int index = 0;
                    switch (choice){
                        case 1: // delete student
                            int studentId = Input.getInt("enter student id: ");

                            for (Student student : students){
                                if (student.getId() != studentId) index++;
                                else{
                                    int i;
                                    for (i = index; i < students.size() - 1; i++){
                                        students.set(i, students.get(i + 1));
                                    }
                                    students.remove(i);
                                    break;
                                }
                            }
                            System.out.println("Success!");
                            break; // end of case 1 (delete student)

                        case 2: // delete doctor
                            int doctorId = Input.getInt("enter doctor id: ");

                            for (Doctor doctor : doctors){
                                if (doctor.getId() != doctorId) index++;
                                else{
                                    int i;
                                    for (i = index; i < doctors.size() - 1; i++){
                                        doctors.set(i, doctors.get(i + 1));
                                    }
                                    doctors.remove(i);
                                    break;
                                }
                            }
                            System.out.println("Success!");
                            break; // end case 2 (delete employee)

                        case 3: // delete employee
                            int employeeId = Input.getInt("enter employee id: ");

                            for (Employee employee : employees){
                                if (employee.getId() != employeeId) index++;
                                else{
                                    int i;
                                    for (i = index; i < employees.size() - 1; i++){
                                        employees.set(i, employees.get(i + 1));
                                    }
                                    employees.remove(i);
                                    break;
                                }
                            }
                            System.out.println("Success!");
                            break; // end case 3 (delete employee)

                        default:
                            System.out.println("wrong input! you return to main list");
                    }
                    break; // end of case 3 (delete an object)

                case 4: // search for an object
                    System.out.println("what type of object you want to search for it ?\n" +
                            "1_ Student\n" +
                            "2_ Doctor\n" +
                            "3_ Employee");
                    choice = Input.getInt("your choice: ");
                    switch (choice){
                        case 1: // search for an student
                            int studentId = Input.getInt("enter student id: ");
                            boolean found = false;
                            for (Student student : students){
                                if (student.getId() == studentId){
                                    student.getFullMetadata();
                                    student.getFullRecord();
                                    found = true;
                                }
                            }
                            if (!found) System.out.println("-------------------\n" +
                                                           "student not found !\n" +
                                    "-------------------\n");
                            break; // end of case 1 (search for an student)

                        case 2: // search for an doctor
                            boolean found1 = false;
                            int doctorId = Input.getInt("enter doctor id: ");
                            for (Doctor doctor : doctors){
                                if (doctor.getId() == doctorId){
                                    doctor.getFullMetadata();
                                    doctor.getFullRecord();
                                    found1 = true;
                                }
                            }
                            if (!found1) System.out.println("------------------\n" +
                                    "doctor not found !\n" +
                                    "------------------\n");
                            break; // end of case 2 (search for an doctor)

                        case 3: // search for an employee
                            int employeeId = Input.getInt("enter employee id: ");
                            boolean found2 = false;
                            for (Employee employee : employees){
                                if (employee.getId() == employeeId){
                                    employee.getFullMetadata();
                                    employee.getFullRecord();
                                    found2 = true;
                                }
                            }
                            if (!found2) System.out.println("--------------------\n" +
                                    "employee not found !\n" +
                                    "--------------------\n");
                            break; // end of case 3 (search for an employee)

                        default:
                            System.out.println("Wrong input! you return to main list");
                    }
                    break; // end of case 4 (search for an object)

                case 5: // get records from an object type
                    System.out.println("get records from\n" +
                            "1_ Student\n" +
                            "2_ Doctor\n" +
                            "3_ Employee");
                    choice = Input.getInt("enter your choice: ");
                    switch (choice){
                        case 1: // get students records
                            if (students.size() == 0)
                                System.out.println("there is no students yet");
                            else students.get(0).getMetadata();

                            for (Student student : students)
                                student.getRecord();
                            break; // end of case 1 (get student records)

                        case 2: // get doctors records
                            if (doctors.size() == 0)
                                System.out.println("there is no doctors yet");
                            else doctors.get(0).getMetadata();

                            for (Doctor doctor : doctors)
                            doctor.getRecord();
                            break; // end of case 2 (get doctors records)

                        case 3: // get employees records
                            if (employees.size() == 0)
                                System.out.println("there is no employees yet");
                            else employees.get(0).getMetadata();

                            for (Employee employee : employees)
                                employee.getRecord();
                            break; // end of case 3 (get employees records)

                        default:
                            System.out.println("wrong input! you return to main list");
                    }
                    break; // end of case 5 (get records from an object type)

                case 6: // get records from all objects type

                    if (students.size() == 0)
                        System.out.println("there is no students yet");
                    else students.get(0).getMetadata();

                    for (Student student : students)
                        student.getRecord();

                    System.out.println("\n");

                    if (doctors.size() == 0)
                        System.out.println("there is no doctors yet");
                    else doctors.get(0).getMetadata();

                    for (Doctor doctor : doctors)
                        doctor.getRecord();

                    System.out.println("\n");

                    if (employees.size() == 0)
                        System.out.println("there is no employees yet");
                    else employees.get(0).getMetadata();

                    for (Employee employee : employees)
                        employee.getRecord();
                    break; // end of case 6 (get records from all objects type)

                case 7: // add preset records
                    ObjectsBank objectsBank = new ObjectsBank();

                    Name name;
                    Address address;
                    Gender gender;
                    PerthDate perthDate;

                    String university, college, specialization, jobTitle;
                    ArrayList<String> courses;
                    float gpa, salary;

                    for (int i = 0, s = 0, d = 0, e = 0; i < 15; i++){
                        name = objectsBank.names[i];
                        address = objectsBank.addresses[i];
                        gender = objectsBank.genders[i];
                        perthDate = objectsBank.perthDates[i];

                        if (i < 5){ // student range
                            university = objectsBank.universities[s];
                            college = objectsBank.colleges[s];
                            specialization = objectsBank.studentSpecializations[s];
                            gpa = objectsBank.gpas[s];
                            s++;
                            students.add(new Student(name, address, gender, perthDate, university, college, specialization, gpa));
                        }
                        else if (i < 10){ // doctor range
                            specialization = objectsBank.doctorSpecialization[d];
                            courses = new ArrayList<>(0);
                            courses.addAll(Arrays.asList(objectsBank.courses[d]));
                            salary = objectsBank.doctorsSalaries[d];
                            d++;
                            doctors.add(new Doctor(name, address, gender, perthDate, specialization, courses, salary));
                        }
                        else{
                            jobTitle = objectsBank.jobTitle[e];
                            salary = objectsBank.employeesSalaries[e];
                            e++;
                            employees.add(new Employee(name, address, gender, perthDate, jobTitle, salary));
                        }
                    }
                    break; // end of case 7 (add preset records)

                case 8: // exit
                    end = true;
                    break; // end of case 8 (exit)

                default:
                    System.out.println("enter number from 1 to 8");
            }
        }
    }
}
