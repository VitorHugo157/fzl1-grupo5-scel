package br.edu.fateczl.fzl1grupo5scel.po;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPageObject {

    private WebDriver driver;
    private By usernameBy = By.name("username");
    private By passwordBy = By.name("password");
    private By btnLoginBy = By.cssSelector("button");

    public LoginPageObject(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPageObject login(String username, String password) {
        driver.findElement(usernameBy).click();
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).click();
        driver.findElement(passwordBy).sendKeys(password);
        driver.findElement(btnLoginBy).click();
        return new LoginPageObject(driver);
    }
}
