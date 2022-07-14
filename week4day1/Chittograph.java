package week4day1;


import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Chittograph {
	public static void main(String[] args) {

		WebDriverManager.firefoxdriver().setup();
		FirefoxDriver driver = new FirefoxDriver();
		driver.get("https://www.chittorgarh.com/");
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		//driver.findElement(By.id("navbtn_stockmarket"));
		WebElement elementclick = driver.findElement(By.id("navbtn_stockmarket"));
		elementclick.click();
		
		WebElement elementclickbd = driver.findElement(By.xpath("//*[text()=\"NSE Bulk Deals\"]"));
		elementclickbd.click();
		
		List<String> SecurityNamelist = new ArrayList<String>();		
		WebElement table2=driver.findElement(By.xpath("//div//table[@class='table table-bordered table-condensed table-striped']"));
        List <WebElement> rowvalues=table2.findElements(By.xpath("//tr"));
        
        for(int i=1;i<rowvalues.size()-1;i++) {
        	WebElement findelement =rowvalues.get(i).findElement(By.xpath("//th["+i+"]"));
        	
        	if(findelement.getText().equals("Security Name")) {
        		
        	for(int j=1; j<=rowvalues.size()-i; j++) {
        		String securitynameval = table2.findElement(By.xpath("//tr["+j+"]//td["+i+"]")).getText();
        	  SecurityNamelist.add(securitynameval);
        	  
        	}
        	
        	System.out.println(SecurityNamelist);
        	Set<String> targetSet = new TreeSet<String>(SecurityNamelist);
        	System.out.println(targetSet);
        	if(targetSet.size()<SecurityNamelist.size()) {
        		System.out.println("Yes the list contains duplicate Security names");
        	}
        	break;
        	}
        }
        
	driver.close();
	
	
	
	}
	
	}

