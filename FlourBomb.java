
public class FlourBomb implements Object{
	String name="flour bomb";
	TCPClient2 tcp;

	public FlourBomb(TCPClient2 tcp) {
		this.tcp=tcp;
	}

	public void function() {
		UI.print("The bomb is used to destroy tuco");
	}

	public void use() {
		tcp.setClap(false);
		UI.print("(to use the bomb, you have to make a noise loud enough to alert Jesse on the outside)");
		while(!tcp.isClap()) {
			try{
			Thread.sleep(10);
		}catch(InterruptedException e){e.printStackTrace();}
		}
	
		
		
		
		//im guessing it will exit once tcp.isSlice() returns true so just continue the code after doing knife.use
	}

}
