package stepDefinition;

import io.cucumber.java.en.*;

public class OrderConcepts {
	
	@Given("Thanos has more fingers")
	public void thanos_has_more_fingers() {
		System.out.println("Thanos has more fingers");
	   
	}

	@When("he snaps his fingers")
	public void he_snaps_his_fingers() {
		System.out.println("he snaps his fingers");
	   
	}

	@Then("half of the people will died")
	public void half_of_the_people_will_died() {
		System.out.println("half of the people will died");
	  
	}




}
