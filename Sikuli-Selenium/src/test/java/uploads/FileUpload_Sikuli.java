package uploads;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class FileUpload_Sikuli {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Softwares\\chromebrowser\\chromedriver_win32 (2)\\chromedriver.exe");
        WebDriver wd=new ChromeDriver();
        
        wd.get("file:///C:/Users/rkandula/Desktop/fileupload.html");
        
       // wd.findElement(By.id("fileupload")).click();
        
        Screen sikuliscreen=new Screen();
        
        String file1="\"C:\\Users\\rkandula\\Desktop\\window_Textbox.png\"";
        
        String file2="\"C:\\Users\\rkandula\\Desktop\\window_openbtn.png\"";
        
        String total=file1+file2;
        
        wd.findElement(By.id("fileupload")).sendKeys(file1);
        
        Thread.sleep(3000);
        
        /*System.out.println(total);
        
        Pattern window_popup_textbox=new Pattern("C:\\Users\\rkandula\\Desktop\\window_Textbox.png");
        
        Pattern window_openbtn=new Pattern("C:\\Users\\rkandula\\Desktop\\window_openbtn.png");
        
        sikuliscreen.wait(window_popup_textbox, 20);
        
        sikuliscreen.type(window_popup_textbox, total );
        
        sikuliscreen.click(window_openbtn);
        
        Thread.sleep(3000);
        
        wd.close();
        
        */
        
        
        
        
		
		
	}

}
