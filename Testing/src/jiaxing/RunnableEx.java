package jiaxing;
//Create a class with runnable interface
public class RunnableEx implements Runnable{
	int count = 0;
	//Implement the run() method
	public void run(){
		System.out.println("Starting Runnalble");
		try{
			while(count<5){
				Thread.sleep(100);
				System.out.println("Runnable Thread, count: " + count);
				count++;
			}
		}catch(InterruptedException exc){
			System.out.println("Runnable interrupted");
		}
		System.out.println("Terminating Runnable");
		
	}
}

