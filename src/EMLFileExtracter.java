import java.io.FileInputStream;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimePart;

public class EMLFileExtracter {

    public static void main(String[] args) {
        String emlFilePath = "E:\\Saurav\\Inbox\\0000000258-sfqwef.eml";

        try (FileInputStream fis = new FileInputStream(emlFilePath)) {
            Properties properties = System.getProperties();
            Session session = Session.getDefaultInstance(properties, null);

            MimeMessage mimeMessage = new MimeMessage(session, fis);

            // Extract information from the MimeMessage
            String subject = mimeMessage.getSubject();
            String from = mimeMessage.getFrom()[0].toString();
           
//            String to=mimeMessage.getSubject();
//            System.out.println(to);
            String content = extractContent(mimeMessage);

            // You can now use 'subject', 'from', and 'content' as needed
            System.out.println("Subject: " + subject);
            System.out.println("From: " + from);
            System.out.println("Content: " + content);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractContent(MimePart mimePart) throws MessagingException, java.io.IOException {
        if (mimePart.isMimeType("text/plain")) {
            return mimePart.getContent().toString();
        } else if (mimePart.isMimeType("multipart/*")) {
            Multipart multipart = (Multipart) mimePart.getContent();
            StringBuilder content = new StringBuilder();
            for (int i = 0; i < multipart.getCount(); i++) {
                content.append(extractContent((MimePart) multipart.getBodyPart(i)));
            }
            return content.toString();
        }
        return "";
    }
}



//  https://forum.aspose.com/t/how-can-i-read-eml-mail-message-with-attachment/39001/2