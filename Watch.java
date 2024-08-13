import java.util.concurrent.TimeUnit;

public class Watch extends ConcreteSubject implements Runnable{

	private static Watch instance;
	private int secondsPassed=0;
	Thread t;
	//Message m;
	boolean end=false, start=false;

	private Watch() {
		t=new Thread(this);
		t.start();
	}

	public Thread getThread() {
		return t;
	}
	public static synchronized Watch getInstance() {
		if (instance==null) instance=new Watch();
		return instance;
	}

	public void start() {
		start=true;
	}

	public void stop() {
		end=true;
	}

	public void run() {

		while(!start){
			try {
				t.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(secondsPassed<4 && !end) {
			try {
				TimeUnit.SECONDS.sleep(2); //is this right?
				secondsPassed++;
			}catch(InterruptedException e) {e.printStackTrace();}
			if(secondsPassed==4 && !end)
				UI.print((5-secondsPassed) + " SECOND LEFT!!! HURRY");
			else if(!end)
				UI.print((5-secondsPassed)+ " seconds left!!");
		} 

		if(!end) {



			UI.print("it is the end of the time! ");
			Message m=new Message(this, "watch",  secondsPassed+ " seconds have passed");
			publishMessage(m); //notifies player that GAMES OVER

		}



	}

}
