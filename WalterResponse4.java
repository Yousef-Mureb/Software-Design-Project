
public class WalterResponse4 implements Command {

	
	Walter walt;
	
	
	WalterResponse4()
	{
		walt= Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub

		walt.response4();
	}

}
