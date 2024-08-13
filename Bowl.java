
public class Bowl implements Object{
	String name="bowl";
	TCPClient2 tcp;

	public Bowl(TCPClient2 tcp) {
		this.tcp=tcp;
	}

	public void function() {
		UI.print("The bowl has all ingerdients. especailly the special one :)");
	}

	public void use() {
		
		tcp.setPour(false);
		UI.print("(you'll want to pour the contents of the bowl)");
		while(!tcp.isPour()) {
			try{
				Thread.sleep(10);
			}catch(InterruptedException e){e.printStackTrace();}
		}
	}
}
