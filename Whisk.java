
public class Whisk implements Object{
	String name="whisk";
	TCPClient2 tcp;

	public Whisk(TCPClient2 tcp) {
		this.tcp=tcp;
	}

	public void function() {
		UI.print("The whisk is now being used");
	}

	public void use() {
		tcp.setMix(false);
		UI.print("(to use the whisk, rotate the phone in a circular motion pointing it downwards)");
		while(!tcp.isMix()) {
			try{
			Thread.sleep(10);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	
		
		
		
		//im guessing it will exit once tcp.isSlice() returns true so just continue the code after doing knife.use
	}
}
