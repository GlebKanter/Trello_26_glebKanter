package com.trello.qa.tests;


import com.trello.qa.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

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

    @Test(invocationCount = 1)
    public void testCreateBoard() throws InterruptedException {

        if (app.board().countBoards() < 10) {
            app.user().click(By.xpath("//button[@data-test-id='header-create-menu-button']"));
            app.user().pause(4000);
            app.user().click(By.xpath("//span[normalize-space()='Create board']"));
            app.user().pause(4000);
            app.user().type(By.xpath("//input[@placeholder='Add board title']"), "Test" + (System.currentTimeMillis() / 1000 % 3600));
            app.user().pause(4000);
            app.user().click(By.xpath("//button[normalize-space()='Team Visible']"));
            app.user().pause(4000);
            app.user().click(By.xpath("//span[contains(., 'Private')]"));
            app.user().pause(4000);
            app.user().click(By.xpath("//button[normalize-space()='Create Board']"));
            app.user().pause(4000);
            app.board().backToHome();
        } else {
            System.out.println("impossible create board, you have maximum");
        }
    }

    @Test

    public void delBoardTest() {
        String str = "Test";
        if (!app.board().isBoardPresent()) {
            System.out.println("haven't board with marker " + str);
        } else {
            app.board().dellBoard(str);
        }
    }


    @Test//(enabled = false)
    public void delAllBoardsWithMarker() throws InterruptedException {
        String marker = "Test";
        String str = "//ul[@class='boards-page-board-section-list']//div[contains(.,'Test')]";

        // String str = String.format("//div[contains(@title,'%s')][@class='board-tile-details-name']", marker);

        while (app.board().countBoards() > 1) {
            if (!app.board().isElementPresent(By.xpath(str))) {
                System.out.println("haven't board with marker " + marker);
            } else if (app.board().countBoards() > 2) {
                app.board().dellBoard(marker);
            }
        }
        System.out.println("delAllBoard with marker " + marker + " done.");
    }
}
//
//         (app.board().isElementPresent(By.xpath(str)) && app.board().countBoards() > 2) {
//            if (app.board().isElementPresent(By.xpath(str))) {
//                System.out.println("find board to dell: " + str);
//            }
//            if (app.board().countBoards() > 2) {
//                app.board().countBoards();
//                System.out.println(app.board().countBoards());
//            }
//
//            count = count + 1;
//            delBoardTest(str);
//            app.pause(2000);
//
//        }
//
//        System.out.println("delAllBoard with marker " + marker + " done. Delete " + count + " boards");
//        System.out.println("have left " + (app.board().countBoards() - 1) + " boards");
//
//    }
//}
