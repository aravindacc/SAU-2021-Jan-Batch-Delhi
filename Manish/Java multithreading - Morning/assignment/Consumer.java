import java.util.Deque;

class Consumer implements Runnable{

    Deque<Integer> queue;
    long consumeInterval = 500;

    public Consumer(Deque<Integer> queue) {
        this.queue = queue;
    }

    public int consume() throws InterruptedException {

        // wait till queue is empty
        while (queue.isEmpty()) {
            synchronized (queue) {
                queue.wait();
            }
        }

        Integer val;
        // if queue is not empty and when queue lock can be acquired
        synchronized (queue) {
            val = queue.removeFirst();
            queue.notify();
        }

        return val;
    }

    @Override
    public void run() {
        try {

            // consume infinitly
            while (true) {
                System.out.println("Consumed : " + consume());
                Thread.sleep(consumeInterval);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}