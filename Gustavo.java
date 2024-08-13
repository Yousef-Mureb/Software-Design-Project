
public class Gustavo implements Characters {

	
	String name="Gustavo Fring";
	
	int health = 100;
	double dodgeChance=0.2;
	
	public String getName(){
		return name;
	}
	public int getHealth(){
		return health;
	}
	
	@Override
	public int reduceHealth(int dmg) {
		if(dmg>health)
			health=0;
			else
			health-=dmg;
			return health;
	}
}
