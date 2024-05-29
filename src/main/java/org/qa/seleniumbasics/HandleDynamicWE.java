package org.qa.seleniumbasics;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HandleDynamicWE {

	public static void main(String[] args) {

		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));
		driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("India");
		List<WebElement> lists = driver.findElements(By.xpath("//ul[@class='G43f7e']//li"));
		System.out.println(lists.size());

		for (WebElement ele : lists) {
			String str = ele.getText();
			if (str.contains("Indian 2")) {
				ele.click();
				break;
			}
		}

	}

}
