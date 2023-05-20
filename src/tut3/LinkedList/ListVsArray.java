package tut3.LinkedList;

public class ListVsArray {
    public static void main(String[] args) {

        SingleLL<Integer> myList = new SingleLL<>();
        myList.insert(10);
        myList.insert(2);
        myList.insert(1);
        myList.insert(9);
        myList.insert(3);
        //TODO:toString() method to be defined!
        System.out.println(myList.toString());

    }
}
