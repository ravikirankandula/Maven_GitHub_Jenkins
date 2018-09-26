package uploads;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class Robot1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver wd=new ChromeDriver();
        
        wd.get("file:///C:/Users/rkandula/Desktop/fileupload.html");
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        
      
        
        String file1="\"C:\\Users\\rkandula\\Desktop\\window_Textbox.png\"";
        
        String file2="\"C:\\Users\\rkandula\\Desktop\\window_openbtn.png\"";
        
        String total=file1+file2;
        
       wd.findElement(By.id("fileupload")).click();
        
        
		
		Thread.sleep(2000);
		uploadFile(total);
		Thread.sleep(2000);
	}
	
	public static void setClipboardData(String string) {
		//StringSelection is a class that can be used for copy and paste operations.
		   StringSelection stringSelection = new StringSelection(string);
		   Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
		}
	
	public static void uploadFile(String fileLocation) {
        try {
        	//Setting clipboard with file location
            setClipboardData(fileLocation);
            //native key strokes for CTRL, V and ENTER keys
            Robot robot = new Robot();
	
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
        } catch (Exception exp) {
        	exp.printStackTrace();
        }
    }

        
        
        
		
		
	}


