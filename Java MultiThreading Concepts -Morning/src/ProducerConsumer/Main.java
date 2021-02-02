package ProducerConsumer;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        List<Integer> li1 = new ArrayList<Integer>(); 
       
        Producer producer=new Producer(li1);
        Consumer consumer=new Consumer(li1);
       
         Thread producerThread = new Thread(producer, "ProducerThread");
         Thread consumerThread = new Thread(consumer, "ConsumerThread");
         producerThread.start();
         consumerThread.start();
     }
}
