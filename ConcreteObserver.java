import java.util.ArrayList;

public class ConcreteObserver implements Observer {
	private ArrayList<Subject> subject;

	public ConcreteObserver()
	{
		subject=new ArrayList<Subject>();
		
	}
	public ConcreteObserver(ArrayList<Subject> subject)
	{
		subject=new ArrayList<Subject>();
		for(int i = 0; i<subject.size(); i++) {
			subject.add(subject.get(i));
			subject.get(i).registerObserver(this);
		}
	}

	public void setSubject(Subject subject){
		this.subject.add(subject);
		subject.registerObserver(this);
	}
	
	@Override
	public void update(Message m) {
		// TODO Auto-generated method stub

	} 
}