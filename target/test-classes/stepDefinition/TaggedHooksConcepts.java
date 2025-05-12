package stepDefinition;

import io.cucumber.java.en.*;

public class TaggedHooksConcepts {
	
	@Given("this is first step")
	public void this_is_first_step() {
	  System.out.println("this is first step");
	}

	@When("this is second step")
	public void this_is_second_step() {
		 System.out.println("this is second step");
	}

	@Then("this is third step")
	public void this_is_third_step() {
		 System.out.println("this is third step");
	}


}
