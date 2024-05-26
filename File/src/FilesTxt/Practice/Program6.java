package FilesTxt.Practice;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Program6 {
    public static void main(String[] args) throws IOException {//קרית גודל המערך בקובץ

        File file = new File("D:\\קוד\\File\\numbers.txt");
        Scanner s = new Scanner(file);

        int numOFElements = s.nextInt();
        int[] arr = new int[numOFElements];
        for (int i = 0; i < arr.length -1; i++) {
            arr[i] = s.nextInt();
        }

        System.out.println("The array: ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        s.close();
    }


}
