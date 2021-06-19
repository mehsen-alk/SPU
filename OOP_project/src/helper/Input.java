package helper;

import java.util.Scanner;

public class Input {
    public static String getString(String inputMassage, String errorMassage) {
        Scanner in = new Scanner(System.in);
        String temp;
        System.out.print(inputMassage);
        try {
            temp = in.nextLine();
        } catch (Exception e) {
            System.out.println(errorMassage);
            temp = getString(inputMassage, errorMassage);
        }
        return (temp.equals("0") ? null : temp);
    }

    public static int getInt(String inputMassage, String errorMassage){
        Scanner in = new Scanner(System.in);
        int x;
        System.out.print(inputMassage);
        try{
            x = in.nextInt();
        } catch (Exception e){
            System.out.println(errorMassage);
            x = getInt(inputMassage, errorMassage);
        }
        return x;
    }

    public static int getInt(String inputMassage){
        Scanner in = new Scanner(System.in);
        int x;
        System.out.print(inputMassage);
        try{
            x = in.nextInt();
        } catch (Exception e){
            System.out.println("wrong input! enter number only");
            x = getInt(inputMassage);
        }
        return x;
    }

    public static float getFloat(String inputMassage, String errorMassage){
        Scanner in = new Scanner(System.in);
        float x;
        System.out.print(inputMassage);
        try{
            x = in.nextFloat();
        } catch (Exception e){
            System.out.println(errorMassage);
            x = getFloat(inputMassage, errorMassage);
        }
        return x;
    }
}
