
import java.util.ArrayList;

public class TucosOffice extends ConcreteObserver implements Location,Runnable,LevelState{

	Walter walt;
	//Jesse jesse;
	Tuco tuco;
	FlourBomb bomb;
	Watch watch = Watch.getInstance();
	Thread t;
	TCPClient2 tcp;
	UI ui;
	ControlPanel controlPanel= ControlPanel.getInstance();
	int shortSleep=4000, longSleep=6000, dialogue=-1;
	boolean threwBomb=false, end=false;

	public TucosOffice(TCPClient2 tcp)
	{

		tuco=new Tuco();
		setSubject(tuco);
		setSubject(watch);

		//jesse=new Jesse(tuco);
		walt= Walter.getInstance(tcp);
		bomb= new FlourBomb(tcp);
		this.tcp=tcp;
		t=new Thread(this);
		t.start();
		ui=UI.getInstance();



	}


	private void sleep(int sleep){
		try {
			t.sleep(sleep);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	public Thread getThread(){
		return t;
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		UI.print("Walt and Jesse decide to meet up with Tuco and discuss with a potential investor ");

		sleep(shortSleep);
		UI.print("Tucos Office is very intimidating and so Walt and Jess were a bit nervous...");
		sleep(shortSleep);
		UI.print("However, the two still manage to present their product to tuco and this is what happened :)\n");
		sleep(longSleep);


	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Tuco's Office";
	}


	@Override
	public void update(Message m){
		if(m.topic.contains("watch")){

			if(m.payload.contains("4") && !threwBomb){
				ui.print("Walter: No, I was too slow!");
				sleep(shortSleep);
				
				ui.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⠀⠀⢀⣤⣤⣤⣶⣶⣷⣤⣀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣶⣶⣶⠀⠀⠀⠀⣠⣾⣿⣿⡇⠀⣿⣿⣿⣿⠿⠛⠉⠉⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⠀⠀⠀⠀⠀⢀⣿⣿⣶⡀⠀⠀⠀⠀⠀⣾⣿⣿⣿⡄⠀⢀⣴⣿⣿⣿⣿⠁⢸⣿⣿⣿⣀⣤⡀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⣠⣴⣶⣿⣿⣿⣿⣿⣷⠀⠀⠀⠀⣼⣿⣿⣿⣧⠀⠀⠀⠀⢰⣿⣿⣿⣿⣇⣠⣿⣿⣿⣿⣿⡏⢠⣿⣿⣿⣿⣿⡿⠗⠂⠀⠀\r\n"
						+ "⠀⠀⠀⣰⣾⣿⣿⠟⠛⠉⠉⠉⠉⠋⠀⠀⠀⣰⣿⣿⣿⣿⣿⣇⣠⣤⣤⣿⣿⣿⢿⣿⣿⣿⣿⢿⣿⣿⡿⠀⣼⣿⣿⡟⠉⠁⢀⣀⡄⠀⠀\r\n"
						+ "⠀⢀⣾⣿⡿⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⣿⣿⣿⣴⣿⣿⣿⣿⡿⣿⣿⣿⡏⠈⢿⣿⣿⠏⣾⣿⣿⠃⢠⣿⣿⣿⣶⣶⣿⣿⣿⡷⠦⠀\r\n"
						+ "⢠⣾⣿⡿⠀⠀⠀⣀⣠⣴⣶⣿⣿⡷⠀⣠⣿⣿⣿⣿⡿⠟⣿⣿⣿⣠⣿⣿⣿⠀⠀⠀⠀⠁⢸⣿⣿⡏⠀⣼⣿⣿⣿⠿⠛⠛⠉⠀⠀⠀⠀\r\n"
						+ "⢸⣿⣿⠣⣴⣾⣿⣿⣿⣿⣿⣿⡿⠃⣰⣿⣿⣿⠋⠁⠀⠀⠸⣿⣿⣿⣿⣿⠃⠀⠀⠀⠀⠀⠸⠿⠿⠀⠀⠛⠛⠟⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠸⣿⣿⣆⣉⣻⣭⣿⣿⣿⡿⠋⠀⠀⢿⣿⡿⠁⠀⠀⠀⠀⠀⠹⠟⠛⠛⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠙⠿⣿⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠀⠈⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣤⣤⣶⣶⣶⣶⣦⣄⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣷⠄⣤⣤⣤⣤⣶⣾⣷⣴⣿⣿⣿⣿⠿⠿⠛⣻⣿⣿⣷⡄\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣀⣠⣤⣄⠀⣶⣶⣤⡀⠀⠀⠀⠀⠀⠀⢀⣴⣿⠋⢠⣿⣿⣿⠿⠛⠋⠉⠛⣿⣿⣿⠏⢀⣤⣾⣿⣿⡿⠋⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠀⠀⣠⣴⣾⣿⣿⣿⣿⠓⢹⣿⣿⣷⠀⠀⠀⠀⢀⣶⣿⡿⠁⠀⣾⣿⣿⣟⣠⣤⠀⠀⢸⣿⣿⣿⣾⣿⣿⣿⡟⠋⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⣠⣾⣿⣿⡿⠛⠉⠸⣿⣦⡈⣿⣿⣿⡇⠀⠀⣰⣿⣿⡿⠁⠀⢸⣿⣿⣿⣿⣿⠿⠷⢀⣿⣿⣿⣿⡿⠛⣿⣿⣿⡀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⢀⣼⣿⣿⡿⠋⠀⠀⠀⠀⣿⣿⣧⠘⣿⣿⣿⡀⣼⣿⣿⡟⠀⠀⢀⣿⣿⣿⠋⠁⠀⣀⣀⣼⣿⣿⡟⠁⠀⠀⠘⣿⣿⣧⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⣼⣿⣿⡟⠀⠀⠀⠀⠀⣠⣿⣿⣿⠀⢹⣿⣿⣿⣿⣿⡟⠀⠀⠀⣼⣿⣿⣷⣶⣿⣿⣿⣿⣿⣿⡟⠀⠀⠀⠀⠀⠸⣿⣿⡆⠀⠀\r\n"
						+ "⠀⠀⠀⠀⢹⣿⣿⣇⠀⠀⢀⣠⣴⣿⣿⣿⡿⠀⠈⣿⣿⣿⣿⡟⠀⠀⠀⢰⣿⣿⣿⠿⠟⠛⠉⠁⠸⢿⡟⠀⠀⠀⠀⠀⠀⠀⠘⠋⠁⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠈⢻⣿⣿⣿⣾⣿⣿⣿⣿⣿⠟⠁⠀⠀⠸⣿⣿⡿⠁⠀⠀⠀⠈⠙⠛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
						+ "⠀⠀⠀⠀⠀⠀⠉⠛⠿⠿⠿⠿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
				
				System.exit(0);
			}
		}
		if(m.topic.contains("Tuco")){
			if(m.payload.contains("done")){
				end=true;
			}
			else if(m.payload.contains("spicy")){
				dialogue=2;
			}
			else if(m.payload.contains("sleepy")){
				dialogue=3;
			}
			else if(m.payload.contains("normal")){
				dialogue=4;
			}

		}
	}	


	public void dialogue(int num){

		if(num==0)
		{
			UI.print("Tuco: Welcome amigos, please have a seat" );
			sleep(shortSleep);
			UI.print("Walter: Thank you for having us tuco we are excited for this chance");
			sleep(shortSleep);
			UI.print("Jesse: alrightt let's get this party goin yo!");
			sleep(shortSleep);
			UI.print("Tuco: before we begin with trying your product, i must ask why do you want to work with me, besides you are the cookie king");
			sleep(shortSleep);
			//choice time

			UI.print("\nHow should I respond?\n");
			sleep(shortSleep);
			UI.print("1. Well uhhh you see, I was looking to test my talents elsewhere..");
			UI.print("2. Well, after getting stabbed in the back, I couldn't just keep slaving away at LosCookies");
			UI.print("3. Back when I was still working at LosCookies, I had the privilege of working with your uncle, Don Hector Salamanca.");

			//choice 1 = neutral
			//choice 2 = aggresive
			//choice 3 = friendly



			int response2 = -1;

			while(response2!=1 && response2!=2 && response2!=3){

				String choice = ui.read();

				if(!Character.isLetter(choice.charAt(0)))
					response2=Integer.parseInt(choice);

				if(response2!=1 && response2!=2 && response2!=3)
				UI.print("(Choose one of the three options by typing 1, 2 or 3)");
				
				//neutral response
				if(response2==1)
				{
					UI.print("\nWalter: Well uhhh you see, I was looking to test my talents elsewhere..");
					sleep(shortSleep);
					UI.print("Walter: So, I told Jesse and he said he knows you from when he was... not a baker");
					sleep(shortSleep);
					UI.print("Walter: And you sounded like the type of mane I'd want to work with, a professional");
					sleep(shortSleep);
					//panelbutton here
					controlPanel.buttonWasPressed(3,null);

				}

				//aggressive response
				else if(response2==2)
				{

					UI.print("\nWalter: Well, after getting stabbed in the back, I couldn't just keep slaving away at LosCookies");
					sleep(shortSleep);
					UI.print("Walter: Jesse knew our competition and I had him tell me of our closest competitor, and that would be you");
					sleep(shortSleep);
					UI.print("Walter: So I'm not really here for your money or your family.");
					sleep(shortSleep);
					UI.print("Walter: I'm just here to send a message, and show EVERYONE that you don't mess with Heisenberg");
					sleep(shortSleep);
					controlPanel.buttonWasPressed(4, null);
					
					
				}

				//friendly response
				else if(response2==3)
				{
					UI.print("\nWalter: Back when I was still working at LosCookies, I had the privilege of working with your uncle, Don Hector Salamanca.");
					sleep(shortSleep);
					UI.print("Walter: And I gotta tell you, what a man...");
					sleep(shortSleep);
					UI.print("Walter: I mean, really, I've never seen anyone demand respect at... at such a level before");
					sleep(shortSleep);
					UI.print("Walter: and the way he runs his business- astounding");
					sleep(shortSleep);
					UI.print("Walter: and he talks about you, you know? So I thought working with another Salamanca, one so successful such as yourself");
					sleep(shortSleep);
					UI.print("Walter: would make me feel right at home");
					sleep(shortSleep);
					controlPanel.buttonWasPressed(5, null);


				}
			}
			
	


		}
		else if(num==1){
			UI.print("\nWalter (whispering): He wants to taste MY cookies? Who does he think he is questioning the cookie king..");
			sleep(shortSleep);
			UI.print("Jesse (whispering): Well, he's a professional, he's gotta insepct tha goods don't he?");
			sleep(longSleep);
			UI.print("Jesse (whispering): I mean besides.... both of yall might be surprised..");
			sleep(shortSleep);
			UI.print("Walter (whispering): What do you mean surprised? I made a perfect batch just for this occasion");
			sleep(shortSleep);
			UI.print("Walter (whispering): Jesse, what batch of cookies did you get??");
			sleep(shortSleep);
			UI.print("Jesse (whispering): Mista White i got the ones on the brown counter");
			sleep(shortSleep);
			UI.print("Walter (whispering):YOU DID WHAT????");
			sleep(shortSleep);
			UI.print("Walter (whispering): Thats the batch with the diffirent cookies from when you tried to mess with me");
			sleep(shortSleep);
			UI.print("Jesse (whispering): I didn't know you didnt even mention it mann");
			sleep(longSleep);

			if(!end)
				UI.print("Jesse (whisepring): he sure is takin his time though");
			while(!end){
				sleep(10);				
			}

		}

		else if(num==3){//sleepy cookie
			UI.print("\nWalter: no, no, no you've got it all wrong, Mr Salamanca");
			sleep(shortSleep);
			UI.print("Walter: me and my partner here thought of adding a little something special, you know..");
			sleep(shortSleep);
			UI.print("Walter: to help make our patrons feel a bit more relaxed (ー。ー) zzz\nIt's very needed with all the everyday stresses");
			
			sleep(shortSleep);
		}
		else if (num==2 ){//spicy cookie
			UI.print("\nJesse: well uhhh, you see Mr. Tuco we was jus tryin to spice ♨ things up, haha");
			sleep(shortSleep);
			UI.print("Jesse: y'know, all literally and stuff");
			sleep(shortSleep);
			UI.print("Jesse: so we added a bit of spice into our chocolate, adds a lil pang, ya feel me?");
			sleep(longSleep);
			UI.print("Tuco: I HATE spice");
			sleep(shortSleep);

		}
		else if(num==4){//normal cookie
			UI.print("\nJesse: well, uhh y'know..");
			sleep(shortSleep);
			UI.print("Jesse: I owe everything to mista White and all man, I can't just be leavin him like this");
			sleep(shortSleep);
			UI.print("Jesse: So uhh... I gotta say no, Tuco");
			sleep(shortSleep);
			UI.print("Walter: that's my boy ");
			sleep(shortSleep);
			UI.print("Tuco: ya that's nice and all, but..");
			sleep(shortSleep);
		}

		else if (num==5){
			UI.print("\nAfter the fiasco, Tuco seems to have a new-found appreciation for Mr. White's guts");
			sleep(shortSleep);
			UI.print("Thanks to that, Tuco reached out to Mr. White to make amends");
			sleep(shortSleep);
			UI.print("Partly because he still needed a way to sell his cookies and because he was surprised at how reasonable Tuco sounded,");
			sleep(shortSleep);
			ui.print("Walter White decides to conduct business with Tuco");
			sleep(longSleep);
			UI.print("A few weeks go by and Don Hector, a legend in the baking industry, hears about the fight Walt and Gustavo had");
			sleep(shortSleep);
			UI.print("Hector asks tuco to meet up with Walter to see what the heisenberg is all about");
			sleep(shortSleep);
			UI.print("the meeting was set up and this is how it went down :3\n");
			sleep(longSleep);

			UI.print("Hector: Been a while Walter, how come you don't ask about me?");
			sleep(shortSleep);
			UI.print("Walter: Well, Don Salamanca, I sort of cut off relations with Gustavo, and it felt like he was our link");
			sleep(shortSleep);
			UI.print("Water: And with that link gone.. I just didn't feel it appropriate- reaching out to you");
			sleep(shortSleep);
			UI.print("Hector: Well, speaking of our link, Gus- that's why I'm here");
			sleep(shortSleep);
			UI.print("Hector: You know I don't do these kind of things often, but he begged me for it.");
			sleep(shortSleep);
			UI.print("Hector: He cares, and he regrets what he's done, so please go talk to him for me");

		}


	}

	public void run(){


					description();
					dialogue(0);
					tuco.start();
					dialogue(1);
					
					while(dialogue==-1){
						sleep(10);
					}
					
					dialogue(dialogue);
					tuco.bomb();
					
					UI.print("\nWalter: JESSE, WE'RE LEAVING NOW");
					sleep(shortSleep);
					UI.print("Jesse: huh?");
					sleep(shortSleep);
					UI.print("Walter reveals a weird device- a bomb that will surprise tuco and give them a change to escape");
					sleep(shortSleep);
					
					watch.start();
					bomb.use();
					watch.stop();
					
					
					ui.print( "██████   ██████   ██████  ███    ███ \r\n"
							+ "██   ██ ██    ██ ██    ██ ████  ████ \r\n"
							+ "██████  ██    ██ ██    ██ ██ ████ ██ \r\n"
							+ "██   ██ ██    ██ ██    ██ ██  ██  ██ \r\n"
							+ "██████   ██████   ██████  ██      ██ \r\n"
							+ "					\n\n");
					
					
					
					
					

					
					ui.print("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣀⣀⣀⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⣴⠞⠛⠛⠲⠛⠉⠉⣉⣉⢻⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢠⡶⠿⠀⣀⡀⠀⠀⠀⠀⠀⠈⠙⡏⠉⢻⡄⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⣿⠀⢠⠏⠁⠚⠉⠓⠀⠀⠀⠀⠀⡇⠀⠘⠙⠻⣦⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠘⣧⠀⠈⠄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣼⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠈⠛⣚⣧⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⡟⠁⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⣰⡏⠉⠀⠀⢀⣀⠀⠀⠀⠀⠀⠀⠀⣴⠟⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠸⣏⡀⠀⠀⠀⠉⠉⠙⢦⠀⠀⣀⣠⡼⠃⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⢠⡞⠋⠁⠀⠀⠀⠀⠀⢘⣴⠞⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠈⢳⡄⠀⠀⠀⠀⠀⢰⡏⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠸⣇⠀⠀⢀⣤⣤⠞⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⣀⣤⡄⣸⡷⠟⠛⠋⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⣾⢹⣿⣀⣁⡄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⢿⣤⣿⣿⣿⠃⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠉⠉⠉⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
					sleep(shortSleep);
					ui.print("Tuco's vision turned white. ");
					ui.print("Walter dragged Jesse out the office.");
					sleep(shortSleep);
					ui.print("\nJesse: Yo mista White that was crazy");
					sleep(shortSleep);
					ui.print("Walter: well if you payed attention when i was teaching you, you would know how to make it");
					sleep(2*longSleep);		
//
		dialogue(5);

	}

	@Override
	public void next(Level context) {
		// TODO Auto-generated method stub
		context.setState(new LosCookiesCabron(tcp));

		
	}
}
