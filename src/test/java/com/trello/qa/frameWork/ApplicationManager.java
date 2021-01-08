package com.trello.qa.frameWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    UserHelper userHelper;



    public void start() {
        wd = new ChromeDriver();
        wd.navigate().to("https://trello.com");
        wd.manage().window().maximize();//растянет окно на весь экран
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//ожидание появления объекта
        userHelper = new UserHelper(wd);


    }

    public void stop() {
        wd.quit();
    }

    public UserHelper user() {
        return userHelper;
    }



    public WebDriver getWd() {
        return wd;
    }
}



