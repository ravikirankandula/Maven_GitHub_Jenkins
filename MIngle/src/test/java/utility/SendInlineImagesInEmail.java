package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class SendInlineImagesInEmail {
	public static void main(String args[]) throws FileNotFoundException, IOException{
	 // Recipient's email ID needs to be mentioned.
		
    String to = "lavanya.kanthu@infor.com";

    // Sender's email ID needs to be mentioned
    String from = "lavanya.kanthu@infor.com";
    final String username = "lkanthu";//change accordingly
    final String password = "H@rsha1234$";//change accordingly

    // Assuming you are sending email through relay.jangosmtp.net
    String host = "relay.jangosmtp.net";

    Properties props = new Properties();
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.smtp.host", "smtp-relay.infor.com");
    props.put("mail.smtp.port", "25");

    Session session = Session.getInstance(props,
       new javax.mail.Authenticator() {
          protected PasswordAuthentication getPasswordAuthentication() {
             return new PasswordAuthentication(username, password);
          }
       });

    try {


   

   WebDriver driver=new FirefoxDriver();
   driver.get("C:\\Mingle_Project\\MIngle\\Mingle\\logs\\extent.html");
   driver.findElement(By.xpath("//a[@class='dashboard-view']")).click();
   File scrFile = ((TakesScreenshot)driver). getScreenshotAs(OutputType.FILE);
   //The below method will save the screen shot in d drive with name "screenshot.png"
      FileUtils.copyFile(scrFile, new File("C:\\Mingle_Project\\screenshot.png"));
driver.close();
     
    
      
      
      // Create a default MimeMessage object.
      Message message = new MimeMessage(session);

      // Set From: header field of the header.
      message.setFrom(new InternetAddress(from));

      // Set To: header field of the header.
      message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));

      // Set Subject: header field
      message.setSubject("Testing Subject");

      // This mail has 2 part, the BODY and the embedded image
      Multipart  multipart = new MimeMultipart("related");

      // first part (the html)
      BodyPart messageBodyPart = new MimeBodyPart();
      String htmlText = "<H1>Mingle Automation Test Report</H1><img src=\"cid:image\">";
      messageBodyPart.setContent(htmlText, "text/html");
      // add it
      multipart.addBodyPart(messageBodyPart);

      // second part (the image)
      messageBodyPart = new MimeBodyPart();
      DataSource fds = new FileDataSource(
         "C:\\Mingle_Project\\screenshot.png");

      messageBodyPart.setDataHandler(new DataHandler(fds));
      messageBodyPart.setHeader("Content-ID", "<image>");
      
      MimeBodyPart messageBodyPart2 = new MimeBodyPart();  
      
      //  String filename = "SendAttachment.java";//change accordingly  
        DataSource source = new FileDataSource("./zipdemo.zip");  
        messageBodyPart2.setDataHandler(new DataHandler(source));  
        messageBodyPart2.setFileName("./zipdemo.zip");  
      
      
      // add image to the multipart
      multipart.addBodyPart(messageBodyPart);
      multipart.addBodyPart(messageBodyPart2);

      // put everything together
      message.setContent(multipart);
      // Send message
      Transport.send(message);

      System.out.println("Sent message successfully....");

   } catch (MessagingException e) {
      throw new RuntimeException(e);
   }

       System.out.println("Sent message successfully....");

    
 }
}
