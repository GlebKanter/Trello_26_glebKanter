package com.trello.qa.frameWork;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


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
        return isElementPresent(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void clickOnTheAvatar() {
        click(By.cssSelector("[data-test-id='header-member-menu-button']"));
    }

    public void goToProfile() {
        click(By.cssSelector("[data-test-id='header-member-menu-profile']"));
    }

    public void goToAtlassianAcc() {
        click(By.cssSelector("[href$=manage-profile]"));
        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        wd.switchTo().window(tabs.get(1));


    }

    public void changeAvatar(String path) throws InterruptedException, IOException {
        Actions actions = new Actions(wd);
        Actions actions1 = actions.moveToElement(wd
                .findElement(By.xpath("//div[@class='sc-cLQEGU dyjNby']")));
        pause(2000);
        actions1.click().perform();
        //click(By.xpath("//span[@class='sc-chPdSV cbaecT']"));
        click(By.xpath("//span[contains(text(),'Change profile photo')]"));
        attachPhoto(By.cssSelector("[id='image-input'"), new File(path));
        pause(200);
        click(By.xpath(" //span[contains(text(),'Upload')]"));
    }
}