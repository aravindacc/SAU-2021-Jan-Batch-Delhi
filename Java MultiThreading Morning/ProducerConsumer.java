import java.util.ArrayList;
import java.util.List;

public class ProducerConsumer {

    static List<Integer> list = new ArrayList<Integer>();
     
    //ProducerClass
    static class Producer implements Runnable {

        List<Integer> list;

        public Producer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {
            synchronized (list) {
                for (int i = 0; i < 10; i++) {
                    if (list.size() >= 1) {
                        try {
                            System.out.println("Hello! Producer is waiting ");
                            list.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        }
                    }

                    System.out.println("Produced=" + i);
                    list.add(i);
                    list.notifyAll();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                }

            }
        }

    }
    //ConsumerClass
    static class Consumer implements Runnable {

        List<Integer> list;

        public Consumer(List<Integer> list) {
            this.list = list;
        }

        @Override
        public void run() {

            synchronized (list) {
                for (int i = 0; i < 10; i++) {

                    while (list.isEmpty()) {
                        System.out.println("Hello! Consumer is waiting");
                        try {
                            list.wait();
                        } catch (InterruptedException ex) {
                            ex.printStackTrace();;
                        }

                    }

                    int k = list.remove(0);
                    System.out.println("Consumed=" + k);
                    list.notifyAll();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }

                }

            }
        }

    }

    public static void main(String[] args) {
        Thread producer = new Thread(new Producer(list));
        Thread consumer = new Thread(new Consumer(list));
        producer.start();
        consumer.start();

    }
}