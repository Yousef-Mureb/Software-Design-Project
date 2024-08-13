import java.util.ArrayList;


public class ControlPanel { 
	static ArrayList<Command> slots;
	private static ControlPanel instance;

	private ControlPanel(ArrayList<Command> slots) { 
		this.slots=new ArrayList<Command>();

		for(int i=0; i<slots.size(); i++){
			this.slots.add(slots.get(i));
		}
	}

	public static synchronized void add(Command slot){
		slots.add(slot);
	}
	
	public static synchronized ControlPanel getInstance(ArrayList<Command> slots){
		if(instance == null){
			instance = new ControlPanel(slots);
		}
		return instance;
	}

	public static synchronized ControlPanel getInstance(){
		if(instance == null){
			return null;
		}
		return instance;
	}
	
	public void buttonWasPressed(int index, Cookie cookie){ 
		slots.get(index).execute(cookie);
	}
}