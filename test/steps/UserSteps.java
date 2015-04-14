package steps;

import models.User;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static org.assertj.core.api.Assertions.assertThat;


public class UserSteps {
	@Given("^there are no users$")
	public void there_are_no_users() throws Throwable {
	    User.deleteAll();
	}

	@When("^I create a user \"(.*?)\" with password \"(.*?)\"$")
	public void i_create_a_user_with_password(String email, String password) throws Throwable {
	    User.create(new User(email,password));
	}

	@Then("^The number of users is (\\d+)$")
	public void the_number_of_users_is(int n) throws Throwable {
	    assertThat(User.all().size()).isEqualTo(n);
	}

	@Given("^a list of users:$")
	public void a_list_of_users(DataTable arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    throw new PendingException();
	}

	@When("^I login with name \"(.*?)\" and password \"(.*?)\"$")
	public void i_login_with_name_and_password(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I receive a welcome message$")
	public void i_receive_a_welcome_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I receive a failure message$")
	public void i_receive_a_failure_message() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^I cannot login$")
	public void i_cannot_login() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
