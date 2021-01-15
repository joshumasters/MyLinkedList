
import java.util.Scanner;

public class MyLinkedList {

    Node current;

    Node head;

    Scanner scan = new Scanner(System.in);

    public MyLinkedList() {

    }

    class Node {
        int value;

        Node next;

        public Node(int value) {
            this.value = value;

        }
    }

    // Adds to end of list
    public void add(int value) {
        Node node = new Node(value);

        if (head == null) {
            head = node;
            current = head;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = node;
        }
        current = head;
    }

    public void printListWithLength() {
        if (head == null) {
            System.out.println("There is nothing in this list");
        } else {
            System.out.println("Would you like to print from beginning or current list position? B = Beginning, C = Current");
            String input = scan.nextLine();
            if (input.equalsIgnoreCase("B")) {
                current = head;
            }

            while (current.next != null) {
                System.out.println("Value of Node is " + current.value);
                current = current.next;
            }
            System.out.println("Value of Node is " + current.value);
        }

    }

    public int advanceInList(int numOfMoves) {
        while (numOfMoves > 1) {
            System.out.println("Current Node has a value of " + current.value);
            current = current.next;
            numOfMoves--;
        }
        int valueToReturn = current.value;
        System.out.println("Arrived at Node of value " + valueToReturn);
        return valueToReturn;
    }

    public void returnToHead() {
        current = head;
        System.out.println("Returned to Head of List");
    }

    public void removeAtLocation() {
        System.out.println("Would you like to delete value at current location? Current Value = " + current.value + " Y/N?");
        String input = scan.nextLine();
        int valueToRemove = 0;
        if (input.equalsIgnoreCase("Y")) {
            if (current == head) {
                valueToRemove = current.value;
                head = current.next;
            } else {
                Node n = head;
                while (n.next != current) {
                    n = n.next;
                }
                valueToRemove = current.value;
                n.next = current.next;
            }
            System.out.println(valueToRemove + " has been removed from the list");
        } else {
            System.out.println("Try using advanceInList and returnToHead to navigate to desired node");
        }
    }

    public int getHeadValue() {
        System.out.println("Head value is " + head.value);
        return head.value;
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add(2);
        list.add(5);
        list.add(36);
        list.add(15);
        list.removeAtLocation();
        list.returnToHead();
        list.printListWithLength();
        list.add(27);
        list.add(63);
        list.advanceInList(3);
        list.removeAtLocation();
        list.printListWithLength();
    }

}
