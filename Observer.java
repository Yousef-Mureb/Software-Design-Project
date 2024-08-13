
public interface Observer {
	
	void setSubject(Subject subject);

	void update(Message m);
}