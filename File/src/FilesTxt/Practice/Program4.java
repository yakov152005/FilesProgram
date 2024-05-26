package FilesTxt.Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Program4 {
    public static void main(String[] args)throws FileNotFoundException {
        File file = new File("D:\\קוד\\File\\checkToFile3.txt");
        readFile(file);
        PrintWriter printWriter = new PrintWriter(file); // לכתוב על הקובץ
        printWriter.print("Hey" + "\n");// כתיבה של המילה שלום
        for (int i = 1; i <=3 ; i++) {
            printWriter.print(i + "  ");// כתיב לקובץ של המספרים
        }
        printWriter.close();// סגירת קובץ
    }
    public static void readFile(File file) throws FileNotFoundException {
        Scanner s = new Scanner(file);//  הסקאנר קורא מהקובץ אשר מקבל כפרמטר לבנאי את הקובץ שמנו נרצה לקרוא
        String str = s.nextLine();
        System.out.println(str);
        for (int i = 0; i < 3; i++) {
            int num = s.nextInt();
            System.out.println(num);
        }
        s.close();
    }




}
