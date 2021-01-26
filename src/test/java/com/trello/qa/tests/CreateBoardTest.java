package com.trello.qa.tests;


import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateBoardTest extends TestBase {
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

    @Test
    public void testCreateBoard() throws InterruptedException {


        app.user().click(By.cssSelector("span[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1hS8KBZ_zkPTrz _1iYprMLTeGpyW9'] span[aria-label='AddIcon']"));
        app.user().pause(4000);
        app.user().click(By.xpath("//span[normalize-space()='Create board']"));
        app.user().pause(4000);
        app.user().type(By.xpath("//input[@placeholder='Add board title']"), "Test");
        app.user().pause(4000);
        app.user().click(By.xpath("//button[normalize-space()='Team Visible']"));
        app.user().pause(4000);
        app.user().click(By.xpath("//span[contains(., 'Private')]"));
        app.user().pause(4000);
        app.user().click(By.xpath("//button[normalize-space()='Create Board']"));
        app.user().pause(4000);
    }
}
