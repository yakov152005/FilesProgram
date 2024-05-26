package FilesTxt.PointsProgram;

import java.io.FileNotFoundException;
public class PolygonProgram {
    public static void main(String[] args) throws FileNotFoundException {
        savePolygonToFile();
        readPolygonFromFile();
    }

    public static void savePolygonToFile() throws FileNotFoundException {
        Point[] trianglePoint = new Point[3];
        for (int i = 0; i < trianglePoint.length; i++) {
            trianglePoint[i] = new Point(i*10,i*10);
        }

        Polygon polygon = new Polygon(trianglePoint,"red");
        polygon.save("polygon.txt");
        System.out.println(polygon);
    }
    public static void readPolygonFromFile()throws FileNotFoundException{
        Polygon polygon = new Polygon("polygon.txt");
        System.out.println(polygon);
    }
}
