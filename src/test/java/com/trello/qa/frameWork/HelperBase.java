package com.trello.qa.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HelperBase {

    WebDriver wd;
    WebElement locator;

    public HelperBase(WebDriver wd) {
        this.wd = wd;
    }

    public HelperBase() {
        WebDriver wd;

    }

    public void backToHome() {
        click(By.xpath("//a[@aria-label='Back to Home']"));//go to home
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void clickMenuButton() {
        click(By.xpath("//span[normalize-space()='Show Menu']"));//menu
    }


    public void clickOnSubmitBottom() {
        click(By.cssSelector("input[value='Submit']"));
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) wd;
        js.executeScript("window.scrollBy(0,300)");
    }

    public void type(By locator, String text) {
        if (text != null) {
            wd.findElement(locator).click();
            wd.findElement(locator).clear();
            wd.findElement(locator).sendKeys(text);
        }
    }

    public void waitUntilPresent() {
        new WebDriverWait(wd, 10)
                .until(ExpectedConditions
                        .presenceOfElementLocated(By
                                .xpath("//div[@class='sc-cLQEGU dyjNby']")));
    }

    public void attachPhoto(By locator, File file) throws IOException {
        if (file != null) {
            wd.findElement(locator).sendKeys(file.getAbsolutePath());
        }
    }

    public void switchToWindowHandle(int index) throws NullPointerException {

        List<String> tabs = new ArrayList<>(wd.getWindowHandles());
        if (tabs != null && tabs.size() > index && index >= 0)
            wd.switchTo().window(tabs.get(index));
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
