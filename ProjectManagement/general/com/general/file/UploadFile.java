package com.general.file;


import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.project.format.Format;

@WebServlet("/UploadFile")
public class UploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean isMultipart;
	private String filePath;
	private int maxFileSize = 1000000 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file ;

	public void init( ){
		// Get the file location where it would be stored.
		filePath = getServletContext().getInitParameter("file-upload"); 
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Check that we have a file upload request
	      isMultipart = ServletFileUpload.isMultipartContent(request);
	      response.setContentType("text/html");
	      java.io.PrintWriter out = response.getWriter( );
	      
	      if( !isMultipart ) {
              out.println("<script type=\"text/javascript\">");
              out.println("location='JSPs/Interview/JSPs/Format.jsp';");
              out.println("</script>");
	         return;
	      }
	  
	      DiskFileItemFactory factory = new DiskFileItemFactory();
	   
	      // maximum size that will be stored in memory
	      factory.setSizeThreshold(maxMemSize);

	      // Location to save data that is larger than maxMemSize.
	      factory.setRepository(new File("/UploadFile"));

	      // Create a new file upload handler
	      ServletFileUpload upload = new ServletFileUpload(factory);
	   
	      // maximum file size to be uploaded.
	      upload.setSizeMax( maxFileSize );
	      System.out.println(factory.getRepository().getParent());
	      try {
	         // Parse the request to get file items.
	         List<FileItem> fileItems = upload.parseRequest(request);
	         System.out.println(fileItems);
	         // Process the uploaded file items
	         Iterator<FileItem> i = fileItems.iterator();
	         String fieldValue = null;
	         String fid="" ;System.out.println(i);
	         while (i.hasNext()) {
	            FileItem fi = (FileItem)i.next();//System.out.println(fi);
	           
				if(fi.getFieldName().equals("fid"))
	            	 fid=fi.getString();
	            /*if (fi.isFormField()) {
	                 fieldValue = fi.getString();
	            }else {
	            	fieldValue = fid;
	            }//
*/	          	
				fieldValue = fid;
				System.out.print(fi.isFormField());
				if ( !fi.isFormField()) {
	               // Get the uploaded file parameters
	               String fileName = fi.getName(); System.out.println("fileName"+fileName);
	               String oldFileExt = fileName.substring(fileName.lastIndexOf("."));
	               // Write the file
	               String fullName = fieldValue + oldFileExt;
	               if( fileName.lastIndexOf("\\") >= 0 ) {
	                  file = new File( filePath + fullName) ;
	               } else {
	                  file = new File( filePath + fullName) ;
	               }
	               //if it is there then delete	      
	               if(file != null) file.delete();
	               fi.write( file ) ; 
	               System.out.print("879878787987"+file.getAbsolutePath());
	               String[] data= {getServletContext().getInitParameter("file-app")+"Janhavee.app", file.getAbsolutePath() , "/Dropbox/"+fullName};
	               //String[] data= {getServletContext().getInitParameter("file-app")+"Janhavee.app", "/home/janhavee/Documents/F211710150705.sql" , "/Dropbox/"+fullName};
	               SaveToDropbox.saveFile(data);
	               Format f=new Format();
	               f.setFormatId(fid);
	               f.setFilename(fullName);
	               f.setFilepath("/Dropbox/"+fullName);
	               if(f.saveLocation())
	            	   out.println("1");
	               else
	            	   out.println("0");   
	               /*out.println("<script type=\"text/javascript\">");
	               out.println("location='JSPs/Interview/JSPs/Format.jsp';");
	               out.println("</script>");*/
	            }
	         }
	         } catch(Exception ex) {
	        	 out.println("0");   
	         }
	}
}