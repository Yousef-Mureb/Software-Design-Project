
public class Level  {

	TCPClient2 tcp;

	private LevelState state;
	public Level(){
		tcp=new TCPClient2();
		state = new RVtrailer(tcp);
		
	}
	


	public void nextState() {
		state.next(this);
	}
	public Thread getThread(){
		return state.getThread();
	}
	
	
	public void setState(LevelState state) {
		this.state = state;
	}

}
