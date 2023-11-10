import com.pff.PSTFile;
import com.pff.PSTFolder;
import com.pff.PSTMessage;
import com.pff.PSTObject;

import java.io.FileWriter;
import java.io.IOException;

public class PSTFileExtracter {

    public static void main(String[] args) {
        String pstFilePath = "C:\\Users\\admin\\Desktop\\All-2023-11-09-134507.pst";
        String outputFilePath = "C:\\Users\\admin\\Desktop\\Java1.txt";

        try {
            PSTFile pstFile = new PSTFile(pstFilePath);
            FileWriter writer = new FileWriter(outputFilePath);

            // Iterate through all folders in the PST file
            processFolder(pstFile.getRootFolder(), writer);

            writer.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void processFolder(PSTFolder folder, FileWriter writer) throws Exception {
        // Process items in the folder
        for (PSTObject item : folder.getItemsString()) {
            if (item instanceof PSTMessage) {
                PSTMessage message = (PSTMessage) item;
                String messageInfo = "Subject: " + message.getSubject() + "\n"
                        + "Sender: " + message.getSenderEmailAddress() + "\n"
                        + "Body: " + message.getBody() + "\n-------------------------------\n";

                // Write message information to the text file
                writer.write(messageInfo);
            }
        }

        // Recursively process subfolders
        for (PSTFolder subFolder : folder.getSubFolders()) {
            processFolder(subFolder, writer);
        }
    }
}
