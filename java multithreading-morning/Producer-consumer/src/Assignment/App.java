package Assignment;
import java.util.*;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		App app=new App();
		app.producerConsumer();
	}

	List<Integer> elements= new LinkedList<>();  
	int maxCapacity=5,range=100;
	boolean flag=true;
	public  void addValue() throws InterruptedException
	{
		Random rand=new Random();
		while(flag)
		{	
			synchronized(elements)
			{
				if(elements.size()<maxCapacity)
				{
					int currElement=rand.nextInt(range);
					elements.add(currElement);
					System.out.println(Thread.currentThread().getName()  + " produced : "+currElement);
					elements.notify();
					Thread.sleep(1000);
				}
				else
				{
					elements.wait();
				}
			}
		}
	}
	
	
	public synchronized void removeValue() throws InterruptedException
	{	
		while(flag)
		{
			synchronized(elements)
			{	
				if(elements.size()==0)
				{
					elements.wait();
				}
				else 
				{
					int currElement=elements.remove(0);
					System.out.println(Thread.currentThread().getName()  + " consumed : "+currElement);	
					elements.notify();
					Thread.sleep(1000);	
				}
			}
		}
		
	}
	
	
	
	public void producerConsumer()
	{
		Thread producer=new Thread( new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					addValue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		
		Thread consumer =new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					removeValue();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		});
		
		producer.start();
		consumer.start();
			
		try {
			producer.join();
			consumer.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
}
