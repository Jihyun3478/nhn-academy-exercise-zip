package com.nhnacademy.hello.listener;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class ServletContextListener implements jakarta.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;
        String realFilePath = servletContext.getRealPath(counterFilePath);
        log.error("path:{}", realFilePath);

        File target = new File(realFilePath);

        if (target.exists()) {
            try (
                FileInputStream fileInputStream = new FileInputStream(target);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
                BufferedReader br = new BufferedReader(inputStreamReader)
            ) {
                long c = Long.parseLong(br.readLine());
                servletContext.setAttribute("counter", c);
            } catch (FileNotFoundException fe) {
                fe.printStackTrace();
            } catch (IOException ie) {
                ie.printStackTrace();
            }
        }
        log.error("init counter : {}", servletContext.getAttribute("counter"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext servletContext = sce.getServletContext();
        String counterFileName = servletContext.getInitParameter("counterFileName");
        String counterFilePath = "/WEB-INF/classes/" + counterFileName;
        String realFilePath = servletContext.getRealPath(counterFilePath);

        try (
            FileOutputStream fileOutputStream = new FileOutputStream(realFilePath);
            OutputStreamWriter out = new OutputStreamWriter(fileOutputStream);
            BufferedWriter fw = new BufferedWriter(out)
        ) {
            fw.write(String.valueOf(servletContext.getAttribute("counter")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("distroy-counter : " + servletContext.getAttribute("counter"));
    }
}
