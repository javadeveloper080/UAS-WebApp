package org.edu.uams.server.pojo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.edu.uams.server.api.Document;
import org.edu.uams.server.util.DocumentConversion;



@Entity(name = "Document")
@Table(name = "document")
public class DocumentEntity  implements  Document  {


    public static final  String  FIND_ALL="SELECT d FROM Document d";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

	@Basic(optional = false)
	@Column(name = "file_name", nullable = false)
	private String fileName;

	@Basic(optional = true)
	@Column(name = "mime_type", nullable = true)
	private String mimeType;

	@Basic(optional = true)
	@Column(name = "description", nullable = true)
	private String description;



	@Column(name = "file_bytes", nullable = false)
	private byte[] fileBytes;

	public DocumentEntity() {
	}

	
	@Override
	public File getFile() throws FileNotFoundException, IOException {
		if (fileBytes != null) {
			File path = new File("docs");
			if (!path.isDirectory()) {
				path.mkdir();
			}
			File file = new File(path, fileName);
			DocumentConversion.getFileFromBytes(fileBytes, file);
			return file;
		}
		return null;
	}

	
	@Override
	public long getId() {
		return id;
	}


	@Override
	public void setId(long id) {
		this.id = id;
	}

	
	@Override
	public String getFileName() {
		return fileName;
	}


	@Override
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@Override
	public String getMimeType() {
		return mimeType;
	}


	@Override
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	
	@Override
	public String getDescription() {
		return description;
	}


	@Override
	public void setDescription(String description) {
		this.description = description;
	}

	
	@Override
	public byte[] getFileBytes() {
		return fileBytes;
	}

	
	@Override
	public void setFileBytes(byte[] fileBytes) {
		this.fileBytes = fileBytes;
	}
	
	

	}
