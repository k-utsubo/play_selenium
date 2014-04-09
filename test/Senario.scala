import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

class Senario {

	def test( baseUrl:String,  driver:WebDriver) ={
		driver.get(baseUrl);
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.id("name")).clear();
	    driver.findElement(By.id("name")).sendKeys("TEST");  
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.id("repeat")).clear();
	    driver.findElement(By.id("repeat")).sendKeys("200");
	    driver.findElement(By.id("submit")).click();
	    driver.findElement(By.id("repeat")).clear();
	    driver.findElement(By.id("repeat")).sendKeys("50");
	    new Select(driver.findElement(By.id("color"))).selectByVisibleText("Green");
	    driver.findElement(By.id("submit")).click();
	    DevCiUtils.takeCapture(driver,"capture1.png"); // capture
	    
	    driver.findElement(By.linkText("Back to the form")).click();
	    DevCiUtils.takeCapture(driver,"capture2.png"); // capture
	}

}
