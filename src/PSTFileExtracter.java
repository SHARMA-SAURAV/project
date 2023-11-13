import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;
import com.aspose.email.*;

import java.io.*;

public class PSTFileExtracter {

    public static void main(String[] args) {
        String tgzFilePath = "C:\\Users\\admin\\Downloads\\hello.tgz";
        String pstFilePath = "output.pst";

        extractTGZAndCreatePST(tgzFilePath, pstFilePath);
    }

    private static void extractTGZAndCreatePST(String tgzFilePath, String pstFilePath) {
        try {
            // Extract TGZ file
            PersonalStorage pst = PersonalStorage.create(pstFilePath, FileFormatVersion.Unicode);

            try (TarArchiveInputStream tgzInputStream = new TarArchiveInputStream(
                    new GzipCompressorInputStream(new FileInputStream(tgzFilePath)))) {
                TarArchiveEntry entry;
                while ((entry = tgzInputStream.getNextTarEntry()) != null) {
                    if (!entry.isDirectory()) {
                        // Process the content of the entry (assuming text files)
                        String emailContent = extractContent(tgzInputStream);
                        
                        // Add the extracted content to the PST file
                        addContentToPST(pst, emailContent);
                    }
                }
            }

            pst.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String extractContent(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            StringBuilder content = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }

            // Process the extracted content as needed
            return content.toString();
        }
    }

    private static void addContentToPST(PersonalStorage pst, String emailContent) {
        FolderInfo inbox = pst.getRootFolder().addSubFolder("Inbox");

        // Create a new message in the inbox folder and set its content
        MapiMessage message = new MapiMessage();
        message.setBody(emailContent);

        // Add other properties or attachments as needed

        // Add the message to the PST file
        inbox.addMessage(message);
    }
}
