package jiaxing;

public class ThreadEx extends Thread{
	int count = 0;
	public void run(){
		System.out.println("Start Thread");
		try{
			while(count<5){
				Thread.sleep(200);
				System.out.println("In thread, count is" + count++);
			}
		}catch(InterruptedException exc){
				exc.printStackTrace();
		}
		System.out.println("Terminate thread.");
	}
}
