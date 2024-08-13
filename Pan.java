
public class Pan implements Object{
	String name="pan";
	TCPClient2 tcp;

	public Pan(TCPClient2 tcp) {
		this.tcp=tcp;
	}

	public void function() {
		UI.print("The pan can be placed in the oven to bake its contents");
	}

	public void use() {
		tcp.setSlide(false);
		UI.print("(to use the pan, slide it into the oven)");
		while(!tcp.isSlide()) {
			try{
			Thread.sleep(10);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	
		
		
		
		//im guessing it will exit once tcp.isSlice() returns true so just continue the code after doing knife.use
	}
}

