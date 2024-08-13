
public class BlockCommand implements Command {

	Fight fight;



	BlockCommand(Fight fight)
	{

		this.fight = fight;
	}
	@Override
	public void execute(Cookie cookie) {
		// TODO Auto-generated method stu

		fight.block();

	}
}
