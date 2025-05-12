package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class HooksConcepts {
	
	@Before(order=1)
	public void beforeScenario() {
		System.out.println("Thanos collects the infinity stones");
	}
	@After(order=1)
	public void afterScenario() {
		System.out.println("After killing everyone it is taking rest in garden");
	}
	
	@Before(order=0)
	public void beforetoBeforeScenario() {
		System.out.println("Thanos has to be born");
	}
	@After(order=0)
	public void aftertoAfterScenario() {
		System.out.println("Finally he is no more");
	}

}
