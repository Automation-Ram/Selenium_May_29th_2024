package org.qa.seleniumbasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LaunchBrowser {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		List<WebElement> links = driver.findElements(By.tagName("a"));

		System.out.println(links.size());

		for (WebElement lk : links) {
			String linkText = lk.getText();
			if (linkText.contains("தமிழ்")) {
				lk.click();
				break;
			}

		}

	}

}
