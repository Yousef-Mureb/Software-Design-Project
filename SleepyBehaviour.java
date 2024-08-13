
public class SleepyBehaviour implements CookieBehaviour{
	
	String name="sleepy";
	
	public String getName(){
		return name;
	}
	
	public void eat() throws InterruptedException{
		UI.print("Walter: Ah, I truly haven't lost my touch- another chemically sound cookie");
		
		Thread.sleep(3000);
		
		UI.print("Walter: Oh... Jesse, could you... just let me lie here for a couple of minutes?");
		
		Thread.sleep(3000);
		
		UI.print("(That was a sleepy cookie, Jesse must've added something to the chocolate)");
		
		Thread.sleep(30000);
		UI.print("Walter: Now, I really needed the sleep, but if you ever mess with my chocolate again, I'll.. I'll");
		Thread.sleep(3000);
		UI.print("Walter: I'll make sure the only baking you do is at your aunt's house");
		
	}
}
