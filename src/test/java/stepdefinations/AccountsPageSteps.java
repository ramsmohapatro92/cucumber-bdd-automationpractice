package stepdefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.pages.Accountspage;
import com.pages.Loginpage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;

public class AccountsPageSteps {

	private Loginpage loginpage = new Loginpage(DriverFactory.getDriver());
	private Accountspage accountpage;

	@Given("User has already logged into application")
	public void user_has_already_logged_into_application(DataTable dataTable) {

		List<Map<String, String>> credentiallist = dataTable.asMaps();
		String userName = credentiallist.get(0).get("username");
		String passWord = credentiallist.get(0).get("password");

		DriverFactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");

		accountpage = loginpage.doLogin(userName, passWord);
	}

	@Given("User is on Accounts page")
	public void user_is_on_accounts_page() {
		String title = accountpage.accountsPageTitle();
		System.out.println("Account page title is: " + title);
	}

	@Then("User gets account section")
	public void user_gets_account_section(DataTable sectionsTable) {

		List<String> expectedAccountSectionlist = sectionsTable.asList();
		System.out.println("Expected account section list : " + expectedAccountSectionlist);

		List<String> actualAccountSectionList = accountpage.getAccountSectionsList();
		System.out.println("Actual account section list : " + actualAccountSectionList);

		Assert.assertTrue(expectedAccountSectionlist.contains(actualAccountSectionList));
	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedsectioncount) {

		Assert.assertTrue(accountpage.getAccountSectionCount() == expectedsectioncount);
	}

}
