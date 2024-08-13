
public class WalterResponse2 implements Command {

	
	
	
	
	Walter walt;

	
	public WalterResponse2()
	{
		walt= Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub
		walt.response2(cookie);
	}

}
