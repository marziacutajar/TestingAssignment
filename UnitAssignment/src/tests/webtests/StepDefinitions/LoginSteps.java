package tests.webtests.StepDefinitions;

import tests.webtests.PageObjects.*;
import tests.webtests.*;
import cucumber.api.java.en.*;

public class LoginSteps 
{
	Login login;

    public LoginSteps()
    {
        login = new Login(Driver.getDriver());
    }

    @Given("^I am a user trying to log in$")
    public void GivenIAmAUserTryingToLogIn()
    {
        login.GoToLoginPage();
    }

    @Given("^I am a logged in user$")
    public void GivenIAmALoggedInUser()
    {
        if (!login.CheckLoggedIn())
        {
            login.GoToLoginPage();
            login.LoginToChatValid();
        }
    }

    @When("^I login using valid credentials$")
    public void WhenILoginUsingValidCredentials()
    {
        login.LoginToChatValid();
    }

    @When("^I login using invalid credentials$")
    public void WhenILoginUsingInvalidCredentials()
    {
        login.LoginToChatInvalid();
    }

    @When("^I send click on ?Log out?$")
    public void WhenISendClickOnLogOut()
    {
        login.LogOut();
    }

    @Then("^I should be logged out$")
    public void ThenIShouldBeLoggedOut()
    {
        login.CheckLoggedOut();
    }

    @Then("^I should see an error message$")
    public void ThenIShouldSeeAnErrorMessage()
    {
        login.CheckErrorMessage();
    }

    @Then("^I should remain on the login page$")
    public void ThenIShouldRemainOnTheLoginPage()
    {
        login.CheckThatOnLoginPage();
    }
}
