import java.util.ArrayList;

public class Main{
	
	
	public static void main(String[] args) {
	
		
		
		
		
		
		UI.print("⢰⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⣶⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⢸⣿⠛⠛⠛⠻⣿⣿⣿⣿⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⢸⣿⠀⣿⣿⠆⢸⣿⠿⢿⠿⢿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⢸⣿⠀⣤⣄⡀⢻⣿⠀⢈⣴⣾⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⢸⣿⠀⠿⠿⠃⢸⣿⠀⢸⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⢸⣿⣶⣶⣶⣾⣿⣿⣶⣾⣿⣿⣿⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀\r\n"
				+ "⠘⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⠛⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤⣤\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡿⠿⠿⠿⣿⣿⣿⣿⣿⣿⣿⡇\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⢰⣶⣦⠈⣿⣿⣿⣿⣿⣿⡇\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⢈⣉⡁⠰⣿⣟⣡⣤⡈⣿⡇\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⡇⢸⣿⠿⠀⣸⡏⢡⣶⠀⣿⡇\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣿⣧⣤⣤⣤⣶⣿⣷⣤⣴⣧⣿⡇\r\n"
				+ "⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠿⠇2");
			

		
		
		TCPClient2 tcp= new TCPClient2();
		Walter walter = Walter.getInstance(tcp);
		Command response1 = new WalterResponse1();
		Command response2= new WalterResponse2();
		Command response3 = new WalterResponse3();
		Command response4 = new WalterResponse4();
		Command response5 = new WalterResponse5();
		Command response6 = new WalterResponse6();
		Command response7 = new AttackCommand();
		Command response8 = new UseCookieCommand();
		
		
		ArrayList<Command> cmd= new ArrayList<Command>();
		cmd.add(response1);
		cmd.add(response2);
		cmd.add(response3);
		cmd.add(response4);
		cmd.add(response5);
		cmd.add(response6);
		cmd.add(response7);
		cmd.add(response8);
		ControlPanel controlPanel = ControlPanel.getInstance(cmd);
	
		Story mystory=new Story(tcp);
		
		
		
	
}
}
