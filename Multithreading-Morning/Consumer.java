import java.util.Queue;


class Consumer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;
    
    public Consumer(Queue<Integer> queue, int maxSize){
        this.queue = queue;
        this.maxSize = maxSize;
    }
    
    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.isEmpty()) {
                    System.out.println("Queue is empty,"
                            + "Consumer is waiting for producer");
                    try {
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                }
                System.out.println("Consuming value and removing from queue : " + queue.poll());
                queue.notifyAll();
            }

        }
    }
}