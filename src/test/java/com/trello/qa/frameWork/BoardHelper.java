package com.trello.qa.frameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

import static com.sun.javaws.jnl.XMLUtils.getAttribute;

public class BoardHelper extends HelperBase {
    public BoardHelper(WebDriver wd) {
        super(wd);
    }

    public int countBoards() {
        return wd.findElements(By.xpath("//ul[@class='boards-page-board-section-list']// li")).size();
    }

    public void clickBoard(String test) {
        String str = String.format("//div[contains(@title,'%s')][@class='board-tile-details-name']", test);
        System.out.println("xpath: (" + str + ")");

        if (isElementPresent(By.xpath(str))) {
            click(By.xpath(str));
        }
    }

    public void clickMore() {
        click(By.xpath("//a[@class='board-menu-navigation-item-link js-open-more']")); //more
    }

    public void clickClose() {
        click(By.xpath("//a[contains(text(),'Close Board…')]"));//close
    }

    public void clickConfirmClose() {
        click(By.xpath("//input[@value='Close']"));//confirm close
    }

    public void clickDelConfirm1() {
        click(By.xpath("//a[contains(text(),'Permanently Delete Board…')]"));//delConfirm1
    }

    public void clickDelConfirm2() {
        click(By.xpath("//input[@value='Delete']"));//delConfirm2
    }


    public void dellBoard(String name) {
        clickBoard(name);
        clickMore();
        clickClose();
        clickConfirmClose();
        clickDelConfirm1();
        clickDelConfirm2();
        backToHome();
        System.out.println("delBoard done");

    }

    public boolean isBoardPresent() {

       return isElementPresent(By.xpath("//ul[@class='boards-page-board-section-list'][contains(.,str)]"));
    }
}
