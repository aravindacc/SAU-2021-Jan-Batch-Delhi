
import java.util.Queue;
import java.util.Random;

class Producer extends Thread {
    private Queue<Integer> queue;
    private int maxSize;

    //constructor
    public Producer(Queue<Integer> queue, int maxSize) {
        this.queue = queue;
        this.maxSize = maxSize;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (queue) {
                while (queue.size() == maxSize) {
                    try {
                        System.out.println("Queue is full, " + "Producer waiting for consumer ");
                        queue.wait();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }

                Random random = new Random();
                int i = random.nextInt(10);
                System.out.println("Producing value and adding in queue : " + i);
                queue.offer(i);
                queue.notifyAll();
            }

        }
    }
}