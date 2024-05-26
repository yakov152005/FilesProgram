package FilesTxt.PointsProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Point {
    private int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public Point(String fileName) throws FileNotFoundException { //לקרוא את המידע מהבנאי
        File file = new File(fileName);
        Scanner s = new Scanner(file);

        this.x = s.nextInt();
        this.y = s.nextInt();

        s.close();
    }

    public Point(Scanner s)throws FileNotFoundException{
        this.x = s.nextInt();
        this.y = s.nextInt();
    }


    public void save(String fileName)throws FileNotFoundException { // הקובץ שומר את עצמו על ידי המתודה
        File file = new File(fileName);
        PrintWriter printWriter = new PrintWriter(file);

        printWriter.println(getX());
        printWriter.println(getY());

        printWriter.close();
    }

    public void saveWithoutCloseForArr(PrintWriter printWriter) {
        printWriter.println(x);
        printWriter.println(y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }



    @Override
    public String toString() {
        return "(" + this.x +", " + this.y +")";
    }
}
