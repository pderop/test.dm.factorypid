package test;

public class NOPCommandRegistry implements CommandRegistry {

	@Override
	public void run() {
		System.out.println("NOPCommandRegistry.run");		
	}

}
