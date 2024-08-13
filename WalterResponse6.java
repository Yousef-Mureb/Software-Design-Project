
public class WalterResponse6 implements Command {

	
	Walter walt;
	
	
	public WalterResponse6()
	{
		walt= Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub

		walt.response6();
	}

}
