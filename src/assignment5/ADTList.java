/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment5;

/**
 *
 * @author stahc1596
 */
public class ADTList {

    private int numItems;
    private int[] spot;

    public ADTList() {
        //Constructor creates an array of ten spots
        numItems = 0;
        spot = new int[10];
    }

    public void add(int index, int num) {
        if (index < spot.length) {
            //If the position the number needs to be place in the array is a
            //Real position in the array, then the number is inserted into the
            //Array at that position
            spot[index] = num;
            numItems++;
        } else {
            //Otherwise, the array doubles in size to create a spot where the
            //Number can fit in the new array
            int[] temp = new int[spot.length * 2];
            for (int i = 0; i < spot.length; i++) {
                temp[i] = spot[i];
            }
            //The number is then added to the array
            spot = temp;
            spot[index] = num;
            numItems++;
        }
    }

    public void remove(int index) {
        //To remove a number is to replace it with a zero
        spot[index] = 0;
        numItems--;
    }

    public int size() {
        //Return how many numbers are in the array
        return numItems;
    }

    public boolean isEmpty() {
        //For loop runs through the entire array to determine if the array is
        //Full of zeros or not
        for (int i = 0; i < spot.length; i++) {
            if (spot[i] != 0) {
                return false;
            }
        }
        //If the array is full of zeros, then the array is empty
        return true;
    }

    public int get(int index) {
        //Return the number stored in the position in the array that is specified
        return spot[index];
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ADTList list = new ADTList();
        System.out.println("Is Empty: " + list.isEmpty());
        list.add(0, 3);
        list.add(3, 9);
        list.add(8, 2);
        list.add(10, 5);
        System.out.println("Size: " + list.size());
        //For loop goes through entire array and outputs all values inserted
        for (int i = 0; i < list.spot.length; i++) {
            //Zeros are considered to not be numbers, therefore all spots with
            //A zero is considered empty and the system doesn't ouput zeros
            if (list.get(i) != 0) {
                System.out.println(list.get(i));
            }
        }
        list.remove(3);
        System.out.println(list.get(3));
        System.out.println("Is Empty: " + list.isEmpty());
    }
}
