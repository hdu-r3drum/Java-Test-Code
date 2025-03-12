import com.dataStructure.Queue.LinkedListQueue;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        LinkedListQueue<String> queue = new LinkedListQueue<>();
        queue.push("hello");
        queue.push("Java");
        queue.push("world");
        queue.push("!");

        queue.printQueue();

        System.out.println(queue.isEmpty());
        System.out.println(queue.pop());

        queue.printQueue();
    }
}
