package com.trello.qa.tests;


import com.trello.qa.frameWork.ApplicationManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.IOException;

public class TestBase {

    protected ApplicationManager app = new ApplicationManager();

    @BeforeClass
    public void setUp() throws IOException {
        app.start();
    }

    @AfterClass(enabled = true)
    public void tearDown() {
        app.stop();

    }

}
