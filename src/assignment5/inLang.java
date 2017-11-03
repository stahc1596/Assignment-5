/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author stahc1596
 */
public class inLang {

    private int numItems;
    private char[] stack;
    
    public inLang(){
        stack = new char[10];
        numItems = 0;
    }
    
    public void push(char item){
        if(numItems < stack.length){
            //Put the item on the stack
            stack[numItems] = item;
            numItems++;
        }else{
            //Make more room
            char[] temp = new char[stack.length*2];
            //Copy items over
            for(int i = 0; i < stack.length; i++){
                temp[i] = stack[i];
            }
            //Stack equals new array
            stack = temp;
            //Add in new item
            stack[numItems] = item;
            numItems++;
        }
    }
    
    public boolean inLang(){
        //Variables keep track of positions
        //Counter keeps track of what letters we're comparing
        int counter = 0;
        //Length determines the length of the String(Not the length of the Array)
        int length = 0;
        //While loop determines how many words are before the $
        while(stack[length] != '$'){
            length++;
        }
        //Algorithm to determine the real length
        length = length + length + 1;
        //While loop to check if the letters mirrored by both sides are equal
        while(stack[counter] == stack[length - counter - 1] && stack[counter] != '$'){
            counter++;
        }
        //Return statement determines if all letters were equal or not and returns
        //answer to user
        return counter == length - counter - 1;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        inLang stack = new inLang();
        //The string that we're using
        String lang = "cat$tac";
        //For loop adds each character in the string to the stack
        for(int i = 0; i < lang.length(); i++){
            stack.push(lang.charAt(i));
        }
        //Check to see if the string was mirrored or not
        boolean mirror = stack.inLang();
        //Tell user if the string was mirrored
        System.out.println(mirror);
    }
}
