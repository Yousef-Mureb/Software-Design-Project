public class Hands  implements Object{
	String name="bowl";
	TCPClient2 tcp;
	boolean strong=false;

	Message m;
	public Hands(TCPClient2 tcp) {
		this.tcp=tcp;
	}

	public void function() {
		//UI.print("The bowl has all ingerdients. especailly the special one :)");
	}

	@Override
	public void use() {
		// TODO Auto-generated method stub

		tcp.setPunch(false);
		UI.print("(you'll want to move your phone in a straight motion)");	
		while(!tcp.isPunch()) {
			try{
				Thread.sleep(10);
			}catch(InterruptedException e)

			{

				e.printStackTrace();
			}
		}
	}
}