//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        MobilePhone mobile = new MobilePhone("12345678");
        Contact contact1 = Contact.createContact("Amit","76206534");
        Contact contact2 = Contact.createContact("Raj","2345678");

        mobile.addNewContact(contact1);
        mobile.addNewContact(contact2);
        mobile.printContacts();

        Contact updatedContact = Contact.createContact("Laxmi", "123789");

        mobile.updateContact(contact1, updatedContact);
        mobile.printContacts();

        Contact queriedContact = Contact.createContact("Laxmi","123789");
        mobile.queryContact("Mohan");


    }
}