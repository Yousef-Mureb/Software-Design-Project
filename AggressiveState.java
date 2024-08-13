
public class AggressiveState implements WaltState {
	
	String name="aggressive";
	
	public void next(Walter walt, String nextString) {
		// TODO Auto-generated method stub

		if(nextString.toLowerCase().contains("neutral"))
		walt.setState(new NeutralState());

		else if(nextString.toLowerCase().contains("friendly"))
			walt.setState(new FriendlyState());
//		else if(nextString.toLowerCase().contains("aggresive"))
//			UI.print("");

	}

	@Override
	public void printStatus() {
		// TODO Auto-generated method 



	}
	
	public String getName(){
		return name;
	}
}
