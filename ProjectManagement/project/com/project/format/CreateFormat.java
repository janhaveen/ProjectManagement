package com.project.format;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.general.file.SaveToDropbox;
import com.general.system.GetSystemDetails;

/**
 * Servlet implementation class CreateProcess
 */
@WebServlet("/CreateFormat")
public class CreateFormat extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		
		Format f=new Format();
		f.setFormatId(request.getParameter("FormatId"));
		f.setProcessId(request.getParameter("ProcessId"));
		f.setInterviewId(request.getParameter("InterviewId"));
		f.setName(request.getParameter("formatName"));
		f.setFtype(request.getParameter("formatType"));
		//f.setFilename(request.getParameter("filename"));
		f.setCreatedBy(session.getAttribute("userId").toString());
		/*try {
			System.out.print("87797987"+uploader.parseRequest(request).toString());
		} catch (FileUploadException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			System.out.print(fileItemsList);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				
				File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				System.out.println("Absolute Path at server="+file.getAbsolutePath());
				fileItem.write(file);
				out.write("File "+fileItem.getName()+ " uploaded successfully.");
				out.write("<br>");
				out.write("<a href=\"UploadDownloadFileServlet?fileName="+fileItem.getName()+"\">Download "+fileItem.getName()+"</a>");
			}
		} catch (FileUploadException e) {
			out.write("Exception in uploading file.");
		} catch (Exception e) {
			out.write("Exception in uploading file.");
		}*/
		
		if(f.save_format("insert")) { //System.out.print(getServletContext().getInitParameter("upload-from")+request.getParameter("filename"));
	      /*  String[] data= {getServletContext().getInitParameter("file-app")+"Janhavee.app", getServletContext().getInitParameter("upload-from")+request.getParameter("filename") , "/Dropbox/"+request.getParameter("filename")};
			if(SaveToDropbox.saveFile(data))
				out.println("1");
			else
				out.println("0")*/;
			out.println("1");
		}else
			out.println("0");
	}

}
