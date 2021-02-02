package producer_consumer;

public class Producer_Consumer_Problem
{
	static Object key = new Object();
    private static boolean[] buffer;
    private static int currentSize;

    public static void main(String[] args) throws InterruptedException {
        buffer = new boolean[10];
        currentSize = 0;

        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        Runnable prodRunn = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    producer.produce();
                }
                System.out.println("Produced...");
            }
        };

        Runnable consRunn = new Runnable() {
            @Override
            public void run() {
                for (int x = 0; x < 100; x++) {
                    consumer.consume();
                }
                System.out.println("Consumer...");
            }
        };

        Thread prodThread = new Thread(prodRunn);
        Thread consThread = new Thread(consRunn);

        prodThread.start();
        consThread.start();

        prodThread.join();
        consThread.join();

        System.out.println("Buffer size : " + currentSize);
    }

    static class Producer {
        void produce() {
            synchronized (key) {
                if (currentSize == buffer.length) {
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[currentSize++] = true;
                key.notifyAll();
            }
        }
    }

    static class Consumer {
        void consume() {
            synchronized (key) {
                if (currentSize == 0) {
                    try {
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                buffer[--currentSize] = false;
                key.notifyAll();
            }
        }
    }
}
