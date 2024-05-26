package FilesTxt.Practice;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
public class Program3 {
    public static void main(String[] args)throws IOException {
       File[] arr = new File[3];
       arr[0] = new File("D:\\קוד\\File\\check.txt");
       arr[1] = new File("D:\\קוד\\File");// התיקייה של כל הקבצים
       arr[2] = new File("D:\\קוד\\File\\checkToFile.txt");

       File[] all = arr[1].listFiles(); //  מחזירה מערך של תיקיות של כל הקבצים שבתוך התיקיה
       printAbsolutePath(all);

       System.out.println("file success? " + arr[2].createNewFile()); //מוסיפה קובץ חדש לתייקיה
        all = arr[1].listFiles();
        printAbsolutePath(all);

        System.out.println("The file is deleted? " + arr[2].delete());
        all = arr[1].listFiles();
        printAbsolutePath(all);


    }
    public static void printAbsolutePath(File[] files){
        for (int i = 0; i < files.length; i++) {
            try {
                if (files[i] != null) {
                    System.out.println(files[i].getAbsolutePath());
                }
            }catch (Exception e){
                System.out.println("The value is null.");
            }
        }
        System.out.println();
    }
    public static void methodForFile()throws IOException{
        File file = new File("D:\\קוד\\File\\numbers.txt");
        boolean newFile = file.createNewFile();
        System.out.println(file.getName() + "--->"); //numbers.txt // שם הקובץ
        System.out.println("exists? " + file.exists()); //true מסלול שהוא קיים
        System.out.println("is file? " + file.isFile()); //true // אם הוא קובץ
        System.out.println("is directory? " + file.isDirectory()); // אם הוא תיקיה
        System.out.println("can read? " + file.canRead()); //אפשר לקרוא אותו?
        System.out.println("can write? " + file.canWrite()); // ניתן לכתוב?
        System.out.println("can execute? " + file.canExecute()); //ניתן להרצה?
        System.out.println("path: " + file.getPath()); // מסלול הקובץ
        System.out.println("parent: " + file.getAbsoluteFile());
        System.out.println("length: " + file.length());
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("ido");
        fileWriter.close();
    }
}
