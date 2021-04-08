import java.util.*; 
import javax.mail.*; 
import javax.mail.internet.*; 
import javax.activation.*; 
import javax.mail.Session; 
import javax.mail.Transport; 
  
  
public class EmailSender  
{ 
  
   public static void sendMail(Map<String, String> mailDetail,String sender, String recipient  )
   {     
       // Add event code here...
       // email ID of Recipient. 
       
       // using host as localhost 
     //  String host = "mail.mj-group.com"; 
     String host = "192.168.1.100"; 
       
       // Getting system properties 
       Properties properties = System.getProperties(); 
       
       // Setting up mail server 
       properties.setProperty("mail.smtp.host", host); 
       
       // creating session object to get properties 
       Session session = Session.getDefaultInstance(properties); 
       
       try 
       { 
          // MimeMessage object. 
          MimeMessage message = new MimeMessage(session); 
       
          // Set From Field: adding senders email to from field. 
          message.setFrom(new InternetAddress(sender)); 
       
          // Set To Field: adding recipient's email to from field. 
          message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipient)); 
       
          // Set Subject: subject of the email 
          message.setSubject(mailDetail.get("Subject")); 
       
        // set body of the email. 
        // message.setText("This is a test mail"); 
        //    message.setContent(tableBuilder.getHtmlTable(),"text/html");
           
//         Multipart mp = new MimeMultipart();
//           BodyPart bp ; new MimeBodyPart();           
//           bp =new MimeBodyPart();
//           bp.setContent(mailDetail.get("BodyText"),"text/html");
//           mp.addBodyPart(bp);
//           bp =new MimeBodyPart();
//    //           bp.setContent("This is a test mail eeeee ","text/plain");
//    //           mp.addBodyPart(bp);
//    //           bp =new MimeBodyPart();
//           bp.setContent(mailDetail.get("WeekTable"),"text/html");
//           mp.addBodyPart(bp);
//           message.setContent(mp);
       
           message.setContent(mailDetail.get("BodyText")+mailDetail.get("WeekTable"), "text/html");
           
//          // Send email. 
         Transport.send(message); 
//          System.out.println("Mail successfully sent"); 

           
       } 
       catch (MessagingException mex)  
       { 
          mex.printStackTrace(); 
       } 
       
       
   } 
} 