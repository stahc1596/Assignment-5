/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author stahc1596
 */
public class IntNode {
    
    private int item;
    private IntNode next;
    
    public IntNode(int num){
        item = num;
        next = null;
    }
    
    /**
     * Returns the number
     * @return 
     */
    public int getNum(){
        return item;
    }
    /**
     * Returns the node that comes after
     * @return 
     */
    public IntNode getNext(){
        return next;
    }
    /**
     * Sets the node that comes after
     * @param node 
     */
    public void setNext(IntNode node){
        next = node;
    }
}

