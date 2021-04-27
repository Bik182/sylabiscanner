package com.example.demo3;

import java.io.*;
import java.util.Collections;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EventServlet", value = "/EventServlet")
public class EventServlet extends HttpServlet {
    private String message;
    private Event event;
    public void init() {
        message = "This is the Event Servlet!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/event.jsp").forward(request,response);
        // Hello

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        getServletContext().getRequestDispatcher("/eventDisplay.jsp").forward(request,response);



        String date =request.getParameter("eventDate");
        String type =request.getParameter("eventType");
        String description =request.getParameter("eventDescription");
        Parser parser = new Parser();
        parser.insertNewEvent(date, type, description);


    }

    public void destroy() {
    }
}