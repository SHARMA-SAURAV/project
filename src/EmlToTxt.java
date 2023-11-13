import com.aspose.email.MailMessage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class EmlToTxt {

    public static void main(String[] args) {
        String emlFilePath = "E:\\Saurav\\Inbox\\0000000273-54112.eml";
        String outputFilePath = "E:\\Saurav\\output.txt.txt";

        try {
            MailMessage mailMessage = MailMessage.load(emlFilePath);

            // Extract the text content from the EML message
            String messageText = mailMessage.getBody().toString();
            String from=mailMessage.getFrom().toString();
            System.out.println(from);
            // Write the text content to a text file
            try (FileWriter writer = new FileWriter(outputFilePath)) {
                writer.write(messageText);
            }

            System.out.println("Conversion from EML to TXT completed successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
