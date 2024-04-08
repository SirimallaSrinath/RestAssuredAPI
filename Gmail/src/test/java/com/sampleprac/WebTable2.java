package com.sampleprac;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WebTable2 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(5));
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(5));
		driver.get("https://datatables.net/extensions/select/examples/initialisation/simple.html");
		List<WebElement> totalrows = driver.findElements(By.xpath("//table[@id='example']//tbody//tr"));
		List<WebElement> totalcolumns =driver.findElements(By.xpath("//table[@id='example']//tbody//tr[1]//td"));

		for(int i=1;i<=totalrows.size();i++) {
			for(int j=1;j<=totalcolumns.size();j++) {
				String eachrowcoltext = driver.findElement(By.xpath("//table[@id='example']//tbody//tr["+i+"]//td["+j+"]")).getText();
				System.out.println("Each Row column text: "+eachrowcoltext);
			}
		}
	}

}
