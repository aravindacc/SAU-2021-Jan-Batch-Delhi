
import java.util.LinkedList;
import java.util.Queue;

public class App 
{
	Queue<Integer> buffer = new LinkedList<>();
	final int bufferCapacity = 4;

	public static void main(String[] args) 
	{

		App controlObj = new App();

		Thread thread1 = new Thread(new Producer(controlObj));
		Thread thread2 = new Thread(new Consumer(controlObj));

		thread1.start();
		thread2.start();
	}

}
