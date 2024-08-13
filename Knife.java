
public class Knife implements Object{
	String name="knife";
	TCPClient2 tcp;

	public Knife(TCPClient2 tcp) {
		this.tcp=tcp;
	}

	public void function() {
		UI.print("The knife is sharp enough to be used to slice through various materials");
	}

	public void use() {
		tcp.setSlice(false);
		UI.print("(move the phone in an up-down motion as if you are chopping)");
		while(!tcp.isSlice()) {
			try{
			Thread.sleep(10);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	
		
		
		
		//im guessing it will exit once tcp.isSlice() returns true so just continue the code after doing knife.use
	}
}
