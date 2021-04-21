package controllers.servlets;

import jakarta.servlet.http.*;

import java.io.*;
import jakarta.servlet.*;

public class FileDownloadServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = "textFile.txt";
        String filePath = "C:\\files\\";

        response.setContentType("APPLICATION/OCTET-STREAM");
        response.setHeader("Content-Disposition","attachment; filename=\"" + fileName + "\"");
        PrintWriter out = response.getWriter();
        FileInputStream fileInputStream = new FileInputStream(filePath + fileName);

        int i;
        while((i = fileInputStream.read()) != -1) {
            out.write(i);
        }

        fileInputStream.close();
        out.close();
    }
}
