package stepdefinations;

import org.junit.Assert;

import com.pages.Loginpage;
import com.qa.factory.DriverFactory;
import com.qa.util.ConfigReader;

import appHooks.ApplicationHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPagesteps {

	private Loginpage loginpage = new Loginpage(DriverFactory.getDriver());
	private static String title;

	@Given("User is on login page")
	public void user_is_on_login_page() {
		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	@When("User gets the title of the page")
	public void user_gets_the_title_of_the_page() {

		title = loginpage.getLoginPageTitle();
		System.out.println("loogin page title > " + title);
	}

	@Then("The page title should be {string}")
	public void the_page_title_should_be(String expectedTitle) {
		title = loginpage.getLoginPageTitle();
		Assert.assertTrue(title.contains(expectedTitle));
	}

	@Given("User is in login page")
	public void user_is_in_login_page() {
	}

	@Then("Forget your password link should be displayed")
	public void forget_your_password_link_should_be_displayed() {

		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());
	}

	@Then("User is able to click it")
	public void user_is_able_to_click_it() {
		loginpage.isForgotPasswordLinkClickable();
	}

	@When("User enters username {string}")
	public void user_enters_username(String username) {

		loginpage.enterUserName(username);
	}
 
	@When("User enters password {string}")
	public void user_enters_password(String pwd) {

		loginpage.enterPassword(pwd);
	}

	@When("User clicks on login button")
	public void user_clicks_on_login_button() {

		loginpage.clickSignIn();
	}
}
