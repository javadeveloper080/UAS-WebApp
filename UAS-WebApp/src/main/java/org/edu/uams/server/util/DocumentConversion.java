package org.edu.uams.server.util;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.edu.uams.server.api.Document;

public class DocumentConversion {

	public static void getFileFromBytes(byte[] bytes, File file) throws FileNotFoundException, IOException {

		OutputStream output = null;
		ByteArrayInputStream input = new ByteArrayInputStream(bytes);
		int data = 0;

		output = new FileOutputStream(file);
		while ((data = input.read()) != -1) {
			output.write(data);
		}
		output.close();
	}

	/**
	 * Returns the contents of the file in a byte array
	 * @return byte[] Returns a byte[] array of the contents of the file
	 */
	public static byte[] getBytesFromFile(File file) throws IOException {
            byte[] bytes;
            try (InputStream is = new FileInputStream(file)) {
                long length = file.length();
                if (length > Integer.MAX_VALUE) {
                    System.out.println("File is too large to process");
                    return null;
                }
                bytes = new byte[(int) length];
                int offset = 0;
                int numRead = 0;
                while ((offset < bytes.length) &&
                        ((numRead = is.read(bytes, offset, bytes.length - offset)) >= 0)) {
                    
                    offset += numRead;
                }
                if (offset < bytes.length) {
                    throw new IOException("Could not completely read file " + file.getName());
                }
            }
		return bytes;
	}
  
  
  public static File writeBytesToFile(Document document) throws IOException {
    return writeBytesToFile(document, null);
  }
  
  public static File writeBytesToTempFile(Document document) throws IOException {
    return writeBytesToFile(document, new Long(System.currentTimeMillis()));
  }
  
  private static File writeBytesToFile(Document document, Long uniqueFileIndex) throws IOException {
    
    if ((document != null) && (document.getFileName() != null)){
      String fileName = document.getFileName();
      if (uniqueFileIndex != null) {
        StringBuilder sb = new StringBuilder(fileName);
        sb.replace(fileName.lastIndexOf("."), fileName.lastIndexOf(".") + 1, 
                    "_" + uniqueFileIndex + "." );
        fileName = sb.toString();
      }
      File file = new File (fileName);
        try (OutputStream output = new BufferedOutputStream(new FileOutputStream(file))) {
            output.write(document.getFileBytes());
        }
      return file;
    }
    return null;
  }
}

