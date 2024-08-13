
public class WalterResponse3 implements Command {

	
	
	Walter walt;
	
	
	public WalterResponse3()
	{
		walt= Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub
		walt.response3(cookie);
	}

}
