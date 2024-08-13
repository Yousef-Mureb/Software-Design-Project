
public class NeutralState implements WaltState {

	String name="neutral";
	
	@Override
	public void next(Walter walter, String state) {
		// TODO Auto-generated method stub
		
		if(state.toLowerCase().contains("aggressive"))
		walter.setState(new AggressiveState());
//		else if(state.toLowerCase().contains("neutral"))
//		//ntn
		
		else if(state.toLowerCase().contains("friendly"))
		walter.setState(new FriendlyState());
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		
		UI.print("Walt is neutral now ");

	}
	
	public String getName(){
		return name;
	}
}
