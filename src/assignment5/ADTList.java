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
    
    public ADTList(){
        numItems = 0;
        spot = new int[10];
    }
    public void add(int index, int num){
        if(index < spot.length){
            spot[index] = num;
            numItems++;
        }else{
            int[] temp = new int[spot.length*2];
            for(int i = 0; i < spot.length; i++){
                temp[i] = spot[i];
            }
            spot = temp;
            spot[index] = num;
            numItems++;
        }
    }
    public void remove(int index){
        spot[index] = 0;
        numItems--;
    }
    public int size(){
        return numItems;
    }
    public boolean isEmpty(){
        for(int i = 0; i < spot.length; i++){
            if(spot[i] != 0){
                return false;
            }
        }
        return true;
    }
    public int get(int index){
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
        list.add(7, 5);
        System.out.println("Size: " + list.size());
        for(int i = 0; i < list.spot.length; i++){
            System.out.println(list.get(i));
        }
        list.remove(3);
        System.out.println(list.get(3));
        System.out.println("Is Empty: " + list.isEmpty());
    }
}
