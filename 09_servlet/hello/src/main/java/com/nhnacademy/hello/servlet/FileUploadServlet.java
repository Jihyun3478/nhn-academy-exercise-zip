package com.nhnacademy.hello.servlet;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 1, // 1MB
    maxFileSize      = 1024 * 1024 * 10, // 10MB
    maxRequestSize   = 1024 * 1024 * 100, // 100MB
    location = "./resources/upload"
)
@WebServlet(name = "fileUploadServlet", value = "/file-upload-servlet")
public class FileUploadServlet extends HttpServlet {
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String UPLOAD_DIR = "./resources/upload/target";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        for (Part part : req.getParts()) {
            String contentDisposition = part.getHeader(CONTENT_DISPOSITION);

            if (contentDisposition.contains("filename=")) {
                String fileName = extractFileName(contentDisposition);

                if (part.getSize() > 0) {
                    part.write(UPLOAD_DIR + File.separator + fileName);
                    part.delete();
                }
            } else {
                String formValue = req.getParameter(part.getName());
                log.error("{}={}", part.getName(), formValue);
            }
        }
        resp.sendRedirect("/");
    }

    private String extractFileName(String contentDisposition) {
        log.error("contentDisposition:{}", contentDisposition);
        for (String token : contentDisposition.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf("=")+2, token.length()-1);
            }
        }
        return null;
    }
}
