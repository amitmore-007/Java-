import java.util.ArrayList;

public class MobilePhone {

    private String myNumber;
    private ArrayList<Contact> myContacts;

    public MobilePhone(String myNumber) {
        this.myNumber = myNumber;
        this.myContacts = new ArrayList<Contact>();
    }

    public boolean addNewContact(Contact contact){
        if(findContact(contact.getName()) >= 0){
            System.out.println("Contact is already on file");
            return false;
        }else{
            myContacts.add(contact);
            return true;
        }

    }


    public boolean updateContact(Contact oldcontact, Contact newContact){
        int foundPosition = findContact(oldcontact);
        if(foundPosition < 0){
            System.out.println(oldcontact.getName() + " was not found. ");
            return false;
        }
        else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact with name " + newContact.getName() +
                    " already exists.  Update was not successful.");
            return false;
        }

        this.myContacts.set(foundPosition, newContact);
        System.out.println(oldcontact.getName() + ", was replaced with " + newContact.getName());
        return true;


    }

    public boolean removeContact(Contact contact){
        int foundPosition = findContact(contact);

        if(foundPosition < 0){
            System.out.println(contact.getName() + " doesn't exist on file .");
            return false;
        }
        this.myContacts.remove(foundPosition);
        System.out.println(contact.getName() + " was successfully deleted .");
        return true;

    }

    private int findContact(Contact contact){
        return myContacts.indexOf(contact);

    }
    public int findContact(String contactName){

        for(int i = 0; i < myContacts.size(); i++){
            Contact contact = myContacts.get(i);
            if(contact.getName().equals(contactName)){
                return i;
            }

        }
        return -1;

    }

    public Contact queryContact(String name){
        int foundPosition = findContact(name);

        if(foundPosition < 0){
            System.out.println(name + " was not found on file");
            return null;
        }
        System.out.println(name + " was found on file");
        return  this.myContacts.get(foundPosition);


    }

    public void printContacts(){

        System.out.println("Contact List:");
        for (int i = 0; i < myContacts.size(); i++){
           System.out.println( (i + 1) + ". " + this.myContacts.get(i).getName() + " -> " + this.myContacts.get(i).getPhoneNumber());

        }






    }

}