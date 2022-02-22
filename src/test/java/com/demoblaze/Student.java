package com.demoblaze;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Student {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver;
        driver = new ChromeDriver();
        driver.get("https://codingbat.com/java/Warmup-1");

        WebElement execise = driver.findElement(By.cssSelector("body > div.tabc > div > div > table > tbody > tr:nth-child(7) > td:nth-child(3) > a"));
        execise.click();
        Thread.sleep(2000);

        WebElement inputtingcode = driver.findElement(By.cssSelector("#ace_div > div.ace_scroller > div > div.ace_layer.ace_text-layer > div:nth-child(2)"));
        Thread.sleep(1000);
        inputtingcode.sendKeys("" + "  if (str.length()>=4 && str.substring(1, 4).equals(\"del\")) {\n" + "  \n" + "    return str.substring(0, 1) + str.substring(4);\n" + "  }\n" + "\n" + "  return str;");

    }
}
