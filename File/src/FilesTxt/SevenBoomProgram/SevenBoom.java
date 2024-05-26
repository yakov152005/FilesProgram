package FilesTxt.SevenBoomProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SevenBoom {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("@ Welcome to play 7||boom @");
        boolean isValidInput = false;
        int choose = 0;
        while (!isValidInput) {
            try {
                System.out.println("Choose a number: ");
                choose = s.nextInt();
                isValidInput = true;
            } catch (InputMismatchException e) {
                System.out.println("You need to input integer, try again..");
                s.nextLine();
            }
        }
        isValidInput =false;
        String nameFile = "";
        while (!isValidInput) {
                System.out.println("Enter a name file: ");
                nameFile = s.next();
                if (nameFile.contains(".txt")){
                    saveNumbersForSevenBoom(nameFile, choose);
                    isValidInput = true;
                }else {
                    System.out.println("You need to input String with a end (.txt), try again..");
            }
        }
        System.out.println("Please check the file.");
        System.out.println("|Game Over|");

    }
    public static Scanner s = new Scanner(System.in);
    public static void saveNumbersForSevenBoom(String filename,int num)throws FileNotFoundException {
        File file = new File(filename);
        PrintWriter printWriter = new PrintWriter(file);
        char seven = '7';
        for (int i = 0; i <= num; i++) {
            String newNum = String.valueOf(i);
            try {
                if (newNum.contains(seven + "") || i % 7 == 0) {
                    printWriter.print("Boom" + "\n");
                } else {
                    printWriter.println(i);
                }
            }catch (IndexOutOfBoundsException e){
                System.out.println(e.getMessage());
            }
        }
        printWriter.close();
    }
}
