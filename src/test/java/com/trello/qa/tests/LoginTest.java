package com.trello.qa.tests;

import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
    @Test
    public void testAtlasianUserLogin() throws InterruptedException {
        app.user().initLogin();
        app.user().fillLoginForm(new User().setEmail("gleb.kanter@gmail.com").setPassword("Tglebson13"));
        app.user().confirmLogin();

        Assert.assertTrue(app.user().isAvatarPresent());
    }


}
