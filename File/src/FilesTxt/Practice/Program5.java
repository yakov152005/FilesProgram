package FilesTxt.Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Program5 {
    public static void main(String[] args) throws FileNotFoundException {//קריאת מערך מקובץ
        File file = new File("D:\\קוד\\File\\numbers.txt");
        Scanner s= new Scanner(file);

        while (s.hasNext()){//כל עוד יש מידע לקרוא הלולאה תמשיך (ז"א כל עוד לא סיים לקרוא)
            String num = s.nextLine();
            System.out.println(num);
        }
        s.close();
    }
}
