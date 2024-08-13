
public class AttackCommand implements Command {

	
	
	Walter walt;
	
	
	
	public AttackCommand()
	{
		
		walt = Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub
		
		
		walt.attack();
		
	}

}
