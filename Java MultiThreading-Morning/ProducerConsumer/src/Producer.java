class Producer implements Runnable 
{

	App controlObj;
	private int producedElement = 0;

	Producer(App controlObj) 
	{
		this.controlObj = controlObj;
	}

	@Override
	public void run() 
	{
		while (true) 
		{
			try {
				produce(producedElement++);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

	public void produce(int producedElement) throws InterruptedException 
	{
		synchronized (controlObj.buffer) 
		{
			while (controlObj.buffer.size() == controlObj.bufferCapacity) 
			{
				System.out.print("\n\nBuffer is Full. Waiting for space.");
				System.out.print(" Buffer is: " + controlObj.buffer+"\n\n");
				controlObj.buffer.wait();
			}
		}

		synchronized (controlObj.buffer) 
		{
			System.out.print("\nProducing Element: " + producedElement);
			controlObj.buffer.add(producedElement);
			System.out.println(", Now Buffer is: " + controlObj.buffer);

			Thread.sleep(100);
			controlObj.buffer.notify();
		}
	}

}
