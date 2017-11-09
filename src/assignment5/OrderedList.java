/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author stahc1596
 */
public class OrderedList {

    private IntNode head;
    private int numItems;

    public OrderedList() {
        head = null;
        numItems = 0;
    }

    public void add(int num) {
        //Start at beginning of list
        IntNode node = head;
        //Previous keeps track of the node we used to be on
        IntNode prev = null;
        //See if you're at the start
        if (node == null) {
            IntNode temp = new IntNode(num);
            head = temp;
        } else {
            //Travel to the corresponding spot for the number
            while (node != null) {
                //If statement determines if this is the right spot to place the
                //Number
                if (num < node.getNum()) {
                    IntNode temp = new IntNode(num);
                    temp.setNext(node);
                    if (prev != null) {
                        prev.setNext(temp);
                    } else {
                        //If the right spot is the beginning of the list, then
                        //This happens
                        head = temp;
                    }
                    break;
                } else {
                    //If the number isn't in the right place, then we move over
                    //One spot to determine if that's the right spot for the number
                    prev = node;
                    node = node.getNext();
                }

            }
            //This if statement goes off if the right spot for the number is the
            //End of the list
            if (node == null) {
                IntNode temp = new IntNode(num);
                prev.setNext(temp);
            }


        }
        //Increase the amount of items in the list by one
        numItems++;
    }

    public int size() {
        //If the size of the list is asked, then the system returns the size
        return numItems;
    }

    public boolean isEmpty() {
        //If whether or not the list has any numbers in it is asked, then the
        //System returns that fact in the form of a boolean
        return numItems == 0;
    }

    public int get(int pos) {
        IntNode node = head;
        //Move the number of times
        for (int i = 0; i < pos; i++) {
            node = node.getNext();
        }
        //Returns the number the user asked for
        return node.getNum();
    }

    public void remove(int num) {
        IntNode node = head;
        IntNode prev = null;
        //Counter keeps track of the position
        int counter = 0;
        //If the number that is needed to be removed is at the beginning of
        //The list, then it removes that number
        if (num == node.getNum()) {
            head = head.getNext();
        } else {
            //Otherwise we need to determine where that number is in the list
            //Using this while loop
            while (num != node.getNum()) {
                prev = node;
                node = node.getNext();
                //Counter keeps track of where we are
                counter++;
            }
            //If the number is at the end of the list, then the number is removed
            if (counter == numItems) {
                //Sever the link
                prev.setNext(null);
            } else {
                //The node to remove
                IntNode toRemove = prev.getNext();
                //It's next node
                IntNode next = toRemove.getNext();
                prev.setNext(next);
                toRemove.setNext(null);
            }
        }
        //Decrease the number of items in the list by one
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderedList list = new OrderedList();
        //Add in all the values for the list
        list.add(3);
        list.add(8);
        list.add(5);
        list.add(1);
        //List before removing the three
        System.out.println("First List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(3);
        //List after removing the three
        System.out.println("New List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
