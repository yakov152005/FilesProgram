package FilesBin.PhoneBookProgram;

import java.io.Serializable;

public class Contact implements Serializable {
        public enum eType { Friends, Family, Work};

        private String phoneNumber;
        private String name;
        private FilesTxt.PhoneBookProgram.Contact.eType theType;

        public Contact(String phoneNumber, String name, FilesTxt.PhoneBookProgram.Contact.eType theType){
            this.phoneNumber = phoneNumber;
            this.name = name;
            this.theType = theType;
        }

        public String toString(){
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Phone: ").append(this.phoneNumber).append("\n");
            stringBuilder.append("Name: ").append(this.name).append("\n");
            stringBuilder.append("The type: ").append(theType.name()).append("\n");
            return stringBuilder.toString();
        }

}

