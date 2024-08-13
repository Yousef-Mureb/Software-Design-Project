import java.util.Random;

public class Fight  {

	// Tuco tuco;
	Walter walter;
	// Gustavo gustavo;
	Characters enemy;
	Characters ally;
	UI ui = UI.getInstance();
	ControlPanel cp = ControlPanel.getInstance();
	boolean block = false;
	boolean strong=false;
	int baseDamageWalter = 10;
	int baseDamageEnemy = 10;
	int baseDamageAlly = 10;
	boolean allyCharged = false, hitWalt = false, enemyCharged = false, allyBlock = false, enemyBlock = false;
	

	int choice = -1;
	Random rand = new Random();

	public Fight(Characters enemy, Characters ally) { // if ally is null, fightin gus, if not null, fighting tuco

		this.enemy = enemy;
		this.ally = ally;
		walter = Walter.getInstance();
		BlockCommand BC = new BlockCommand(this);// this will be index 8
		cp.add(BC);

		fightScene();
	}

	public void weakenEnemy() {
		baseDamageEnemy *= 0.9;
	}

	public void strengthenWalt() {
		baseDamageWalter *= 1.1;
	}

	
	

	public int MenuOption() {

		UI.print("Use one of the below options: ");

		choice = -1;
		String option;
		while (choice!=1 && choice!=2 && choice!=3) {

			UI.print("1. Attack");
			UI.print("2. Use cookie");
			UI.print("3. Block");

			option = ui.read();
			if (!Character.isLetter(option.charAt(0)))
				choice = Integer.parseInt(option);
			
			if(choice!=1 && choice!=2 && choice!=3)
				UI.print("(Choose one of the three options by typing 1, 2 or 3)");
		}
		return choice;
	}

	public void block() {
		block = true; // if block true, decrease damage then make block=false
	}


