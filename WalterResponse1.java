
public class WalterResponse1 implements Command {

	
	Walter walt;
	
	
	public WalterResponse1()
	{
		walt= Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub

		walt.response1(cookie);
	}

}
