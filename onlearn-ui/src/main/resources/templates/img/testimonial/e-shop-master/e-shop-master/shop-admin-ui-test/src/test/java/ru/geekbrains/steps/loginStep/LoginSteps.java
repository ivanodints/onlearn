package ru.geekbrains.steps.loginStep;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.geekbrains.DriverInitializer;

import static org.assertj.core.api.Assertions.assertThat;

public class LoginSteps {

    private WebDriver webDriver = null;

    @Given("^I open web browser$")
    public void iOpenFirefoxBrowser() throws Throwable {
        webDriver = DriverInitializer.getDriver();
        Thread.sleep(1000);
    }

    @When("^I navigate to login page$")
    public void iNavigateToLoginHtmlPage() throws Throwable {
        webDriver.get(DriverInitializer.getProperty("admin.url"));
        Thread.sleep(1000);
    }

    @When("^I provide username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
    public void iProvideUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("username_pole"));
        webElement.sendKeys(username);
        Thread.sleep(1000);
        webElement = webDriver.findElement(By.id("password_pole"));
        webElement.sendKeys(password);
        Thread.sleep(1000);
    }

    @When("^I click on login button$")
    public void iClickOnLoginButton() throws Throwable {
        WebElement webElement = webDriver.findElement(By.id("button-login"));
        webElement.click();
        Thread.sleep(1000);
    }

    @Then("^name should be \"([^\"]*)\"$")
    public void nameShouldBe(String name) throws Throwable {
        Thread.sleep(1000);
        WebElement webElement = webDriver.findElement(By.id("dd_user"));
        assertThat(webElement.getText()).isEqualTo(name);
    }

    @Given("^any user logged in$")
    public void userLoggedIn() {
        webDriver.findElement(By.id("logged-in-username"));
    }

    @When("^Open dropdown menu$")
    public void openDropDownMenu() throws InterruptedException {
        WebElement webElement = webDriver.findElement(By.id("logged-in-username"));
        Thread.sleep(1000);
        webElement.click();
        Thread.sleep(1000);
    }

    @When("^click logout button$")
    public void clickLogoutButton() {
        WebElement webElement = webDriver.findElement(By.id("link-logout"));
        webElement.click();
    }

    @Then("^user logged out$")
    public void userLoggedOut() {
        webDriver.findElement(By.id("username_pole"));
        webDriver.findElement(By.id("password_pole"));
    }

    @After
    public void quitBrowser() {
        webDriver.quit();
    }
}
