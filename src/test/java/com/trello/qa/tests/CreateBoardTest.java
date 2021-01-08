package com.trello.qa.tests;


import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateBoardTest extends TestBase {
    @Test
    public void testCreateBoard() throws InterruptedException {
        app.user().initLogin();
        app.user().fillLoginForm(new User().setEmail("gleb.kanter@gmail.com").setPassword("Tglebson13"));
        app.user().confirmLogin();

        Assert.assertTrue(app.user().isAvatarPresent());

        app.user().click(By.cssSelector("span[class='nch-icon _2_Q6rrYCFblD3M _3Dk1GPoKnJxuep _1hS8KBZ_zkPTrz _1iYprMLTeGpyW9'] span[aria-label='AddIcon']"));
        app.user().pause(4000);
        app.user().click(By.xpath("//span[normalize-space()='Create board']"));
        app.user().pause(4000);
        app.user().type(By.xpath("//input[@placeholder='Add board title']"), "Test");
        app.user().pause(4000);
        app.user().click(By.xpath("//button[normalize-space()='Team Visible']"));
        app.user().pause(4000);
        app.user().click(By.xpath("//span[@name='private']"));
        app.user().pause(4000);
        app.user().click(By.cssSelector("button[class='uj9Ovoj4USRUQz voB8NatlbuEme5 _21upOlzpUQJcdT']"));
        app.user().pause(4000);
    }
}
