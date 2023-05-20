/*
 *  Provided by: Mustafa Daraghmeh (2020).
 */

package tut3.Queue;
import java.util.LinkedList;
import java.util.Queue;
public class DemoQueue {
    public static void main(String []er) {
        //creating instance of LinkedList to declare methods of Queue
        Queue<String> queue = new LinkedList<String>();

        //adding elements into queue

        queue.add("AI");
        queue.add("DS");
        queue.add("Java");

        //also used to add element
        queue.offer("Machine Learning");
        queue.add("App Development");

        System.out.println("Elements in Queues are:" + queue);

        //offer: It also adds the specified element to the queue. It performs the same work as the add() method.

        //remove the head element of the queue
        queue.remove();

        System.out.println("Elements in Queues are after using remove method:"+queue);

        //removing element using poll method
        queue.poll();
        //The poll() method is similar to remove () method,
        // but the only difference is poll () returns null if the queue is empty.

        System.out.println("Elements in Queues are after using poll method:" + queue);

        //using peek method
        System.out.println("The head element of queue is (using peek () method) :" + queue.peek());

        //using element() method
        System.out.println("The head element of queue is (using element() method):" + queue.element());
        //An element() method also returns the head of the queue.
        // But difference b/w element () method and peek() returns null if the queue is empty.
    }
}