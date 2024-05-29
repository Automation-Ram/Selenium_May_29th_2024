package org.qa.intermediate;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWebTable {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://seleniumpractise.blogspot.com/2021/08/webtable-in-html.html");
		List<WebElement> data = driver.findElements(By.xpath("//table[@id='customers']//tbody//th"));
		for (WebElement str : data) {

			String s = str.getText();
			if (s.contains("Country")) {
				System.out.println(str.getText());
				break;
			}

		}
	}

}
