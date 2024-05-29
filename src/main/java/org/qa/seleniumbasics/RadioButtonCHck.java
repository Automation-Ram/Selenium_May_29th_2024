package org.qa.seleniumbasics;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class RadioButtonCHck {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/radio-button");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		driver.findElement(By.xpath("(//label[@class='custom-control-label'])[1]")).click();
	}

}
