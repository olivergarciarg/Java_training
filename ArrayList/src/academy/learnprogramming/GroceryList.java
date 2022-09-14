package academy.learnprogramming;

import java.util.ArrayList;

public class GroceryList {
    private int[] myNumbers = new int[50];
    private ArrayList<String> groceryList = new ArrayList<String>();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addGroceryItem(String item) {
        myNumbers[5] = 4;
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("you have " + groceryList.size() + " items");
        for (int i=0; i< groceryList.size(); i++) {
            System.out.println(groceryList.get(i));
        }
    }

    public void modifyGroceryItem(String oldItem, String newItem) {
        int position = findItem(newItem);
        if (position > -1) {
            modifyGroceryItem(position, newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("item modified");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position > -1) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
//        System.out.println("removing " + groceryList.get(position));
        groceryList.remove(position);
    }

    private int findItem(String searchItem) {
        // boolean exists = groceryList.contains(searchItem);
//        int position =  groceryList.indexOf(searchItem);
//        if (position > -1) {
//            return groceryList.get(position);
//        }
//        return null;
        return groceryList.indexOf(searchItem);
    }

    public boolean onFile(String searchItem) {
        return (findItem(searchItem) > -1);
    }
}
