
import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerDriver {

    public static void main(String args[]) {
        
        Queue<Integer> buffer = new LinkedList<>();
        int maxSize = 10;
        Thread producer = new Producer(buffer, maxSize);
        Thread consumer = new Consumer(buffer, maxSize);
        
        //starting both threads
        producer.start();
        consumer.start();
        

    }

}