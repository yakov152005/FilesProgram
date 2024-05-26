package FilesTxt.PhoneBookProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class PhoneBook {
    private String nameOfPhoneBook;
    private Contact[] allContacts;
    private int contactNumberInThePhoneBook;

    public PhoneBook(String nameOfPhoneBook, int maxContactNumber){
        this.nameOfPhoneBook = nameOfPhoneBook;
        this.contactNumberInThePhoneBook =  0;
        allContacts = new Contact[maxContactNumber];
    }

    public PhoneBook(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        Scanner scanner = new Scanner(file);

        this.nameOfPhoneBook = scanner.nextLine();
        int maxContact = scanner.nextInt();
        this.contactNumberInThePhoneBook =  scanner.nextInt();
        scanner.nextLine();

        this.allContacts = new Contact[maxContact];
        for (int i = 0; i < contactNumberInThePhoneBook; i++) {
                this.allContacts[i] = new Contact(scanner);
        }
        scanner.close();
    }
    public boolean addContact(Contact newContact){
        if (this.contactNumberInThePhoneBook == allContacts.length){
            System.out.println("The added contact i'snt success.");
            System.out.println("The phone book is full.");
            return false;
        }else {
            allContacts[contactNumberInThePhoneBook++] = newContact;
            System.out.println("added contact success.");
        }

        return true;
    }
    public void savePhoneBook(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        theFinalSave(file);
        System.out.println("The File is saved.");
    }
    public void theFinalSave(File file) throws FileNotFoundException {
        PrintWriter printWriter = new PrintWriter(file);
        printWriter.println(this.nameOfPhoneBook);
        printWriter.println(this.allContacts.length);
        printWriter.println(this.contactNumberInThePhoneBook);

        for (int i = 0; i < contactNumberInThePhoneBook; i++) {
            allContacts[i].SaveForArr(printWriter);
        }
        printWriter.close();
    }
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Phone book name --> ").append(this.nameOfPhoneBook).append("\n");
        stringBuilder.append("All contact--> ").append("\n");
        int i = 1;
        for (int j = 0; j < contactNumberInThePhoneBook; j++) {
            stringBuilder.append((i++)).append(": ").append(this.allContacts[j]).append("\n");
        }
        return stringBuilder.toString();
    }

}
