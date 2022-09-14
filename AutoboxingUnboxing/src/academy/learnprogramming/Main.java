package academy.learnprogramming;

import java.util.ArrayList;
class IntClass {
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
        ArrayList<String> strArrayList = new ArrayList<String>();
//        ArrayList<int> intArrayList = new ArrayList<int>();
        ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
        intClassArrayList.add(new IntClass(54));
        Integer integer = new Integer(54);
        ArrayList<Integer> integerArrayList = new ArrayList<Integer>();
        for (int i=0; i<11;i++) {
            integerArrayList.add(Integer.valueOf(i)); // Autoboxing
        }
        for (int i=0; i<11;i++) {
            System.out.println(integerArrayList.get(i).intValue()); // unboxing
        }

        Integer myIntValue = 56;
        int myInt = myIntValue;

    }
}
