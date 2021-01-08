package com.trello.qa.frameWork;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class UserHelper extends HelperBase {

    public UserHelper(WebDriver wd) {
        super(wd);
    }

    public void initLogin() {
        click(By.cssSelector("[href='/login']"));
    }

    public void fillLoginForm(User user) throws InterruptedException {
        type(By.id("user"), user.getEmail());
        pause(2000);
        click(By.id("login"));
        Thread.sleep(3000);
        type(By.id("password"), user.getPassword());

    }

    public void confirmLogin() {
        click(By.id("login-submit"));
    }

    public boolean isAvatarPresent() throws InterruptedException {
        pause(3000);
        return isElementPresent(By.cssSelector("[aria-label='Open Member Menu']"));
    }
}