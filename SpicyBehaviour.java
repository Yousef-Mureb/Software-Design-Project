
public class SpicyBehaviour implements CookieBehaviour{
	String name="spicy";
	
	public String getName(){
		return name;
	}
	
	public void eat() throws InterruptedException{
		UI.print("Walter: Ah, I truly haven't lost my touch- another chemically sound cookie..");
		Thread.sleep(3000);
		UI.print("Walter: Wait, no no nonono this isnt right");
		Thread.sleep(2000);
		UI.print("Walter: I did everything as usual");
		Thread.sleep(1000);
		UI.print("Walter: I didn't leave it in the oven too long");
		Thread.sleep(1000);
		UI.print("Walter: I mixed the ingredients together until homogenous");
		Thread.sleep(2000);
		UI.print("Walter: I chopped the chocolate so that...");
		Thread.sleep(5000);
		UI.print("Walter: The chocolate...");
		Thread.sleep(1000);
		UI.print("Walter: JESSE THIS IS WHY YOU ARE JUST THE HELP ");
		Thread.sleep(500);
		UI.print("JUST BECAUSE YOUR FEELINGS GOT HURT YOU DECIDE TO COMPROMISE THE INTEGRITY OF MY PRODUCT?!");
		Thread.sleep(3000);
		UI.print("Walter: LISTEN HERE AND LISTEN GOOD ");
		Thread.sleep(500);
		UI.print("Walter: I will make sure that you will never get to touch an oven again if you so much as THINK\nof tampering with my recipe again ");
	}
}
