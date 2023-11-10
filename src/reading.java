import org.apache.commons.compress.archivers.tar.TarArchiveEntry;
import org.apache.commons.compress.archivers.tar.TarArchiveInputStream;
import org.apache.commons.compress.compressors.gzip.GzipCompressorInputStream;

import java.io.*;

public class reading {

    public static void main(String[] args) {
        String tgzFilePath = "C:\\Users\\admin\\Downloads\\hello.tgz";
        String destinationDirectory = "E:\\Saurav";

        try {
            FileInputStream fis = new FileInputStream(tgzFilePath);
            GzipCompressorInputStream gzis = new GzipCompressorInputStream(fis);
            TarArchiveInputStream taris = new TarArchiveInputStream(gzis);

            TarArchiveEntry entry;
            while ((entry = taris.getNextTarEntry()) != null) {
                if (entry.isDirectory()) {
                    continue;
                }

                File outFile = new File(destinationDirectory, entry.getName());
//                System.out.println();
                File parent = outFile.getParentFile();
                if (!parent.exists() && !parent.mkdirs()) {
                    throw new IllegalStateException("Couldn't create dir: " + parent);
                }

                try (OutputStream fos = new FileOutputStream(outFile)) {
                    byte[] buffer = new byte[1024];
                    int length;
                    while ((length = taris.read(buffer)) != -1) {
                        fos.write(buffer, 0, length);
                    }
                }
            }

            taris.close();
            gzis.close();
            fis.close();

            System.out.println("Extraction completed successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
