package com.skyteam.letu.servlet;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.skyteam.letu.dao.impl.ImageDaoImpl;
import com.skyteam.letu.entities.Forum;
import com.skyteam.letu.entities.Strategy;
import com.skyteam.letu.entities.TravleNote;
import com.skyteam.letu.server.impl.ForumManageImpl;
import com.skyteam.letu.server.impl.StrategyManageImpl;
import com.skyteam.letu.server.impl.TravleNoteManageImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FilenameUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "imgUpload", value = "/imgUpload")
public class imgUpload extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String savePath = null;
        String NoteID = null;
        String ForumID = null;
        String UserID = null;
        String type = null;
        List<String> filePathList = new ArrayList<>();
        DiskFileItemFactory dff = new DiskFileItemFactory();
        ServletFileUpload sfu = new ServletFileUpload(dff);
        try {
            List<FileItem> items = sfu.parseRequest(request);
            for(FileItem item : items){
                //如果fileitem中封装的是普通输入项的数据
                if(item.isFormField()){
                    String name = item.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = item.getString("UTF-8");
                    switch(name){
                        case "Strategy":
                            savePath = "/image/strategyImg";
                            break;
                        case "TravleNote":
                            type = "Note";
                            savePath = "/image/travlenoteImg";
                            NoteID = new TravleNoteManageImpl().setTravleNote(new Gson().fromJson(value, TravleNote.class), 2);
                            break;
                        case "Forum":
                            type = "Forum";
                            savePath = "/image/forumImg";
                            ForumID = new ForumManageImpl().setForum(new Gson().fromJson(value, Forum.class));
                            break;
                        case "ID":
                            type = "Avatar";
                            savePath = "/image/avatar";
                            UserID = value;
                            break;
                    }
                }else{
                    //得到上传的文件名称，
                    String filename = item.getName();
                    if(filename==null || filename.trim().equals("")){
                        continue;
                    }
                    if (filename != null) {
                        filename = UUID.randomUUID().toString() + "." + FilenameUtils.getExtension(filename);
                    }
                    //获取item中的上传文件的输入流
                    InputStream in = item.getInputStream();
                    //创建一个文件输出流
                    FileOutputStream out = new FileOutputStream(savePath + "/" + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int len = 0;
                    //循环将输入流读入到缓冲区当中，(len=in.read(buffer))>0就表示in里面还有数据
                    while((len=in.read(buffer))>0){
                        //使用FileOutputStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        out.write(buffer, 0, len);
                    }
                    //关闭输入流
                    in.close();
                    //关闭输出流
                    out.close();
                    //删除处理文件上传时生成的临时文件
                    item.delete();
                    String filePath = savePath + "/" + filename;
                    boolean is_success = false;
                    switch (type){
                        case "Note":
                            is_success = new ImageDaoImpl().saveImagePath(type, NoteID, filePath);
                            break;
                        case "Forum":
                            is_success = new ImageDaoImpl().saveImagePath(type, ForumID, filePath);
                            break;
                        case "Avatar":
                            is_success = new ImageDaoImpl().saveImagePath(type, UserID, filePath);
                            break;
                    }
                    if (is_success){
                        filePathList.add(filePath);
                    }
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }finally {
            response.getWriter().write(new Gson().toJson(filePathList == null?new JsonObject():filePathList));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
