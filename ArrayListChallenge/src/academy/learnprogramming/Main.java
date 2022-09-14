package academy.learnprogramming;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static  MobilePhone mobilePhone = new MobilePhone("0039 330 4404");
    public static void main(String[] args) {
        boolean quit = false;
        startPhone();
        printActions();
        int choice;
        while (!quit) {
            System.out.println("enter choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    quit = true;
                    System.out.println("shutting down");
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
            }
        }
    }

    private static void addContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        System.out.println("enter number: ");
        String number = scanner.nextLine();
        Contact newContact = Contact.createContact(name, number);
        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("new contact added " + name + " " + number);
            return;
        }
        System.out.println("contact already exists");
    }

    private static void updateContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println("enter new name: ");
        String newName = scanner.nextLine();
        System.out.println("enter new number: ");
        String newNumber = scanner.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobilePhone.updateContact(contact, newContact)) {
            System.out.println("contact updated");
        } else {
            System.out.println("error updating");
        }
    }

    private static void removeContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println("contact not found");
            return;
        }
        if (mobilePhone.removeContact(contact)) {
            System.out.println("contact removed");
        } else {
            System.out.println("error removing contact");
        }
    }

    private static void queryContact() {
        System.out.println("enter name: ");
        String name = scanner.nextLine();
        Contact contact = mobilePhone.queryContact(name);
        if (contact == null) {
            System.out.println("contact not found");
            return;
        }
        System.out.println(contact.getName() + " number is " + contact.getPhoneNumber());
    }

    private static void startPhone() {
        System.out.println("starting phone...");
    }

    private static void printActions() {
        System.out.println(
                "\nPress\n" +
                "0 - To turn off.\n" +
                "1 - To print contact.\n" +
                "2 - To add new contact.\n" +
                "3 - To update a contact.\n" +
                "4 - To remove a contact.\n" +
                "5 - Query contact.\n" +
                "6 - print actions.\n" +
                "Choose action:\n"
        );
    }
}
