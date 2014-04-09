
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.Augmenter;

object DevCiUtils {
	val dir="."
	
	def deleteCapture()={
		val f=new File(dir);
		if(f.exists())f.delete();
		f.mkdir();
	}

	def takeCapture(driver:WebDriver ,fileName:String)=  {
		Thread.sleep(100);
		val f=new File(dir);
		if(!f.exists())f.mkdir();
	
		if(driver.isInstanceOf[TakesScreenshot]) {
			val tmpFile = (driver.asInstanceOf[TakesScreenshot]).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(tmpFile, new File(fileName));
		}else{
			FileHandler.copy(((new Augmenter().augment(driver)).asInstanceOf[TakesScreenshot]).getScreenshotAs(OutputType.FILE), new File(fileName));    		
		}

	}

}