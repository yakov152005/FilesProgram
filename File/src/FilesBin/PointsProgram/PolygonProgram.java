package FilesBin.PointsProgram;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Vector;

public class PolygonProgram {
    public static void main(String[] args) throws Exception{
        Point[] points = {
                new Point(1,2),
                new Point(3,6),
                new Point(5,8),
                new Point(8,2),
                new Point(7,7),
                new Point(1,4),
        };
        Polygon polygon = new Polygon(points,"Black");



        ObjectOutputStream saveFile = new ObjectOutputStream(new FileOutputStream("Polygon.dat"));
        Vector<Polygon> allPolygonPoints = new Vector<Polygon>();
        allPolygonPoints.add(polygon);
        saveFile.writeObject(allPolygonPoints);
        saveFile.close();
        System.out.println(allPolygonPoints +" Vector 1");


        ObjectInputStream readFile = new ObjectInputStream(new FileInputStream("Polygon.dat"));
        Vector<Polygon> readAllPolygonPoints;
        readAllPolygonPoints =(Vector<Polygon>)readFile.readObject();
        System.out.println(readAllPolygonPoints +" Vector 2");
        readFile.close();

        // transient אם נרצה לא לרשום שדה כלשהו לקובץ נוסיף לו
        // privte transient String password; דוגמא <---

    }
}
