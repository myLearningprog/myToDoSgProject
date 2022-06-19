package com.eComm.StepDefinitions;

import com.eComm.PageFunctions.TodoListPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

public class ToDoListSteps extends TodoListPage {

	@Given("^User loads the todomvc portal URL \"([^\"]*)\"$")
	public void user_loads_the_todomvc_portal_URL(String arg1) throws Throwable {
      launchURL();
      
      
     
	}

	@When("^User entered the todomvc task name \"([^\"]*)\"$")
	public void user_entered_the_todomvc_task_name(String arg1) throws Throwable {

	}
}