	public void fightScene() {
		// implement the whole fight
		// maybe include the print outs and what not
		// also include cookie type for ability
		// maybe on a thread?

		// walter has the hands
		// well need randome variables for enemies actions

		// some health factor for everyone in each of their classes
		// some dodge factor for each hit and damage scaling- enemy has charged up
		// attack



		UI.print("The fight begins now, Walter starts"+'\n');

		while (enemy.getHealth() > 0 && walter.getHealth() > 0) {

			int shortPunchWalter = rand.nextInt(6) + baseDamageWalter;// 10-15
			int longPunchWalter = rand.nextInt(6) + baseDamageWalter + 5;// 15-20

			int chargedAttackEnemy = rand.nextInt(15) + baseDamageEnemy + 8;
			int enemyAttack = rand.nextInt(6) + baseDamageEnemy;

			int chargedAttackAlly = rand.nextInt(15) + baseDamageAlly + 8;
			int allyAttack = rand.nextInt(6) + baseDamageAlly;

			choice = MenuOption();
			UI.print("");



			strong = rand.nextBoolean();
			
			if(walter.getHealth()>0){
				if (choice == 1) {//attack
					cp.buttonWasPressed(6, null);

					if (strong) {
						if (enemyBlock)
							longPunchWalter -= 5;

						enemy.reduceHealth(longPunchWalter);
						UI.print("Walter used strong punch!");
						
						UI.print("              __________                  __,___/  \",\",\r\n"
								+ "         ___.--\"          \"\\'.         ____/  l   \\    \",'-,\r\n"
								+ "  ------f\"               // \\\\\\        \\  (l\\ \\    \\     \\ \\\",\r\n"
								+ "        |                    |||       /   u       |      \\ \\ \\\r\n"
								+ "        |                    |||     _ )          /       | |  \\\r\n"
								+ "    ----L_-XXX-.             .|'    / U          <        | |  |\r\n"
								+ "                \"\\   -<_____///     \\           6 )       | |  |\r\n"
								+ "                  \\___)     -\"       '.       -.<\"       / /   |\r\n"
								+ "                                      |'.___  |       _._.\"   /\r\n"
								+ "                                      |     ./     _.\".\"   _.\"\r\n"
								+ "                                     /      |\"----\"     _.\"\r\n"
								+ "                                  jjs       \\\r\n"
								+ "");

						
						
						UI.print("damage taken by " + enemy.getName() + ": " + longPunchWalter + " Remaining health: "
								+ enemy.getHealth());
						if (longPunchWalter > 18)
							UI.print("It was super effective!");
						enemyBlock=false;

					} else if (!strong) {
						if (enemyBlock)
							shortPunchWalter -= 5;
						enemy.reduceHealth(shortPunchWalter);
						UI.print("Walter used weak punch!");
															UI.print(
							"       ,--.--._ \n"+
						    "------'' , '\'___)\n"+
							"  	  / _/____)\n"+
							"	'\'//(____)\n"+
							"------'\'     (__)\n"+
							"	`-----");
						UI.print("damage taken by " + enemy.getName() + ": " + shortPunchWalter + " Remaining health: "
								+ enemy.getHealth());
						if (shortPunchWalter > 18)
							UI.print("It was super effective!");
						enemyBlock=false;
					}
				} else if (choice == 2) { //eat cookie

					cp.buttonWasPressed(7, null); // this heals if normal

					if (walter.getCookie().contains("spicy")) {
						strengthenWalt();
						UI.print("damage increased after eating cookie");
					}

					else if (walter.getCookie().contains("sleepy")) {
						weakenEnemy();
						UI.print("damage taken by Walter is reduced :)");

					}
					
					else if(walter.getCookie().contains("normal")){
						UI.print("Walter has healed, current health: " + walter.getHealth());
					}
					
					enemyBlock=false;

				} else if (choice == 3) {
					cp.buttonWasPressed(8, null);
					enemyBlock=false;
					UI.print(walter.getName()+" is blocking");

				}

				try {
					Thread.sleep(1*1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}



			// enemy attacks back

			Random OppRand = new Random();
			int OppChoice = OppRand.nextInt(3);
			UI.print("");

		
			if(enemy.getHealth()>0) {
				if (OppChoice == 0 && !enemyCharged) {
					if (allyBlock)
						enemyAttack -= 5;
					if (!hitWalt && ally != null) {
						System.out.println(enemy.getName() + " used attack! ");
						ally.reduceHealth(enemyAttack);
						UI.print("damage taken by " + ally.getName() + ": " + enemyAttack + " Remaining health: "
								+ ally.getHealth());
						allyBlock=false;
					} else {
						if (block) {
							enemyAttack -= 5;
						}
						System.out.println(enemy.getName() + " used attack! ");
						walter.reduceHealth(enemyAttack);
						UI.print("damage taken by " + walter.getName() + ": " + enemyAttack + " Remaining health: "
								+ walter.getHealth());
						block=false;

					}
					if (enemyAttack > 18)
						UI.print("It was super effective!");

				} else if (OppChoice == 1 && !enemyCharged) {

					System.out.println(enemy.getName() + " is charging up a powerful attack! ");
					enemyCharged = true;
					block=false;
					allyBlock=false;

				} else if (OppChoice == 2 && !enemyCharged) {
					UI.print(enemy.getName()+" is now blocking");
					enemyBlock = true;
					block=false;
					allyBlock=false;
				} else if (enemyCharged) {

					if (!hitWalt && ally != null) {
						if (allyBlock)
							chargedAttackEnemy -= 5;
						System.out.println(enemy.getName() + " used a special attack! ");
						ally.reduceHealth(chargedAttackEnemy);
						UI.print("damage taken by " + ally.getName() + ": " + enemyAttack + " Remaining health: "
								+ ally.getHealth());
						allyBlock=false;
					} else {
						if (block) {
							chargedAttackEnemy -= 5;
						}

						System.out.println(enemy.getName() + " used a special attack! ");
						walter.reduceHealth(chargedAttackEnemy);
						UI.print("damage taken by " + walter.getName() + ": " + enemyAttack + " Remaining health: "
								+ walter.getHealth());
						block=false;

					}
					enemyCharged = false;
					if (chargedAttackEnemy > 18)
						UI.print("It was super effective!");
				}
			}

			// ally choices

			try {
				Thread.sleep(1*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


			if (ally == null) {
				//ntn cuz he dont exist lol
			} else {

				if(ally.getHealth()>0){
					UI.print("");
					OppChoice = OppRand.nextInt(3); // using same variable cuz lazy
					if (OppChoice == 0 && !allyCharged) {

						if(enemyBlock)
							allyAttack-=5;
						System.out.println(ally.getName() + " used an attack! ");
						enemy.reduceHealth(allyAttack);
						UI.print("damage taken by " + enemy.getName() + ": " + enemyAttack + " Remaining health: "
								+ enemy.getHealth());
						enemyBlock=false;

					}
					if (allyAttack > 18)
						UI.print("It was super effective!");

					if (OppChoice == 1 && !allyCharged) {

						System.out.println(ally.getName() + " is charging up a powerful attack! ");
						allyCharged = true;
						enemyBlock=false;

					} else if (OppChoice == 2 && !allyCharged) {

						allyBlock=true;
						UI.print(ally.getName()+ " is blocking");
						enemyBlock=false;

					} else if (allyCharged) {


						if (!hitWalt && ally != null) {
							if(enemyBlock)
								chargedAttackAlly-=5;
							System.out.println(ally.getName() + " used a special attack! ");
							enemy.reduceHealth(chargedAttackAlly);
							UI.print("damage taken by " + enemy.getName() + ": " + allyAttack + " Remaining health: "
									+ enemy.getHealth());
						}

						enemyBlock=false;
						allyCharged = false;
						if (chargedAttackAlly> 18)
							UI.print("It was super effective!");
					}

					try {
						Thread.sleep(1*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}
}
