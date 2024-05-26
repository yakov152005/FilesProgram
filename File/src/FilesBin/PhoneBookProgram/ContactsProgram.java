package FilesBin.PhoneBookProgram;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class ContactsProgram implements Serializable {
    public static void main(String[] args)throws Exception {
        Contact[] allContacts = {
                new Contact("052-6650754","Yakov", FilesTxt.PhoneBookProgram.Contact.eType.Friends),
                new Contact("055-5555555","Daniel", FilesTxt.PhoneBookProgram.Contact.eType.Family),
                new Contact("057-7777777","Ido", FilesTxt.PhoneBookProgram.Contact.eType.Work)
        };
        PhoneBook phoneBook = new PhoneBook("YakovPhone",10);
        phoneBook.addContact(allContacts[0]);
        phoneBook.addContact(allContacts[1]);
        phoneBook.addContact(allContacts[2]);
        phoneBook.saveFiles("ProPhoneBook.dat",phoneBook);
        System.out.println(phoneBook);

        PhoneBook newPhoneBook = new PhoneBook();
        ObjectInputStream readFiles = new ObjectInputStream(new FileInputStream("ProPhoneBook.dat"));
        newPhoneBook = (PhoneBook) readFiles.readObject();
        readFiles.close();
        System.out.println(newPhoneBook);


    }
}
