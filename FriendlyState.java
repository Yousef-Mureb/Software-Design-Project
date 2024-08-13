
public class FriendlyState implements WaltState {
	
	String name="friendly";
	
	@Override
	public void next(Walter walter, String state) {
		// TODO Auto-generated method stub
		if(state.toLowerCase().contains("aggressive"))
		walter.setState(new AggressiveState());
		else if(state.toLowerCase().contains("neutral"))
		walter.setState(new NeutralState());
//		else if(state.toLowerCase().contains("friendly"))
//		/UI.print("walt is friendly");
	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method stub
		UI.print("walt is now friendly");
	}

	public String getName(){
		return name;
	}
}
