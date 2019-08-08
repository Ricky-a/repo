package com.crm.web;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.crm.entity.FTPFileClass;
import com.crm.vo.ServerResponse;

@Controller
@RequestMapping("/file")
public class FileUploadController {

	@RequestMapping("springUpload")
	@ResponseBody
	public ServerResponse<?> fileUpload(HttpServletRequest request,  MultipartFile fileObj)
			throws IllegalStateException, IOException {
		String path = request.getSession().getServletContext().getRealPath("file") + "\\";// 设置上传路径
		//String fileNames = fileName.isEmpty() ? fileObj.getOriginalFilename() : fileName;
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
		if (multipartResolver.isMultipart(request)) {
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			Iterator<?> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				fileObj = multiRequest.getFile(iter.next().toString());// 一次遍历所有文件
				if (fileObj != null) {
					/*String   = fileName.isEmpty();
					String str = null;
					if (fileObj.getOriginalFilename().endsWith(".txt")) {
						str = path + fileNames + ".txt";
					} else {
						str = path + fileNames;
						// + "." + FTPFileClass.getFileType(fileObj);
					}*/
					String filter = path + fileObj.getOriginalFilename();
					
					fileObj.transferTo(new File(filter));// 上传
				}
			}
		}
		return ServerResponse.createBySuccessMessage("上传成功");
	}

	// http://localhost:8080/mycrm/file/showFile
	@RequestMapping("showFile")
	@ResponseBody
	public Object showFile(HttpServletRequest request, HttpServletResponse response) {
		/*
		 * String path =
		 * "C:\\Users\\admin\\workspace\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\mycrm\\file";
		 * File file = new File(path); File[] tempList = file.listFiles();
		 * System.out.println("该目录下对象个数：" + tempList.length); for (int i = 0; i
		 * < tempList.length; i++) { if (tempList[i].isFile()) {
		 * System.out.println("文     件：" + tempList[i]); } if
		 * (tempList[i].isDirectory()) { System.out.println("文件夹：" +
		 * tempList[i]); }
		 * 
		 * }
		 */
		

		return "";
	}

}
