package com.trello.qa.frameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager extends HelperBase {
    Properties properties;
    BoardHelper boardHelper;
    UserHelper userHelper;
    WebDriver wd;

    public BoardHelper board() {
        return boardHelper;
    }

    public UserHelper user() {
        return userHelper;
    }

    public void start() throws IOException {
        wd = new ChromeDriver();
        properties = new Properties();
        userHelper = new UserHelper(wd);
        boardHelper = new BoardHelper(wd);
        String target = System.getProperty("board", "gleb");

        properties.load(new FileReader(new File(String.format("src/test/java/resources/%s.properties", target))));

        wd.navigate().to(properties.getProperty("web.url"));
        wd.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
        wd.manage().timeouts().setScriptTimeout(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    public String setEmail() {
        return properties.getProperty("web.email");
    }

    public String setPassword() {
        return properties.getProperty("web.password");
    }

    public void stop() {
        wd.quit();
    }
}



