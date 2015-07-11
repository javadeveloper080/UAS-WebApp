package org.edu.uams.server.api;

public enum DocType {

	  pdf {
		    @Override
		    public String getMimeType() { 
		      return "application/pdf"; 
		    }
		    @Override
		    public String getFileExtension() {
		      return "pdf";
		    }  
		  },
		  
		  doc {
		    @Override
		    public String getMimeType() { 
		      return "application/msword"; 
		    }    
		    @Override
		    public String getFileExtension() {
		      return "doc";
		    }  
		  },
		  
		  docx {
		    @Override
		    public String getMimeType() { 
		      return "application/vnd.openxmlformats-officedocument.wordprocessingml.document"; 
		    }
		    
		    @Override
		    public String getFileExtension() {
		      return "docx";
		    }
		  },
		  
		  txt {
		    @Override
		    public String getMimeType() { 
		      return "txt"; 
		    }
		    
		    @Override
		    public String getFileExtension() {
		      return "txt";
		    }
		  };  
		  
		  @Override
		  public String toString() {
		    return getFileExtension();
		  }
		    
		  public abstract  String getMimeType(); 
		    
		  public abstract  String getFileExtension();
		  
		}