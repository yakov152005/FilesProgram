package FilesTxt.PointsProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PointProgram {
    public static void main(String[] args) throws FileNotFoundException {
        createPoint();//יצירת נק ושמירתם בקובץ וקריאתם
        createArrPoint();//יצירת מערך אובייקטים ושמירתו בקובץ

        //קריאת מערך אובייקטים מקובץ
      File file = new File("point.txt");
      Scanner s = new Scanner(file);

      int numOfPoints = s.nextInt();
      Point[] arrRead = new Point[numOfPoints];
        for (int i = 0; i < arrRead.length; i++) {
            arrRead[i] = new Point(s);
        }
        s.close();

        System.out.println("The points is --->");
        for (int i = 0; i < arrRead.length; i++) {
            System.out.println(arrRead[i].toString());
        }

    }
    public static void readFromFile(Point point) throws FileNotFoundException {
        File file = new File("D:\\קוד\\File\\points.txt");
        Scanner s = new Scanner(file);
        while (s.hasNext()){
            int num = s.nextInt();
            System.out.print(num +" ");
        }
        System.out.println();
        s.close();
    }
    public static void createPoint() throws FileNotFoundException {//יצירת נקודות ושמירתם בקובץ
        Point point = new Point(3,4);
        point.save("points2.txt");
       Point p = new Point("points2.txt");
        System.out.println(p);

        p.setX(40);
        p.setY(200);
        p.save("points2.txt");
        System.out.println("p: " + p);

        Point p2 = new Point(3,4);
        p2.save("points3.txt");


        Point p3 = new Point("points3.txt");
        System.out.println("p3: " + p3);
    }
    public static void createArrPoint() throws FileNotFoundException {
        Point[] arr = new Point[3];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Point(i*10,i*10);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i].toString() +" ");
        }

        File file = new File("point.txt");
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(arr.length);//שמירת גודל בשביל מערך אחר במידה ונרצה
        for (int i = 0; i < arr.length; i++) {
            arr[i].saveWithoutCloseForArr(printWriter);
            //arr[i].save("points.txt"); //בקובץ מופיע רק האוביקס האחרון
            //כל פעולה של save דורסים את התוכן הקיים
        }
        printWriter.close();
    }
}
