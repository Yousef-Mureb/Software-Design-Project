
public  class Cookie implements Object {
	
	String name="cookie";
	CookieBehaviour CB;
	UI ui;
	
	public Cookie(){
		ui=UI.getInstance();
		
		
		
	}
	
	public void description(){
		ui.print("A completely ordinary-looking cookie, a masterpiece of the renowned Walter Hartwell White...");
	}
	
	public void setType(String type){
		if(type.toLowerCase().contains("spicy"))
		CB=new SpicyBehaviour();
		else if(type.toLowerCase().contains("normal"))
		CB= new NormalBehaviour();
		else if(type.toLowerCase().contains("sleepy"))
		CB=new SleepyBehaviour();
	}
	
	public String getType(){
		return CB.getName();
	}
	
	public void use(){
		try {
			CB.eat();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void eat(){
		UI.print("Walter used a " + CB.getName() + " cookie");	
	}

	@Override
	public void function() {
		// TODO Auto-generated method stub
		
	}


}
