package com.qxfile.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.qxfile.lintener.MyProgressListener;

/**
 * 
 * @Description:文件上传
 * @author:Qian
 * @date: 2020年4月26日 下午3:15:08
 * @version V1.0
 */
@WebServlet("/FileUpServlet")
public class FileUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 上传文件存储目录
	private static final String UPLOAD_DIRECTORY = "upload";

	// 上传配置
	private static final int MEMORY_THRESHOLD = 1024 * 1024 * 3; // 3MB
	private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE = 1024 * 1024 * 50; // 50MB

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FileUpServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//取出监听器MyProgress在session中保存的进度信息
        String progress=(String) request.getSession().getAttribute("progress");
        //响应
        response.getWriter().print(progress);
        //清除session中保存的数据
//        req.getSession().removeAttribute("progress");
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setCharacterEncoding("utf-8");
		// 判断是不是多媒体上传
		if (!ServletFileUpload.isMultipartContent(request)) {
			// 如果不是提示信息
			PrintWriter writer = response.getWriter();
			writer.println("Error: 表单必须包含 enctype=multipart/form-data");
			writer.flush();
			return;
		}
		
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		diskFileItemFactory.setSizeThreshold(MEMORY_THRESHOLD);
		diskFileItemFactory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
        servletFileUpload.setProgressListener(new MyProgressListener(request));
        servletFileUpload.setFileSizeMax(MAX_FILE_SIZE);
        servletFileUpload.setSizeMax(MAX_REQUEST_SIZE);
        servletFileUpload.setHeaderEncoding("UTF-8");
        
        String uploadPath = getServletContext().getRealPath("/")+File.separator+UPLOAD_DIRECTORY;
        File uploadDir = new File(uploadPath);
        if(!uploadDir.exists()) {
        	uploadDir.mkdir();
        }
        StringBuilder builder = new StringBuilder();
        try {
			List<FileItem> formItems = servletFileUpload.parseRequest(request);
			if(formItems!=null&&!formItems.isEmpty()) {
				for (FileItem fileItem : formItems) {
					//处理不在表单中的字段
					if(!"".equals(fileItem.getName())) {
					if(!fileItem.isFormField()) {
						String fileName = new File(fileItem.getName()).getName();
						String filePath = uploadPath+File.separator+fileName;
						File storeFile = new File(filePath);
						System.out.println(filePath);
						fileItem.write(storeFile);
						builder.append(fileName+",");
						
						fileItem.delete();
					}
					}
				}
				builder.append("上传成功！");
				request.setAttribute("message", builder);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			request.setAttribute("message",
                    "错误信息: " + e.getMessage());
		}
        
        getServletContext().getRequestDispatcher("/message.jsp").forward(request, response);
        
	}

}
