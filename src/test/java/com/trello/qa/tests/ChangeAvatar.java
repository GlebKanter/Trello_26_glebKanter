package com.trello.qa.tests;

import com.trello.qa.model.User;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class ChangeAvatar extends TestBase {
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
    public void testChangeAvatar() throws InterruptedException, IOException {
        app.user().clickOnTheAvatar();
        app.user().goToProfile();
        app.user().goToAtlassianAcc();
       // app.user().changeAvatar("C:\\Users\\GLEB\\Documents\\GitHub\\Trello_26_glebKanter\\src\\test\\java\\resources\\me.jpg");
        app.user().changeAvatar("C:\\Users\\GLEB\\Documents\\GitHub\\Trello_26_glebKanter\\src\\test\\java\\resources\\ava_cat.jpeg");
        app.user().pause(2000);
    }


}
