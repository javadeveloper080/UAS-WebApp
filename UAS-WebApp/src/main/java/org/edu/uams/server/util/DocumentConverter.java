package org.edu.uams.server.util;

import org.edu.uams.server.api.Document;

public class DocumentConverter {
	
	  public static boolean isWordDoc(Document appDocument) {
		    if ((appDocument != null) && (appDocument.getFileName() != null)){
		      String lcFileName = appDocument.getFileName().toLowerCase();
		      if ((lcFileName.endsWith("doc")) || (lcFileName.endsWith("docx")) ||
		          (lcFileName.endsWith("dot")) || (lcFileName.endsWith("dotx"))) { 
		        return true;
		      }
		    }
		    return false;
		  }
		  
		  public static boolean isPdf(Document appDocument) {
		    if ((appDocument != null) && (appDocument.getFileName() != null)){
		      String lcFileName = appDocument.getFileName().toLowerCase();
		      if ((lcFileName.endsWith("pdf")) ) { 
		        return true;
		      }
		    }
		    return false;
		  }

}
