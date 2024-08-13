import java.util.Scanner;

public class Story implements Runnable {


	private String title;
	private String author;
	private UI ui;
	TCPClient2 tcp;
	Thread t;
	Watch watch=Watch.getInstance();
	int shortSleep=4000, longSleep=6000;

	public Story(TCPClient2 tcp) {
		ui= UI.getInstance();
		this.tcp = tcp;
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
	public void run() {
		// TODO Auto-generated method stub

				ui.print("Welcome to breaking cookies where the best cookies are made!!!");
				sleep(shortSleep);
				ui.print("In this interactive story, you are about to experience the exciting yet dramatic and dangerous life of the main character himself, \nWalter White.");
				sleep(shortSleep);
				
				ui.print("Before diving in, here's the story:\n");
				sleep(shortSleep);
				ui.print("Walter White is renowned for his cookies throughout New Mexico through his cookie store called LosCookiesCabron \nalongside his sous chef Jesse");
				sleep(shortSleep);
				ui.print("However, an incident occured with his dearest friend, and partner, Gustavo and Walt no longer works there!! ");
				
				sleep(shortSleep);
				ui.print("Walt tries to reclaim his throne as the cookie king by making his own cookie with Jesse's help\n");
				sleep(shortSleep);
				//ui.print("This is how their interaction went :)\n");
				
				sleep(longSleep);
				ui.print("The game makes you experience the story of Walter White through his eyes.\n");
				sleep(longSleep);
		ui.print("Say my name....");
			

		String choice = "";

		while(!choice.contains("heisenberg")){
			choice= ui.read();
			if(choice.contains("heisenberg")){

				ui.print("You're goshdarn right!\n");
				ui.print("⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠿⠿⠿⠿⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⠟⠋⠁⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⠁⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢺⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠆⠜⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⠿⠿⠛⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠉⠻⣿⣿⣿⣿⣿\n"+
"⣿⣿⡏⠁⠀⠀⠀⠀⠀⣀⣠⣤⣤⣶⣶⣶⣶⣶⣦⣤⡄⠀⠀⠀⠀⢀⣴⣿⣿⣿⣿⣿\n"+
"⣿⣿⣷⣄⠀⠀⠀⢠⣾⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢿⡧⠇⢀⣤⣶⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣾⣮⣭⣿⡻⣽⣒⠀⣤⣜⣭⠐⢐⣒⠢⢰⢸⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣏⣿⣿⣿⣿⣿⣿⡟⣾⣿⠂⢈⢿⣷⣞⣸⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣽⣿⣿⣷⣶⣾⡿⠿⣿⠗⠈⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⡿⠻⠋⠉⠑⠀⠀⢘⢻⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⣿⡿⠟⢹⣿⣿⡇⢀⣶⣶⠴⠶⠀⠀⢽⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⣿⣿⣿⡿⠀⠀⢸⣿⣿⠀⠀⠣⠀⠀⠀⠀⠀⡟⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⣿⣿⣿⡿⠟⠋⠀⠀⠀⠀⠹⣿⣧⣀⠀⠀⠀⠀⡀⣴⠁⢘⡙⢿⣿⣿⣿⣿⣿⣿⣿⣿\n"+
"⠉⠉⠁⠀⠀⠀⠀⠀⠀⠀⠀⠈⠙⢿⠗⠂⠄⠀⣴⡟⠀⠀⡃⠀⠉⠉⠟⡿⣿⣿⣿⣿\n"+
"⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢷⠾⠛⠂⢹⠀⠀⠀⢡⠀⠀⠀⠀⠀⠙⠛⠿⢿");
				sleep(longSleep);

				Level level=new Level();

				try {
					level.getThread().join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}


				level.nextState();
				try {
					level.getThread().join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				level.nextState();

			}
			else{
				ui.print("(the game starts only when you type heisenberg)");

			}
		}

		// getters and setters
	}
}