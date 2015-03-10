package org.edu.uams.server.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class DocumentUtil {

	public static void getFileFromBytes(byte[] bytes, File file) {

		OutputStream output = null;
		ByteArrayInputStream input = new ByteArrayInputStream(bytes);
		int data = 0;

		try {
			output = new FileOutputStream(file);
			while ((data = input.read()) != -1) {
				output.write(data);
			}
			output.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
