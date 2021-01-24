class Consumer implements Runnable 
{
	App controlObj;

	public Consumer(App controlObj) 
	{
		this.controlObj = controlObj;
	}

	@Override
	public void run() 
	{
		while (true) 
		{
			try {
				consume();
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}

	}

	public void consume() throws InterruptedException 
	{
		synchronized (controlObj.buffer) 
		{
			while (controlObj.buffer.isEmpty()) 
			{
				System.out.println("\n\nBuffer is empty. Waiting for production.\n");
				controlObj.buffer.wait();
			}
		}

		synchronized (controlObj.buffer) 
		{
			Thread.sleep(1000);
			System.out.print("\nConsuming Element: " + controlObj.buffer.remove());
			System.out.println(", Now Buffer is: " + controlObj.buffer);
			controlObj.buffer.notify();
		}
	}

}