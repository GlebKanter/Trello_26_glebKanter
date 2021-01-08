package com.trello.qa.tests;


import com.trello.qa.frameWork.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() {
        app.start();
    }

    @AfterClass(enabled = false)
    public void tearDown() {
        app.stop();

    }

}
