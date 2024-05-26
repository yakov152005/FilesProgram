package FilesTxt.Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
public class Program2 {
    public static void main(String[] args) {

        int point = readPointsFromFile();
        while (true) {
            Random random = new Random();
            int num1 = random.nextInt(10) + 1;
            int num2 = random.nextInt(10) + 1;
            System.out.println(num1 + "*" + num2 + "= ?");
            int result;
            System.out.println("Enter answer (To exit enter -999):");
            try {
                result = scanner.nextInt();
                if (result == -999) {
                    break;
                }
                boolean isCorrect = math(num1, num2, result);
                if (isCorrect) {
                    point++;
                    System.out.println("You answered correctly :)");
                } else {
                    point -= 3;
                    System.out.println("The answer is incorrect :(");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter an integer.");
                scanner.next(); // discard the invalid input
            }

            System.out.println("Your current point: " + point);
            savePointsToFile(point);
        }

        System.out.println("Your final point: " + point);
    }

    public static boolean math(int num1, int num2, int result) {
        return result == num1 * num2;
    }

    public static int readPointsFromFile() {
        try {
            File file = new File("D:\\קוד\\File\\POINTS_GAME.txt");
            if (file.exists()) {
                Scanner scanner = new Scanner(file);
                return scanner.nextInt();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static void savePointsToFile(int point) {
        try {
            FileWriter fileWriter = new FileWriter("D:\\קוד\\File\\POINTS_GAME.txt");
            fileWriter.write(String.valueOf(point));
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Scanner scanner = new Scanner(System.in);
}
