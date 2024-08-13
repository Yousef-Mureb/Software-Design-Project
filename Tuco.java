import java.util.Random;

public class Tuco extends ConcreteSubject implements Runnable, Characters{


	String name= "Tuco Salamanca";
	int sleepyStatus = 0, spicyStatus=0, normalStatus=0, shortSleep=4000, longSleep=6000;
	Thread t;
	int health = 100;
	public  Tuco(){

		t=new Thread(this);

	}
	
	@Override
	public int getHealth() {
		// TODO Auto-generated method stub
		return health;
	}

	@Override
	public int reduceHealth(int dmg) {
		// TODO Auto-generated method stub
		if(dmg>health)
			health=0;
			else
			health-=dmg;
			return health;
	}

	public void start(){
		t.start();
	}

	public String getName(){
		return name;
	}
	
	private void sleep(int sleep){
		try {
			Thread.sleep(sleep);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub



		Random rand = new Random();
		int choice;
	


		while(sleepyStatus!=3 && spicyStatus!=3 && normalStatus!=3)
		{
			choice = rand.nextInt(3);

			if(choice==0)
			{

				UI.print("\nTuco(muttering): hmmmm spicy- who makes spicy cookies?\n");
				spicyStatus++;

			}

			else if(choice==1){
				UI.print("\nTuco(muttering): this one got me feelin a lil dizzy\n");
				sleepyStatus++;
			}


			else if(choice==2){

				UI.print("\nTuco(muttering): tasty \n");
				normalStatus++;

			}

			sleep(2*longSleep);

		}
		Message m= new Message(this,"Tuco","done");
		publishMessage(m);
		UI.print("Tuco: Enough with you two!");
		sleep(shortSleep);

		if(sleepyStatus==3){
			UI.print("Tuco:... mannn");
			sleep(longSleep);
			UI.print("Tuco: You guys.. make some GOOD cookies");
			sleep(longSleep);
			UI.print("Tuco: but MaN....");
			sleep(longSleep);
			UI.print("Tuco: soMethIng's gottA Be up wiTh ThEEse..");
			sleep(longSleep);
			UI.print("he takes a sip of something");
			sleep(shortSleep);
			UI.print("Tuco: and you know, I can't help but think...");
			sleep(shortSleep);
			UI.print("Tuco: that you're tryna do somethin to me y'know?");
			UI.print("Tuco: and I dont appreciate that");
			m=new Message(this, "Tuco", "sleepy");
			
			
			
			
		}
			
		else if (spicyStatus==3)
		{
			
			UI.print("Tuco: What did you guys put in this?? Why is it so spicy!! ");
			sleep(shortSleep);
			UI.print("Tuco: I mean, these are cookies man! They're supposed to be sweet, make you feel better!");
			sleep(shortSleep);
			UI.print("Tuco: But this.. this just burns me up");
			m=new Message(this, "Tuco" , "spicy");
		}
		
		else if (normalStatus==3)
		{
			UI.print("Tuco: those were some of the best cookies i have ever had");
			sleep(shortSleep);
			UI.print("Tuco: you guys make an excellent team and i love the work you put out");
			sleep(shortSleep);
			UI.print("Tuco: With that said, I would like Jesse to work for me");
			sleep(shortSleep);
			UI.print("i will pay you well Jesse and personally gift you a brand new car");
			sleep(shortSleep);
			UI.print("Tuco: So, what do you say? ");
			m=new Message(this, "Tuco", "normal");

			
		}
		
		publishMessage(m);
	}

	public void bomb() {
		// TODO Auto-generated method stub
		UI.print("\nTuco: forget it, none of it matters.");
		sleep(shortSleep);
		UI.print("Tuco: Listen up amigos, you're gonna be givin me your product");
		sleep(shortSleep);
		UI.print("Tuco: not only that, but I get to keep all the profits");
		sleep(shortSleep);
		UI.print("Tuco: and before you start thinkin there's no way I could do this");
		sleep(shortSleep);
		UI.print("Tuco: you better start thinkin about where you parked your sweet RV");
		sleep(shortSleep);
		
		
	}

	

	
	

}
