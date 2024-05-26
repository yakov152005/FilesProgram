package FilesTxt.PointsProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Polygon {
    private Point[] allPoints;
    private String color;

    public Polygon(Point[] allPoints,String color){
        this.allPoints = new Point[allPoints.length];
        for (int i = 0; i < this.allPoints.length; i++) {
            this.allPoints[i] = new Point(allPoints[i].getX(),allPoints[i].getY());
        }
        this.color = color;
    }
    public Polygon(String fileName)throws FileNotFoundException{// קורא מהקובץ
        File file = new File(fileName);
        Scanner s = new Scanner(file);

        int numOfPoints = s.nextInt();
        allPoints = new Point[numOfPoints];
        for (int i = 0; i < allPoints.length; i++) {
            allPoints[i] = new Point(s);
        }

        s.close();
    }
    public void save(String fileName)throws FileNotFoundException{
        File file = new File(fileName);
        PrintWriter printWriter = new PrintWriter(file);

        printWriter.println(allPoints.length);
        for (int i = 0; i < allPoints.length; i++) {
            allPoints[i].saveWithoutCloseForArr(printWriter);
        }
        printWriter.println(color);
        printWriter.close();
    } // שומר בקובץ
    public String toString(){
        StringBuilder builder = new StringBuilder("FilesTxt.PointsProgram.Polygon has " + allPoints.length + " points:"
        +"\n");
        for (int i = 0; i < allPoints.length; i++) {
            builder.append(allPoints[i].toString());
        }
        builder.append("Color: ").append(this.color);
        return builder.toString();
    }
}
