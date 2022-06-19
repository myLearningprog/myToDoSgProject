#Author: mageshkumar07@hotmail.com

Feature: Manage Todo List
@sanity
Scenario Outline: Check MVC User is able to add Todo task
Given User loads the todomvc portal URL "https://todomvc.com/examples/vue/"
When User entered the todomvc task name "<ToDoTaskName>"
Then todomvc task successfully added in the list

    Examples: 
      |ToDoTaskName|
      |getNewCustomerData|