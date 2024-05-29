package org.qa.intermediate;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class Dropdown {

	public static void main(String[] args) {
		ChromeOptions co = new ChromeOptions();
		co.setBrowserVersion("125");
		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/search?q=dropdown");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(1000));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(500));

		WebElement ele = driver.findElement(By.id("tools"));
		Select sel = new Select(ele);
		List<WebElement> options = sel.getOptions();
		for(WebElement e:options) {
			String str=e.getText();
			if(str.contains("Selenium")) {
				e.click();
				break;
			}
		}

	}

}
