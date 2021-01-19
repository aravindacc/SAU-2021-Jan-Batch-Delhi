import java.util.Deque;
import java.util.Random;

class Producer implements Runnable {

    Deque<Integer> queue;
    Random random = new Random();
    long produceInterval = 500;

    public Producer(Deque<Integer> queue) {
        this.queue = queue;
    }

    public void produce() throws InterruptedException {

        // produce infinitly
        while (true) {
            Integer val = random.nextInt(100);
            // get queue lock and add data in it
            synchronized (queue) {
                queue.add(val);
                System.out.println("Produced : "+ val);
                queue.notify();
            }
            Thread.sleep(produceInterval);
        }
    }

    @Override
    public void run() {
        try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}