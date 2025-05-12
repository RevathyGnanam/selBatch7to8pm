package hooks;

import io.cucumber.java.*;

public class TaggedHooks {
	
	@Before("@First")
	public void beforeFirst() {
		System.out.println("This will run before the first scenario");
		
	}
	
	@Before("@Second")
	public void beforeSecond() {
		System.out.println("This will run before the second scenario");
		
	}
	@Before("@Third")
	public void beforeThird() {
		System.out.println("This will run before the third scenario");
		
	}
	
	@After("@First")
	public void afterFirst() {
		System.out.println("This will run after the first scenario");
		
	}
	@After("@Second")
	public void afterSecond() {
		System.out.println("This will run after the second scenario");
		
	}
	@After("@Third")
	public void afterThird() {
		System.out.println("This will run after the third scenario");
		
	}

}
