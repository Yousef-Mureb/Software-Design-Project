
public class Walter implements Characters{



	
	int health = 100;
	private WaltState waltstate;
	private static Walter instance;
	Hands hands;
	Cookie cookie;
	String name="Walter";
	// make constructor private so no else can call it from outside
	private Walter(TCPClient2 tcp) {
		waltstate= new NeutralState();
		hands=new Hands(tcp);
		cookie = new Cookie();
		cookie.setType("normal");
		
	}
	// one static method which can be called without creating an instance 
	// of the class.
	public static synchronized Walter getInstance(TCPClient2 tcp){
		if(instance == null){
			instance = new Walter(tcp);
			
		}
		return instance;

	}
	
	public String getName(){
		return name;
	}
	
	public static synchronized Walter getInstance(){
		if(instance==null){
			UI.print("WALT's not initialised yet");
		}
		return instance;
	}
	
	
	
	public int reduceHealth(int dmg){
		if(dmg>health)
		health=0;
		else
		health-=dmg;
		return health;
	}
	
	public void nextState(String type) {
		waltstate.next(this, type);
	}
	public void printStatus() {
		waltstate.printStatus();
	}
	public void setState(WaltState state) {
		this.waltstate = state;
	}
	
	public String getState(){
		return waltstate.getName();
	}

	public void response1(Cookie cookie)
	{
	
		nextState("friendly");
		cookie.setType("normal");
;	
		this.cookie=cookie;
	}
	public void response2(Cookie cookie) {
		

		cookie.setType("spicy");
		this.nextState("aggressive");

		this.cookie=cookie;
	}
	
	public void response3(Cookie cookie)
	{
	
		cookie.setType("sleepy");
		this.nextState("neutral");

		this.cookie=cookie;
	}
	
	public void response4()
	{
	
		this.nextState("neutral");
	}
	public void response5()
	{
	
		this.nextState("aggressive");
	}
	public void response6()
	{

		this.nextState("friendly");
	}
	
	public int getHealth(){
		return health;
	}
	
	
	public void attack(){
		hands.use();
	}
	
	public void useCookie()
	{
		
		cookie.use();
	}
	
	public void eatCookie(){
		cookie.eat();
		
		
	}
	
	public void heal(double heal){
		if(health>=85)
		health=100;
		else
		health+=heal;
	}
	
	
	public String getCookie(){
		return cookie.getType();
	}
	
	
	

}
