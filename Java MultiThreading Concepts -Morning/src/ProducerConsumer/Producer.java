package ProducerConsumer;

import java.util.List;

class Producer implements Runnable {
	 
    private List<Integer> list1;
    private int total_size=5;
 
    public Producer(List<Integer> list1) {
        this.list1 = list1;
    }
 
    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {  
         try {
             produce(i);
         } 
         catch (InterruptedException e) {  
        	 System.out.println(e.getMessage());
        	 }
        }
}
 
    private void produce(int i) throws InterruptedException {
       synchronized (list1) {
           while (list1.size() == total_size) {
             System.out.println("queue full, producerThread is waiting ");
             list1.wait();
         }
        }
        synchronized (list1) {  
           System.out.println("Produced : " + i);
           list1.add(i);
         Thread.sleep(500);
         list1.notify();
        }
    }
}
