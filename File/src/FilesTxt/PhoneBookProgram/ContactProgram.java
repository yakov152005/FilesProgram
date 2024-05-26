package FilesTxt.PhoneBookProgram;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ContactProgram {
    public static void main(String[] args) throws FileNotFoundException {

        Contact[] contacts = readFromFile();//read contacts number

        PhoneBook myPhoneBook = new PhoneBook("YakovPhoneBook",10);
        myPhoneBook.addContact(contacts[0]);
        myPhoneBook.addContact(contacts[1]);
        myPhoneBook.addContact(contacts[2]);
        System.out.println(myPhoneBook);
        myPhoneBook.savePhoneBook("MyPhoneBook.txt");//save phone book

        PhoneBook newPhoneBook = new PhoneBook("MyPhoneBook.txt");//read phone book ^
        System.out.println(newPhoneBook);
        newPhoneBook.addContact(contacts[3]);
        System.out.println(newPhoneBook);
        newPhoneBook.savePhoneBook("MyPhoneBook.txt");//save phone book again in the new phone book







    }
    public static void saveFilesInArr()throws FileNotFoundException{
        int size = 0;
        String nameForTxt = null;
        PrintWriter printWriter = null;
        boolean isValid = false;

        while (!isValid) {
            try {
                System.out.println("How many contact do u want to input? ");
                size = s.nextInt();
                isValid = true;
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("You need to input integer for size.");

            }
        }
        try {
            System.out.println("Enter Name for txt: ");
            nameForTxt = s.next();
            printWriter = new PrintWriter(new File(nameForTxt));
        }catch (InputMismatchException e){
            s.nextLine();
            System.out.println("The name most to be (.txt) in the end.");
        }

        Contact[] allContacts = new Contact[size];
        if (printWriter != null) {
            printWriter.println(allContacts.length);
        }
        for (int i = 0; i < allContacts.length; i++) {
            s.nextLine();
            System.out.println("Enter FilesTxt.PhoneBookProgram.Contact name -->");
            String name = s.nextLine();


            System.out.println("Enter phone number -->");
            String phoneNumber =s.next();

            System.out.println("Enter type of the following : ");
            Contact.eType[] contactTypes = Contact.eType.values();
            Contact.eType contactTypeChoose = type(contactTypes);

            allContacts[i] = new Contact(phoneNumber,name, contactTypeChoose);
            assert printWriter != null;
            allContacts[i].saveOpenFile(printWriter);
        }
        assert printWriter != null;
        printWriter.close();
        System.out.println("The file saved is success.");
    }
    public static Contact[] readFromFile() throws FileNotFoundException {
        File file = new File("names.txt");
        Scanner scanner = new Scanner(file);
        int numOfContact = scanner.nextInt();
        Contact[] allContacts = new Contact[numOfContact];
        for (int i = 0; i < allContacts.length; i++) {
            allContacts[i] = new Contact(scanner);
        }
        s.close();
        System.out.println("The details of contacts is --->");
        for (int i = 0; i < allContacts.length; i++) {
            try {
                System.out.println(allContacts[i].toString());
            }catch (NullPointerException e){
                System.out.println(e.getMessage());
            }
        }
        return allContacts;
    }
    public static Contact.eType type(Contact.eType[] contactTypes){
        Contact.eType contact = null;
        for (int i = 0; i < contactTypes.length; i++) {
            System.out.println((i+1) + "--> " + contactTypes[i].name());
        }
        boolean isValidChoose = false;
        while (!isValidChoose) {
            try {
                System.out.println("Enter your choose --->");
                int choose = s.nextInt();
                contact = switch (choose) {
                    case 1 -> Contact.eType.Friends;
                    case 2 -> Contact.eType.Family;
                    case 3 -> Contact.eType.Work;
                    default -> {
                        System.out.println("invalid choose, this is a Friends type.");
                        yield Contact.eType.Friends;
                    }
                };
                isValidChoose  = true;
            } catch (InputMismatchException e) {
                s.nextLine();
                System.out.println("Please Input you choose in Integer, not String.");
            }
        }
        return contact;
    }
    public static Scanner s = new Scanner(System.in);

    public static void checkProgram(){
       /*/ FilesTxt.PhoneBookProgram.Contact contact = new FilesTxt.PhoneBookProgram.Contact("052-6650754","Yakov");
        contact.saveFile("PhoneNumber.txt");
        System.out.println("FilesTxt.PhoneBookProgram.Contact  -->" + contact);

        FilesTxt.PhoneBookProgram.Contact contact1 = new FilesTxt.PhoneBookProgram.Contact("0529540576","Ido");
        File file = new File("PhoneNumber1.txt");
        contact1.saveOpenFile(file);
        System.out.println("FilesTxt.PhoneBookProgram.Contact 1 -->" + contact1);

        FilesTxt.PhoneBookProgram.Contact contact2 = new FilesTxt.PhoneBookProgram.Contact("PhoneNumber.txt");
        System.out.println("FilesTxt.PhoneBookProgram.Contact 2 -->" + contact2);

        FilesTxt.PhoneBookProgram.Contact contact3 = new FilesTxt.PhoneBookProgram.Contact(file);
        System.out.println("FilesTxt.PhoneBookProgram.Contact 3 -->" + contact3);

        */
    }
}
