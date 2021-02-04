package com.trello.qa.frameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;
import java.io.FileNotFoundException;
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
        String target = System.getProperty("target", "gleb");

        properties.load(new FileReader(new File(String.format("src/test/java/resources/%s.properties", target))));

        wd.navigate().to(properties.getProperty("web.url"));
        wd.manage().window().maximize();//растянет окно на весь экран
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//ожидание появления объекта
        userHelper = new UserHelper(wd);
        boardHelper = new BoardHelper(wd);

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



