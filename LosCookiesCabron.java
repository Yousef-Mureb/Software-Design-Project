import java.util.ArrayList;

public class LosCookiesCabron extends ConcreteObserver implements Location,Runnable, LevelState {

	Thread t;
	TCPClient2 tcp;
	Walter walter;
	Gustavo gustavo;
	Tuco tuco;
	int shortSleep=4000, longSleep=6000;
	int endingChoice=-1;
	Fight fight;

	UI ui= UI.getInstance();

	public LosCookiesCabron(TCPClient2 tcp){


		gustavo= new Gustavo();
		tuco=new Tuco();
		walter = Walter.getInstance();
		this.tcp=tcp;
		t=new Thread(this);
		t.start();
	}

	private void sleep(int sleep){
		try {
			t.sleep(sleep);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}


	@Override
	public void next(Level context) {
		// TODO Auto-generated method stub



	}
	@Override
	public Thread getThread() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "Los Cookies Cabrons";

	}

	@Override 
	public void update(Message m){
		if(m.topic.contains("hands")){
			if(m.payload.contains("upper")){


			}
		}
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		ui.print("Walter eventually meets up with gustavo at LosCookiesCabron.");
		sleep(shortSleep);
		ui.print("heres how the meeting went\n");
		sleep(longSleep);
		ui.print("Gustavo: Hello Walter, how is everything?");
		sleep(shortSleep);
		ui.print("Walter: doing great, hows business");
		sleep(shortSleep);
		ui.print("Gustavo: i understand we had our diffirences in the past, and I apologise for any wrongdoing on my part");
		sleep(longSleep);
		ui.print("Gustavo: That said, i hope to put it behind us, and move on");
		sleep(shortSleep);
		ui.print("Gustavo: i have an offer, i want you to work with me again, seeing that your name still rules the streets.");
		sleep(shortSleep);
		ui.print("Gustavo: You will have complete rein again, as king... what do you think?\n");
		sleep(shortSleep);





	}

