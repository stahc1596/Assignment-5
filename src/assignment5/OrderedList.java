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
    
    public OrderedList(){
        head = null;
        numItems = 0;
    }
    
    public void add(int num){
        //Start at beginning of list
        IntNode node = head;
        //See if you're at the start
        if(node == null){
            IntNode temp = new IntNode(num);
            head = temp;
        }else{
        //Travel to the end
            while(node.getNext() != null){
                node = node.getNext();
            }
            //node is the last node in the list
            IntNode temp = new IntNode(num);
            //Insert into list
            node.setNext(temp);
        }
        numItems++;
    }
    
    public int size(){
        return numItems;
    }
    
    public boolean isEmpty(){
        return numItems == 0;
    }
    
    public int get(int pos){
        IntNode node = head;
        //Move the number of times
        for(int i = 0; i < pos; i++){
            node = node.getNext();
        }
        return node.getNum();
    }
    
    public void remove(int pos){
        //If removing from start
        if(pos == 0){
            head = head.getNext();
        }else if(pos == numItems - 1){
            //Removing from the end
            IntNode node = head;
            //Moving to the second last item
            for(int i = 0; i < numItems; i++){
                node = node.getNext();
            }
            //Sever the link
            node.setNext(null);
        }else{
            IntNode node = head;
            //Move to the spot just before
            for(int i = 0; i < pos - 1; i++){
                node = node.getNext();
            }
            //The node to remove
            IntNode toRemove = node.getNext();
            //It's next node
            IntNode next = toRemove.getNext();
            //Set all links
            node.setNext(next);
            toRemove.setNext(null);
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
        for(int i = 0; i < 4; i++){
            System.out.println(list.get(i));
        }
    }
}
