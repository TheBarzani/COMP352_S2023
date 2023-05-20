/*
 *  Provided by: Mustafa Daraghmeh (2020).
 */

package tut3.Stack;
import java.util.Stack;

public class DemoStack3 {
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        System.out.println("Empty stack : "  + stack);
        System.out.println("Empty stack : "  + stack.isEmpty());

        stack.push(100);
        stack.push(102);
        stack.push(103);
        stack.push(104);
        stack.add(0,888);
        stack.add(stack.size(),999);

        System.out.println("Stack elements are : "  + stack);
        System.out.println("Stack: Pop Operation : "  + stack.pop());
        System.out.println("Stack: After Pop Operation : "  + stack);
        System.out.println("Stack : search() Operation : "  + stack.search(1002));
        System.out.println("If Stack is empty : "  + stack.isEmpty());

        Stack<Integer> s2 = new Stack<>();
        while(!stack.isEmpty()){
            s2.push(stack.pop());
        }
        System.out.println("Stack s2 elements are : "  + s2);

        stack.push(667667);

        while(!s2.isEmpty()){
            stack.push(s2.pop());
        }
        System.out.println("Stack elements are : "  + stack);

        Stack<Integer> s3 = new Stack<>();
        while(!stack.isEmpty()){
            s3.push(stack.pop());
        }
        System.out.println("Stack s3 elements are : "  + s3);
        System.out.println("PoP s3 element : "  + s3.pop());
        while (!s3.isEmpty()){
            stack.push(s3.pop());
        }
        System.out.println("Stack elements are : "  + stack);

        while(!stack.isEmpty()){
            s3.push(stack.pop());
        }
        System.out.println("Stack s3 elements are : "  + s3);
        System.out.println("PoP s3 element : "  + s3.pop());
        while (!s3.isEmpty()){
            stack.push(s3.pop());
        }
        System.out.println("Stack elements are : "  + stack);

    }
}
