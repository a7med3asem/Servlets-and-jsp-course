package controllers.servlets;

import jakarta.servlet.http.*;

import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;

// @WebServlet(name = "FileUploadServlet", urlPatterns = {"/FileUploadServlet"})
// @MultipartConfig
public class FileUploadServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        String saveFilePath = "C:\\newFiles\\";

        System.out.println("Start");

        Part part = request.getPart("file");
        System.out.println("Heeere");
        String fileName = extractFileName(part);
        System.out.println("Heeere");

        PrintWriter out = response.getWriter();

        System.out.println("Heeere");

        try {
            part.write(saveFilePath + fileName);
            out.println("New file " + fileName + "created at " + saveFilePath);
        } catch (Exception e) {
            //TODO: handle exception
            out.println("Error while uploading your file");
        }
    }

    private String extractFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        String[] items = contentDisp.split(";");
        for (String s : items) {
            if (s.trim().startsWith("filename")) {
                return s.substring(s.indexOf("=") + 2, s.length()-1);
            }
        }
        return "";
    }
}
