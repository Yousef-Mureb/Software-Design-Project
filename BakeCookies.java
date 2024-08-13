
public class BakeCookies implements Runnable{

	Knife knife;
	Thread t;
	Bowl bowl;
	UI ui;
	Pan pan;
	TCPClient2 tcp;
	Whisk whisk;
	int shortSleep=4000, longSleep=6000;

	public BakeCookies(TCPClient2 tcp){
		this.tcp=tcp;
		knife=new Knife(tcp);
		bowl=new Bowl(tcp);
		whisk=new Whisk(tcp);
		pan=new Pan(tcp);
		ui=UI.getInstance();
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

	void prepareCookies() {

		chopChocolate();
		mixTogether();
		addIngredients();
		placeInOven();

		//takeOutOven(); should have this depend on a clock of sorts, sort of like a timed event
	}

	public Thread getThread(){
		return t;
	}

	private void chopChocolate() {
		// TODO Auto-generated method stub
		sleep(1000);
		ui.print("(use your phone through the cookie baking process)\n");
		sleep(shortSleep);
		ui.print("First, I've got to finely chop the chocolate");
		knife.use();
		
		
		ui.print(" ⡟⠶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⣷⠀⠀⣟⠳⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⢿⠀⠀⢻⠀⠀⠉⠓⢦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⢸⡆⠀⠸⡇⠀⠀⠀⠀⠈⠙⠶⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀"+
"				⠀⣧⠀⠀⢻⡀⠀⠀⠀⠀⠀⠀⠀⠙⠳⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n⠀"+
"				⠀⠘⣇⠀⠀⢳⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠓⢦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠘⣧⡀⠀⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠶⣤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠈⢳⣄⠀⠈⠳⡀⠲⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⢦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠙⢷⣄⠀⠉⠳⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠷⣤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠙⠷⣦⡀⠈⠛⢦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠉⠻⢦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⢷⣄⡀⠈⠓⢦⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢶⣤⡀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠋⠛⢶⣄⡀⠈⠙⠦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠛⠷⣤⡀⠀⠀⠀⠀⠀\n"+
"			⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀   ⠀⠈⠛⢶⣄⡀⠀⠉⠳⢤⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⢙⣳⣤⣀⣀⠀⠀\n"+
"			⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀    ⠀⠀⠀⠈⠙⠷⣄⡀⠀⠈⠓⠦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣠⣶⡛⠋⠀⠀⠉⠛⠦⣄⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"  +
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⠳⣤⡀⠀⠈⠙⠲⣄⡀⠀⠀⠀⠀⣠⣾⡛⠃⠀⠀⠀⠀⠀⠀⠀⠀⠙⠲⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠳⣦⣀⠀⠀⠉⠳⢦⣀⢰⡟⣻⣄⡀⠀⠀⠀⠀⣠⣶⣲⣶⠀⠀⠀⠉⠳⢦⣄⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠉⠛⠶⣄⡀⢀⣾⡿⣿⣿⡦⡟⢦⣀⠀⠀⠈⠛⠛⠉⠀⠀⠀⠀⠀⠀⠉⠻⢶⣄⡀⠀⠀⠀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠿⠟⠋⠀⠀⠉⠛⣷⣤⣈⠳⢤⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠛⢷⣤⡀⠀⠀⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⠻⢿⣦⡉⠳⣄⡀⠀⠀⠀⠀⠀⠀⢀⣤⣤⣤⠀⠀⠈⠻⣶⣄⠀⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣶⣄⡙⠲⣄⡀⠀⠀⠀⠀⠟⠚⠛⠀⠀⠀⠀⢀⣹⣷  ⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠛⠻⣿⣶⡙⠲⣄⡀⠀⠀⠀⠀⠀⠀⣠⠞⠋⠀⣿   ⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠛⣿⣶⣦⣉⠓⠦⣄⡀⢠⡾⠋⠀⢀⢠⣿  ⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠻⢿⣦⣄⠀⢩⡟⢉⠀⢀⣴⠟⠙  ⠀\n"+
"				⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢹⣿⠶⣧⣬⣿⣿⠁⠀⠀   " );
		
		
		
		ui.print("Great, the chocolate's in the batter, let's get mixing\n");

	}

	private void addIngredients() {
		// TODO Auto-generated method stub

		sleep(shortSleep);
		ui.print("you have the cookie batter in the bowl, pour it onto the pan");
		bowl.use();

		ui.print("ingredients added. We're all set to bake!\n");
		

		//sensor to pour ingredients in here lol
	}



	private void mixTogether() {
		// TODO Auto-generated method stub
		sleep(shortSleep);
		ui.print("need to mix all the ingredients together now");
		ui.print("⣿⣿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣇⠐⣤⡈⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣦⣬⡿⠋⠙⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣧⡀⠀⠀⠈⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣦⡀⠀⠀⠘⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣶⣄⠀⠀⠙⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⠀⢀⣼⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡟⠑⢄⠀⠈⠛⠿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⠀⠻⣦⡀⠀⢄⣉⠛⠻⢿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡄⠀⠈⠻⣦⡀⠉⠻⣶⣤⡈⠛⢿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡀⢳⡄⠈⠻⣦⡀⠀⠙⠻⢦⠈⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡀⢻⣦⠀⠈⠑⢄⠙⢶⣤⡄⢸⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⡈⠻⣷⡀⢳⣄⠑⠀⠹⠃⣸⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣷⣄⡈⠓⠀⠿⠷⠂⢀⣰⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣶⣶⣶⣾⣿⣿⣿⣿");
		whisk.use();
		ui.print("all mixed up\n");


	}

	private void placeInOven() {
		// TODO Auto-generated method stub
		
		sleep(shortSleep);
		ui.print("Theyre ready to be baked");
		pan.use();
		ui.print("The cookies are now in the oven! \n");
		
		ui.print("  				_.-------------.\r\n"
				+ "             .-''            .;'|\r\n"
				+ "            ;==============;+'  |\r\n"
				+ "            |              |    |\r\n"
				+ "            | (} (} {) (}  |    |\r\n"
				+ "            |              |    | \r\n"
				+ "            | .==========. |    |\r\n"
				+ "            | | _ .'\"+_/)| |    |\r\n"
				+ "            | |( \\(  (`( | |    |       \r\n"
				+ "            | | \\- `.  -)| |    |\r\n"
				+ "            | | ( (  _  )| |    |\r\n"
				+ "            | |  `--' `' | |    ;\r\n"
				+ "            | `----------' |  .'\r\n"
				+ "            |              |.'\r\n"
				+ "            `--------------'");
		
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub

		this.prepareCookies();

	}
}