	public void run() {

		description();
		
		if(walter.getState().contains("neutral")){
			//choice
			ui.print("What do I do now?\n");
			sleep(shortSleep);
			ui.print("1. Accept, he seems reasonable");
			//sleep(shortSleep);
			ui.print("2. He is DONE");
			sleep(shortSleep);
			while(endingChoice!=1 && endingChoice!=2){

				String choice = ui.read();

				if(!Character.isLetter(choice.charAt(0)))
					endingChoice=Integer.parseInt(choice);

				if(endingChoice ==1)
				{

					walter.setState(new FriendlyState());
				}
				else  if(endingChoice==2) {


					walter.setState(new AggressiveState());
				}
				else
					ui.print("(Choose one of the two options by typing 1 or 2)");

			}

		}

		if(walter.getState().contains("aggressive")){
			//coward sent u here instead of talkin to me hiimself
			//he just thought it was more conveninet
			//worried that since gettin more successful, will put the store out of business
			//wwell ill go show him, ill put HIM out of business
			UI.print("Walter: so, you done?");
			sleep(shortSleep);
			UI.print("Walter: seems like it, good..");
			sleep(shortSleep);
			UI.print("Walter: I'm not here to listen to your business proposal or any of that nonesense");
			sleep(shortSleep);
			UI.print("Walter: I figured you'd give some version of that customer service talk after you sent Hector to clean up your mess");
			sleep(shortSleep);
			UI.print("Walter: You sent him because you thought it'd be more efficient- more convenient");
			sleep(shortSleep);
			UI.print("Walter: you saw that I was taking over the market again and were trying to do damage control");
			sleep(shortSleep);
			UI.print("Walter: you're nothing short of a coward...");
			sleep(shortSleep);
			UI.print("Walter: and I'm here to take YOU out");
			sleep(shortSleep);	
			UI.print("Gustavo: I guess this is it then, if we can't settle this in a civil way; let the stronger man rein king");
			gustavo = new Gustavo();

			ui.print("Gustavo decides to fight you, do your best to defeat him! ");
			fight = new Fight(gustavo,null);



		}
		else if(walter.getState().contains("friendly"))
		{

			ui.print("Walter: Despite our diffirences, i would like to put that behind us and work together again");
			sleep(shortSleep);
			ui.print("Gustavo: Perfect, i will set up the kitchen for you to run it, thank you Walter");
			sleep(shortSleep);
			tuco = new Tuco();
			gustavo = new Gustavo();
			UI.print("Tuco: SO THATS HOW IT IS FOO???");
			sleep(shortSleep);
			UI.print("Tuco: Uncle Hector told me about why he came, and I thought I oughta check on my business partner");
			sleep(shortSleep);
			UI.print("Tuco: Turns out, he tryna stab in my back");
			sleep(shortSleep);
			UI.print("Gustavo: doesn't look like he's leaving here peacefully..");

			sleep(shortSleep);
			ui.print("Tuco comes back to fight Walter and Gustavo, defeat Tuco! ");
			sleep(shortSleep);
			fight = new Fight(tuco,gustavo);

			// implement fight against tuco

			//sure tihng pal
		}


		//fight ends



		if(walter.getHealth()>0)
		{

			UI.print("Walter: I have become the cookie king once more!!!" );
			sleep(shortSleep);
			UI.print("Walter: NOW SAY MY NAME!!" );
			
			String choice = "";

			while(!choice.contains("heisenberg")){
				choice= ui.read();
				if(choice.contains("heisenberg")){

					ui.print("Thank you for playing, we hope you enjoyed the game! ");
					
					
					
					
					ui.print("⠀⠀⠀⠀⠀⠀⠀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢠⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⢸⡿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⢿⣧⠀⠀⠀⠀⠀\r\n"
							+ "⢀⣀⣀⣀⣀⣸⣇⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣀⣸⣿⣀⣀⣀⣀⠀\r\n"
							+ "⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠇\r\n"
							+ "⠀⠀⠀⠉⢙⣿⡿⠿⠿⠿⠿⠿⢿⣿⣿⣿⠿⠿⠿⠿⠿⢿⣿⣛⠉⠁⠀⠀\r\n"
							+ "⠀⠀⠀⣰⡟⠉⢰⣶⣶⣶⣶⣶⣶⡶⢶⣶⣶⣶⣶⣶⣶⡆⠉⠻⣧⠀⠀⠀\r\n"
							+ "⠀⠀⠀⢻⣧⡀⠈⣿⣿⣿⣿⣿⡿⠁⠈⢿⣿⣿⣿⣿⣿⠁⠀⣠⡿⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠙⣿⡆⠈⠉⠉⠉⠉⠀⠀⠀⠀⠉⠉⠉⠉⠁⢰⣿⠋⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⣿⡇⠀⠀⠀⣠⣶⣶⣶⣶⣶⣶⣄⠀⠀⠀⢸⣿⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠸⣷⡀⠀⠀⣿⠛⠉⠉⠉⠉⠛⣿⠀⠀⢀⣾⠇⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠘⢿⣦⡀⣿⣄⠀⣾⣷⠀⣠⣿⣀⣴⡟⠁⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⠟⠁⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
							+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠛⠛⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
					

					System.exit(0);

				}

				else
					ui.print("(The game ends only when you type heisenberg)");

			}
		}

		//sleep(longSleep);


		else if(walter.getHealth()<=0){//walter lost
			UI.print("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠛⣋⣉⣉⣉⣉⣉⣉⣛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⢉⣔⣴⣶⡛⠛⠿⠿⢿⣿⣿⣿⣿⣦⣉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠋⣴⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠙⢿⡿⣿⣿⣧⡘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡈⠻⣿⣿⣿⣷⡈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⠸⠿⣿⣿⣇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⡘⠒⢶⠍⢹⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣟⣃⣀⣉⣛⠣⠌⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠻⢇⠘⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⣀⢰⢿⣷⡿⢈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⣈⣂⢹⣿⣟⠛⠿⠿⠿⣟⣻⣿⣿⣍⣉⣭⠉⣉⠈⠙⢶⣾⠇⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣧⠹⢯⡁⠿⣿⣷⡶⠄⠯⠭⢛⠻⢿⡿⠉⠀⠒⠓⠚⠛⠀⠓⠂⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⣾⣾⣇⣻⣷⣦⣤⠰⢶⡾⢛⣿⣿⣇⡀⢶⡀⡻⠿⢠⠘⠃⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣟⣿⣿⣿⣿⣿⣿⣷⣶⣿⣿⣿⣿⣟⠻⠦⠬⣿⣧⠀⠰⡁⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣌⠙⣿⣿⣿⣿⣿⣿⠿⣿⣿⣿⣿⣿⡟⢿⣷⣶⠎⡀⡰⢰⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠋⢁⡄⣿⣿⣿⣿⣿⣿⣶⡟⢿⣿⣿⡟⢿⣦⢹⡏⣰⢡⠅⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⠿⠛⢉⣴⣾⣿⡟⠀⣿⣿⣿⣿⣿⠛⠋⠁⠀⠉⠉⠀⠀⠉⢀⢰⠇⣏⣼⣿⣭⣛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⠟⠛⣛⣍⣠⡤⢠⣿⣿⣿⣿⡟⠁⡀⢹⣿⣿⣿⠇⢠⡖⠀⠄⠲⠖⠂⢐⣄⠀⠜⢰⠇⢿⣿⣟⠿⠶⣦⣭⣟⡛⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⡿⠛⡉⣴⣶⣾⣿⣿⡟⢁⣿⣿⣿⣿⣿⠃⢠⣿⠈⣿⣿⣿⠀⣻⣿⣄⣈⣀⣀⣠⣾⡟⢰⣷⡾⠀⢸⣿⣿⣷⣐⢦⣝⣛⣻⣷⢤⣝⡻⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⡟⠡⣴⣿⣿⣿⣿⣿⣿⣿⢳⣿⣿⣿⣿⣿⣿⠀⢸⡿⠀⠘⢿⡿⠀⠟⠛⠛⠛⠛⠛⠿⠋⠀⣼⡟⢠⢸⠈⣿⣿⣿⠈⣷⣦⣙⣻⣉⡛⠾⣿⣦⡘⠿⣿⣿⣿⣿⣿⣿\n"+
"⣿⡿⠋⢠⣾⣿⣿⣿⣿⣿⣿⡿⢁⣾⣿⣿⣿⣿⣿⢃⠀⠿⠃⡀⠀⢀⡀⠀⣴⣶⣶⣶⣶⣶⣶⠆⠰⠽⠃⡼⢸⡿⣿⣿⡟⢇⣾⣿⣿⢻⣿⣿⣷⣮⡉⠿⣶⡈⡙⢿⣿⣿⣿\n"+
"⣿⢁⢠⣿⣿⣿⣿⣿⣿⣿⡿⢡⣾⣿⣿⣿⣿⣿⢃⣼⡀⠀⢠⣷⡀⠀⡛⢷⣬⣛⠛⠛⠛⠛⠋⡀⠀⠀⠬⠃⣿⣿⣿⡟⣡⣾⣿⣿⣿⠈⢻⣿⣿⣿⣿⣄⠈⢧⣹⡌⢻⣿⣿\n"+
"⡏⣾⣿⣿⣿⣿⣿⣿⣿⡟⢡⣿⣿⣿⣿⣿⡿⣡⣾⣿⡇⢠⣤⡙⠧⠐⣿⣶⣍⠻⣿⡿⠿⠛⢉⠀⣰⣧⠀⢀⠉⡙⠿⢷⣿⣿⣿⣿⣿⡇⠘⣿⣿⣿⣿⣿⣾⡌⢷⠹⣄⠙⣿\n"+
"⡇⣿⣿⣿⣿⣿⣿⣿⣿⣧⣿⣿⣿⣿⡿⢋⠘⣿⣿⣿⡇⢸⣿⣿⣶⣶⣤⣬⣉⣀⣴⢦⣿⣿⣾⡄⣿⠃⢀⣿⣷⡈⢿⣦⡙⢿⣿⣿⣿⣷⣤⣿⣿⣿⣿⣿⣿⣿⣮⣥⣽⣤⠹\n"+
"⡇⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣿⣳⠘⣿⣿⡇⢸⣿⣿⣿⣿⣿⡿⣿⣿⣷⣶⣿⣿⣿⣯⣦⡄⣼⣿⠟⣁⢀⣉⠻⠶⣿⣿⣿⣿⣭⣻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢹\n"+
"⣷⠸⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⡇⢸⣿⣿⣿⣿⣿⠁⣿⣿⣿⣿⣿⣯⡛⠿⠿⢳⣿⠟⣴⣯⣾⣿⣧⣤⣤⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢸\n"+
"⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⢸⣿⣿⣿⣿⣿⠀⣿⣿⣿⣿⣿⣿⣿⣷⡆⢸⠏⣰⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⣿⣿⡇⣾⣿⣿⣿⣿⣿⣦⣿⣿⣿⣿⣿⣿⣿⣿⡇⠘⢸⢇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡇⣿⣿⣇⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠃⢆⣿⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿");
			UI.print("Walter: heh, guess this is as far as my pride gets me...");
			sleep(shortSleep);
			UI.print("Walter: It was a good run for a retired baker, heheh");
			sleep(longSleep);
			UI.print("Walter: take care of Jesse for me");
			sleep(shortSleep);
			UI.print("Walter's time as the cookie king has passed, a new king shall rein");
			sleep(shortSleep);
			UI.print("Game over");
			System.exit(0);
		}
	}

}

