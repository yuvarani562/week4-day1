package week4day1;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Webtable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver= new ChromeDriver();
		driver.get("http://www.leafground.com/pages/table.html ");
		driver.manage().window().maximize();
		
		WebElement elementTable=driver.findElement(By.tagName("table"));
		List<WebElement>rows =elementTable.findElements(By.tagName("tr"));
		int columns=0;
		
		for(int i=1; i<rows.size();i++) {
			WebElement eachRow =rows.get(i);
			List<WebElement> column = eachRow.findElements(By.tagName("td"));
			columns =column.size();
		}
		System.out.println("Number of Columns= "+columns);
		

	}

}
