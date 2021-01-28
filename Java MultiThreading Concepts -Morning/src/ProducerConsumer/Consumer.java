package ProducerConsumer;

import java.util.List;

class Consumer implements Runnable {
    private List<Integer> list1;
    public Consumer(List<Integer> list1) {
        this.list1 = list1;
    }
   
    @Override
    public void run() {
        while (true) {
         try {
             consume();
             Thread.sleep(100);
         } 
         catch (InterruptedException e)
         {  
        	 System.out.println(e.getMessage());
         }
        }
    }
 
    private void consume() throws InterruptedException {
      
       synchronized (list1) {
         
           while (list1.size() == 0) {
                  System.out.println("queue is empty, consumerThread is waiting");
             list1.wait();
         }
       }
       
        synchronized (list1) {
           Thread.sleep(500);
         System.out.println("Consumed : "+ list1.remove(0));
         list1.notify();
        }
    }
   
}
