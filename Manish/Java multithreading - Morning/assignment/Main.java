import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        Deque<Integer> queue = new LinkedList<>();
        Thread cT = new Thread(new Consumer(queue));  // consumer thread
        Thread pT = new Thread(new Producer(queue));  // producer thread
        cT.start();
        pT.start();
    }
}
