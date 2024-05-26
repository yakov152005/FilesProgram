package FilesTxt.PhoneBookProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Contact {
    public enum eType { Friends, Family, Work};

    private String phoneNumber;
    private String name;
    private eType theType;


    public Contact(String phoneNumber, String name,eType theType){
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.theType = theType;
    }
    public Contact(Scanner s)throws FileNotFoundException {
            this.phoneNumber = s.next();
            this.name = s.next();
            this.theType = eType.valueOf(s.next());
    }

    public Contact(String fileName)throws FileNotFoundException{
        File file = new File(fileName);
        Scanner s = new Scanner(file);
        this.phoneNumber = s.nextLine();
        this.name = s.nextLine();
        s.close();
    }
    public void SaveForArr(PrintWriter printWriter){
        printWriter.println(this.phoneNumber);
        printWriter.println(this.name);
        printWriter.println(this.theType);
    }

    public void saveFile(String fileName)throws FileNotFoundException{
        File file = new File(fileName);
        PrintWriter printWriter = new PrintWriter(file);
            printWriter.println(this.phoneNumber);
            printWriter.println(this.name);
            printWriter.println(theType.name());
            saveOpenFile(printWriter);
            printWriter.close();
    }
    public void saveOpenFile(PrintWriter printWriter){
            printWriter.println(this.phoneNumber);
            printWriter.println(this.name);
            printWriter.println(theType.name());
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

      public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Phone: ").append(this.phoneNumber).append("\n");
        stringBuilder.append("Name: ").append(this.name).append("\n");
        stringBuilder.append("The type: ").append(theType.name()).append("\n");
        return stringBuilder.toString();
    }

}
