package org.edu.uams.server.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public interface Document extends Serializable{

	public File getFile() throws FileNotFoundException, IOException;

	public long getId();

	public void setId(long id);

	public String getFileName();

	public void setFileName(String fileName);

	public String getMimeType();

	public void setMimeType(String mimeType);

	public String getDescription();

	public void setDescription(String description);


	public byte[] getFileBytes();

	public void setFileBytes(byte[] fileBytes);

}