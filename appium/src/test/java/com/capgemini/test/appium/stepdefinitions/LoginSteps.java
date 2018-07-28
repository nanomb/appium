package com.capgemini.test.appium.stepdefinitions;

import org.junit.Assert;

import com.capgemini.test.appium.User;
import com.capgemini.test.appium.setup.Appium;
import com.capgemini.test.appium.setup.Login;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginSteps {

private User user;

@Given("^we are a user$")
public void we_are_a_user() throws Throwable {
    // Write code here that turns the phrase above into concrete actions
	user = new User();
	user.setLogin("company");
	user.setPassword("company");
}

@Given("^we enter to application$")
public void we_enter_to_application() throws Throwable {
    Appium appium = new Appium();
    appium.init();
}

@When("^we make login with user and password$")
public void we_make_login_with_user_and_password() throws Throwable {
    Login login = new Login();
    login.doLogin(user);
}

@Then("^the login is successfull$")
public void the_login_is_successfull() throws Throwable {
	Login login = new Login();
    Assert.assertTrue(login.isUserLoggedIn());
    login.logout();
}


@After
public void close() {
    Appium appium = new Appium();
    appium.tearDown();
}
}
