package FilesTxt.Practice;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class Program1 {
    public static void main(String[] args) throws Exception{

        double result = divisionCalculate();
        String res = result + " Yakov";
        System.out.println("Enter a file location: ");
        String file = s.next();
        readAndSaveFile(file,res);

    }
    public static void readAndSaveFile(String file,String res){
        file += "FILE_NAME.txt";
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(res);
            System.out.println("File listing succeeded");
            fileWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static double divisionCalculate(){
        double result = 0;
        try {
            System.out.println("Enter a number 1: ");
            int num = s.nextInt();
            System.out.println("Enter a number 2: ");
            int    num2 = s.nextInt();
            result =  num /num2;
            return result;
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("Something went wrong, please try again.. ");
        }
        return -1;
    }

    public static Scanner s = new Scanner(System.in);
}