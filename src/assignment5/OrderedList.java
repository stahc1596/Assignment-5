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
                //------------------------------------------
                if (num < node.getNum()) {

                    IntNode temp = new IntNode(num);
                    temp.setNext(node);
                    if (prev != null) {
                        prev.setNext(temp);
                    }else{
                        head = temp;
                    }
                    break;
                } else {
                    prev = node;
                    node = node.getNext();
                }
                
            }
            if(node == null){
                IntNode temp = new IntNode(num);
                prev.setNext(temp);
            }
            
            
        }
        numItems++;
    }

    public int size() {
        return numItems;
    }

    public boolean isEmpty() {
        return numItems == 0;
    }

    public int get(int pos) {
        IntNode node = head;
        //Move the number of times
        for (int i = 0; i < pos; i++) {
            node = node.getNext();
        }
        return node.getNum();
    }

    public void remove(int num) {
        IntNode node = head;
        IntNode prev = null;
        int counter = 0;
        if(num == node.getNum()){
            head = head.getNext();
        }else{
            while(num != node.getNum()){
                prev = node;
                node = node.getNext();
                counter++;
            }
            if(counter == numItems){
                //Sever the link
                prev.setNext(null);
            }else{
                //The node to remove
                IntNode toRemove = prev.getNext();
                //It's next node
                IntNode next = toRemove.getNext();
                //Set all links
                prev.setNext(next);
                toRemove.setNext(null);
            }
        }
        numItems--;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        OrderedList list = new OrderedList();
        list.add(3);
        list.add(8);
        list.add(5);
        list.add(1);
        System.out.println("First List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
        list.remove(3);
        System.out.println("New List:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
