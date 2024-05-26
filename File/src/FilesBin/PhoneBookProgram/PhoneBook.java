package FilesBin.PhoneBookProgram;

import java.io.*;

public class PhoneBook implements Serializable {
        private String nameOfPhoneBook;
        private Contact[] allContacts;
        private int contactNumberInThePhoneBook;

        public PhoneBook(String nameOfPhoneBook, int maxContactNumber){
            this.nameOfPhoneBook = nameOfPhoneBook;
            this.contactNumberInThePhoneBook =  0;
            allContacts = new Contact[maxContactNumber];
        }

        public PhoneBook(){

        }
        public void saveFiles(String filename,PhoneBook phoneBook)throws Exception{
            ObjectOutputStream saveFiles = new ObjectOutputStream(new FileOutputStream(filename));
            saveFiles.writeObject(phoneBook);
            saveFiles.close();
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
