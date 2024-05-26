package FilesBin.PointsProgram;
import java.io.*;
import java.util.Vector;

public class PointProgram {
    public static void main(String[] args) throws FileNotFoundException, IOException,ClassNotFoundException {
        saveFileBin();
        readFileBin();

        Vector<Point> allPoints = new Vector<Point>();//ווקטור של נקודות (זא מערך )
        allPoints.add(new Point(1,2));
        allPoints.add(new Point(2,9));

        saveFileBinVectorPoints(allPoints);
        readFileBinVectorPoints(allPoints);

    }
    public static void saveFileBin()throws FileNotFoundException, IOException,ClassNotFoundException {
        Point p1 = new Point(3,5);
        ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("point.dat"));
        outFile.writeObject(p1);
        System.out.println(p1);
        outFile.close();
        //שמירה לקובץ bin
    }
    public static void readFileBin()throws FileNotFoundException, IOException,ClassNotFoundException{
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("point.dat"));
        Point p2 =(Point)inFile.readObject();
        System.out.println("p2" + p2);
        inFile.close();
        //קריאה מקובץ bin

    }
    public static void saveFileBinVectorPoints(Vector<Point> allPoints)throws IOException{
        ObjectOutputStream outFile = new ObjectOutputStream(new FileOutputStream("points.dat")); //פתיחת קובץ
        outFile.writeObject(allPoints);// כתיבת הווקטורים לקובץ ושמירתם
        System.out.println(allPoints);
        outFile.close();//סגירת הווקטורים

    }
    public static void readFileBinVectorPoints(Vector<Point> allPoints) throws IOException, ClassNotFoundException {
        ObjectInputStream inFile = new ObjectInputStream(new FileInputStream("points.dat"));//קריאת הקובץ הקיים
        Vector<Point> allDatesFromFiles = (Vector<Point>)inFile.readObject();//רשימת הקובץ הקיים לתוך ווקטור חדש
        System.out.println(allDatesFromFiles);
        inFile.close();
    }
}
