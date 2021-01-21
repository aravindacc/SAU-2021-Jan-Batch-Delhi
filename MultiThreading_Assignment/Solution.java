import java.util.*;
public class Solution
{
   public static void main(String[] args)
   {
      List<Integer> taskQueue = new ArrayList<Integer>();
      int MAX_CAPACITY = 5;
      Thread tProducer = new Thread(new Producer1(taskQueue, MAX_CAPACITY), "Producer");
      Thread tConsumer = new Thread(new Consumer1(taskQueue), "Consumer");
      tProducer.start();
      tConsumer.start();
   }
}