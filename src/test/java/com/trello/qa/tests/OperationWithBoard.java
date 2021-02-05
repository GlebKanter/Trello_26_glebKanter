package com.trello.qa.tests;


import com.google.common.io.Files;
import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class OperationWithBoard extends TestBase {
    WebDriver wd;

    @BeforeMethod
    public void preconditions() throws InterruptedException {
        if (!app.user().isAvatarPresent()) {
            app.user().initLogin();
            app.user().fillLoginForm(new User()
                    .setEmail(app.setEmail())
                    .setPassword(app.setPassword()));
            app.user().confirmLogin();
        }
    }

    @Test(priority = 1, invocationCount = 3)
    public void testCreateBoard() throws InterruptedException {

        if (app.board().countBoards() < 9) {
            app.user().click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
            // app.user().pause(4000);
            app.user().click(By.xpath("//span[normalize-space()='Create board']"));
            //app.board().clickCreate();
            // app.user().pause(4000);
            app.user().type(By.xpath("//input[@placeholder='Add board title']"), "Test" + (System.currentTimeMillis() / 1000 % 3600));
            // app.user().pause(4000);
            app.user().click(By.xpath("//button[normalize-space()='Team Visible']"));
            // app.user().pause(4000);
            app.user().click(By.xpath("//span[contains(., 'Private')]"));
            //app.user().pause(4000);
            app.user().click(By.xpath("//button[normalize-space()='Create Board']"));
            app.user().pause(4000);
            app.board().backToHome();
        } else {
            System.out.println("impossible create board, you have maximum");
        }

    }

    @Test(priority = 2)

    public void delBoardTest() {
        String str = "Test";
        if (!app.board().isBoardPresent()) {
            System.out.println("haven't board with marker " + str);
        } else {
            try {
                app.board().dellBoard(str);
            } catch (NoSuchElementException e) {
                e.printStackTrace();
            }
        }
    }


    @Test(priority = 3) //(enabled = false)
    public void delAllBoardsWithMarker() throws InterruptedException {
        String marker = "Test";
        String str = "//ul[@class='boards-page-board-section-list']//div[contains(.,'Test')]";


        while (app.board().countBoards() > 2) {
            if (!app.board().isElementPresent(By.xpath(str))) {
                System.out.println("haven't board with marker " + marker);
                Assert.assertTrue(!app.board().isElementPresent(By.xpath(str)));
                app.board().backToHome();
            } else {
//                app.board().dellBoard(marker);
                try {
                    app.board().dellBoard(marker);
                } catch (NoSuchElementException e) {
                    e.getSystemInformation();
                }
                // wd.manage().timeouts().pageLoadTimeout (15, TimeUnit.SECONDS);

                app.board().pause(200);

            }

            System.out.println("delAllBoard with marker " + marker + " done.");
        }
    }
}

