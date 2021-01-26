package com.trello.qa.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;
import java.io.IOException;

public class HelperBase {

    WebDriver wd;
    WebElement locator;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public HelperBase() {
        WebDriver wd;

    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickOnYallaBottom() {
        click(By.cssSelector("[type='submit']"));
    }

    public void clickOnSubmitBottom() {
        click(By.cssSelector("input[value='Submit']"));
    }

    public void type(By locator, String text) {
        if (text != null) {
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }


    public void attachPhoto(By locator, File file) throws IOException {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }


    public void pause(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }


    public boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public String getPageUrl() {
        return wd.getCurrentUrl();
    }
}
