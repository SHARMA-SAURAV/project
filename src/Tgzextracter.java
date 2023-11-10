import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.*;

public class Tgzextracter {

    public static void main(String[] args) {
        String tgzFilePath = "C:\\Users\\admin\\Downloads\\hello.tgz";

        try {
            FileInputStream fis = new FileInputStream(tgzFilePath);
            GzipCompressorInputStream gzis = new GzipCompressorInputStream(fis);
            TarArchiveInputStream taris = new TarArchiveInputStream(gzis);

            TarArchiveEntry entry;
            while ((entry = taris.getNextTarEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }

                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                byte[] buffer = new byte[1024];
                int length;
                while ((length = taris.read(buffer)) != -1) {
                    baos.write(buffer, 0, length);
                }

                byte[] data = baos.toByteArray();
                // Now 'data' contains the content of the current entry
               
//                System.out.println();
//                System.out.println("path: "+ entry.getFile());
                if(entry.getName().toString().startsWith("Inbox")) {
//                	System.out.println("yes");
                	System.out.println("File: " + entry.getName());
                  System.out.println("Data: " + new String(data)); // Assuming the data is text
                }
//                	 

                baos.close();
            }

            taris.close();
            gzis.close();
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
