package com.trello.qa.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HelperBase {

    WebDriver wd;
    WebElement locator;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void type(By locator, String info) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(info);
    }

    public void type(By locator, Integer info) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(info.toString());
    }

    public void type(By locator, Character info) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(info.toString());
    }

    public void clickOnYallaBottom() {
        click(By.cssSelector("[type='submit']"));
    }

    public void clickOnSubmitBottom() {
        click(By.cssSelector("input[value='Submit']"));
    }


    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

}
