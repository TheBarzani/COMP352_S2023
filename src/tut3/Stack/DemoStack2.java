/*
 *  Provided by: Mustafa Daraghmeh (2020).
 */

 package tut3.Stack;
//importing stack class
import java.util.Stack;
public class DemoStack2 {
    public static void main(String[] er)
    {
        //creating instance of stack class
        Stack <Integer> st=new Stack<Integer>();

        //inserting elements into the stack
        //Push: It is used to insert a specific element into the stack and returns the inserted element.
        st.push(10);
        st.push(20);
        st.push(30);
        st.push(40);
        st.push(50);
        st.push(60);

        //dispalying elements in the stack
        System.out.println("Elements in the stack are:" + st);

        //popping top element from the stack
        //pop: It is used to remove the top element from the stack and returns the removed element.
        st.pop();
        System.out.println("Elements in the stack after performing 1st pop() operation:" + st);
        st.pop();
        System.out.println("Elements in the stack after performing 2nd pop() operation:" + st);

        //The peek() method is used to return the first element of the stack, but it does not remove from the top.
        //The boolean empty() method is used to test if the stack is empty or not. If the stack is empty, it returns true else false.


    }
}