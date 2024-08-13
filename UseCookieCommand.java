
public class UseCookieCommand implements Command {



	Walter walt;



	public UseCookieCommand()
	{

		walt = Walter.getInstance();
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stub
		walt.eatCookie();
		if(walt.getCookie().contains("normal")){
			walt.heal(15);
		}
		
		

	}
}
