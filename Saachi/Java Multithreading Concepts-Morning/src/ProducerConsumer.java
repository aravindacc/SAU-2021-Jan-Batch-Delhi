public class ProducerConsumer {
    static final Object key = new Object();
    private static boolean[] buffer;
    private static int currentSize;

    public static void main(String[] args) throws InterruptedException {
        buffer = new boolean[10];
        currentSize = 0;

        final Producer producer = new Producer();
        final Consumer consumer = new Consumer();

        Runnable producerRunning = () -> {
            for (int x = 0; x < 200; x++) {
                producer.produce(x);
            }
        };

        Runnable consumerRunning = () -> {
            for (int x = 0; x < 100; x++) {
                consumer.consume(x);
            }
        };

        Thread prodThread = new Thread(producerRunning);
        Thread consThread = new Thread(consumerRunning);

        prodThread.start();
        consThread.start();

        prodThread.join();
        consThread.join();

        System.out.println("Buffer size : " + currentSize);
    }

    static class Producer {
        void produce(int i) {
            synchronized (key) {
                if (currentSize == buffer.length) {
                    try {
                        System.out .println("Buffer is full, Producer thread waiting for consumer to take something from Buffer.");
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Producing value :" + i);
                buffer[currentSize++] = true;
                key.notifyAll();
            }
        }
    }

    static class Consumer {
        void consume(int i) {
            synchronized (key) {
                if (currentSize == 0) {
                    try {
                        System.out.println("Buffer is empty, Consumer thread is waiting for producer thread to put something in Buffer.");
                        key.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("Consuming value :" + i);
                buffer[--currentSize] = false;
                key.notifyAll();
            }
        }
    }
}
