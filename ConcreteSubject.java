import java.util.ArrayList;
public class ConcreteSubject implements Subject{

	private ArrayList<Observer> observers;

	public ConcreteSubject(){
		observers = new ArrayList <Observer>();
	}

	
	
	public void registerObserver(Observer o) {
		observers.add(o);
	}
	
	public void removeObserver(Observer o) {
		observers.remove(o);
	}
	
	@Override
	public void publishMessage(Message m) {
		for (int i = 0; i < observers.size(); i++) {
			Observer observer = (Observer) observers.get(i);
			observer.update(m);
		}
	}
}