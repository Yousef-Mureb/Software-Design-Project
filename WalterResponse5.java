
public class WalterResponse5 implements Command {

	
	Walter walt;
	
	
	public WalterResponse5()
	{
		walt= Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub

		walt.response5();
	}

}
