import java.util.ArrayList;

public class RVtrailer implements Location,Runnable, LevelState{



	
	private Thread t;
	TCPClient2 tcp;
	Walter walter;
	UI ui= UI.getInstance();
	Cookie cookie;
	boolean MissionCompleted=false;
	


	ControlPanel panel= ControlPanel.getInstance();
	
	
	

	int shortSleep=4000, longSleep=6000;

	public RVtrailer(TCPClient2 tcp){

		walter=Walter.getInstance();
		this.tcp=tcp;
		cookie=new Cookie();
		
		
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

	public Thread getThread() 
	{
		return t;
	}

	@Override
	public void description() {
		// TODO Auto-generated method stub
		ui.print("We're at the trailer. This is where all the magic happens!");
		ui.print( "        .---------------------------------.\r\n"
				+ "       /        ___________________        \\\r\n"
				+ "     ,|________/  _______________  \\________|,\r\n"
				+ "      | .---. |  /               \\  | .---. |\r\n"
				+ "      | |   | | |                 |'%,|   | |\r\n"
				+ "      | |   | | |                 | | |   | |\r\n"
				+ ",---, | |   | | |                 | | |   | | ,---,\r\n"
				+ "`---'\\| `---' | `-----------------' | `---' |/'---'\r\n"
				+ "     ,'-------|  ___                |-------`,\r\n"
				+ "     |        | /__,|              '%,       |\r\n"
				+ "     |  (o)   | `---'               |   (o)  |\r\n"
				+ "     |  (o)   |       .-----.       |   (o)  |\r\n"
				+ "     |.------.|       |  O  |       |        |\r\n"
				+ "     ||NM   1||       | O O |       |        |\r\n"
				+ "     |`------'|       `-----'      '%,       |\r\n"
				+ "     |________|_____________________|________|\r\n"
				+ "     ~~~~'----------,_________,----------'~~~~\r\n"
				+ "      | \\~/ |                         | \\~/ |\r\n"
				+ "      |_____|                         |_____|");
		sleep(shortSleep);
		ui.print("Located in the dessert, Walt and Jesse bake cookies in a white and brown RV trailer.");
		sleep(shortSleep);
		ui.print( "This is how their interaction went :)\n");
		sleep(shortSleep);
		
		
		


	}

	private void dialogue(int num){


		if(num==1){
			ui.print("Walt: I'm going to need you to prep the RV for me");
			sleep(shortSleep);
			ui.print("Jesse: Aw cmon mista White, why can't you do it yourself?!\n");
			sleep(shortSleep);
			//this is where the choices come in
			ui.print("1. You were my best pastry chef, i need a mastermind alongside me and no one preps my station like you do" ); //nice
			ui.print("2. Because you are my sous chef for a reason, now make yourself useful"); //mad
			ui.print("3. I just need to test my skills again and I'd rather have eveyrthing ready before I step in");
			sleep(shortSleep);

			ui.print("How do I respond to Jesse?");

			int choiceNum=-1;
			
			
				
				

			while(choiceNum!=1 && choiceNum!=2 && choiceNum!=3){

				String choice = ui.read();

				if(!Character.isLetter(choice.charAt(0)))
					choiceNum=Integer.parseInt(choice);


				if(choiceNum==1)
				{	

					panel.buttonWasPressed(0, cookie);


				}
				else if(choiceNum==2)
				{

					panel.buttonWasPressed(1, cookie);

				}

				else if(choiceNum==3)
				{

					panel.buttonWasPressed(2, cookie);

				}

				else{
					ui.print("(Choose one of the three options by typing 1, 2 or 3)");
				}


			}	
			ui.print("Jesse goes into the RV to prep the station");
			sleep(longSleep);
			ui.print("It's time for you to go into the RV and see if you still have your touch ");

			sleep(longSleep);
			ui.print("let's get makin'");
			// depending on response, jesse will tamper with cookie and will affect the
			//type of cookie baked: aggressive= spicy cookie, neutral=sleepy, friendly=normal
			//we will be able to tell which cookie it is bcz at the end we'll try it
		}

		if(num==2){
			ui.print("\nAfter some time, Walter takes the cookies out of the oven");
			sleep(shortSleep);
			ui.print("The RV is filled with the smell of exquisitely baked cookies");
			UI.print("				⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣠⣴⣶⣿⣿⡿⠿⠷⣶⣤⣄⡀⠀⠀⠀⠀\n"+
				"				⠀⠀⠀⠀⠀⠀⢀⣴⣾⣿⣿⣿⣿⣿⣿⣇⠀⠀⢸⣿⣿⣿⣦⡀⠀⠀⠀⠀⠀\n⠀"+
				"				⠀⠀⠀⠀⢀⣴⣿⡿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠀\n⠀"+
				"				⠀⠀⠀⢠⣿⡟⠁⠀⠀⢹⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠀\n⠀"+
				"				⠀⠀⢠⣿⣿⣿⣦⣄⣠⣼⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⢿⣿⣿⣿⣷⠀⠀\n⠀"+
				"				⠀⠀⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⠀⢹⣿⣿⣿⡇⠀\n⠀"+
				"				⠀⠀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣿⣿⣿⣿⣿⠀\n⠀"+
				"				⠀⠀⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠀\n⠀"+
				"				⠀⠀⠈⢿⣿⣿⣿⣿⠟⠻⣿⣿⠋⠀⠉⣿⣿⣿⣿⣿⣿⣿⣿⡏⠀⢙⣿⠃⠀\n⠀"+
				"				⠀⠀⠀⠈⢿⣿⣿⠁⠀⠀⠘⣿⣆⠀⢀⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠏⠀⠀\n⠀"+
				"				⠀⠀⠀⠀⠀⠙⢿⣦⣤⣤⣶⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠋⠀⠀\n⠀⠀"+
				"				⠀⠀⠀⠀⠀⠀⠀⠙⠿⣿⣿⣿⣿⣿⣿⣿⣿⡟⠉⢹⣿⣿⡿⠟⠁⠀⠀⠀⠀\n⠀"+
				"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⠿⠿⣿⣿⣿⣷⡤⠾⠛      ");
			sleep(shortSleep);
			ui.print("Walter: Good...good... now we've gotta taste it... JESSEE GET OVER HERE!!");
			sleep(shortSleep);
			ui.print("Jesse: Jeez, take it easy, I'm right here");
			sleep(shortSleep);
			ui.print("Walter: Oh sorry, heh. Guess I'm a little excited to see how this batch turned out");
			sleep(shortSleep);
			ui.print("they both bite into it\n");
			sleep(longSleep);
			cookie.use();
			sleep(shortSleep);
			ui.print("\nWalter:....");
			sleep(shortSleep);
			ui.print("Walter: Well, now that that's over...");
			sleep(shortSleep);

		}




	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return "RVtrailer";

	}

	public void populate(Character character) {
		// TODO Auto-generated method stub
		chars.add(character);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		description();
		dialogue(1);
				BakeCookies bakin=new BakeCookies(tcp);
				try {
					bakin.getThread().join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			}
			
		dialogue(2);

		ui.print("Walter: we should go to the investor and show him our product");
		sleep(shortSleep);
		ui.print("Jesse: Okay mista White. Lets head over\n");
//		sleep(shortSleep);
//		ui.print("Walter: Okay just give me a few minuites.(I hope Skylar doesnt find out)");
		sleep(longSleep);






	}

	@Override
	public void next(Level context) {
		// TODO Auto-generated method stub
		context.setState(new TucosOffice(tcp));
		
		
	}

}
