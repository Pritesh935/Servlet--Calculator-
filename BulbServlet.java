package com.nit.pc.servlets;

import java.io.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class BulbServlet extends HttpServlet {
    private boolean isBulbOn = false;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<center");
        out.println("<html><head><title>Bulb Control</title></head><body>");
        out.println("<h1>Bulb is " + (isBulbOn ? "ON" : "OFF") + "</h1>");
        if (isBulbOn) {
            out.println("<img src='https://5.imimg.com/data5/WL/SG/MY-8835990/10w-gls-light-bulb.jpg' width='100'><br>");
        } else {
            out.println("<img src='https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQomsat2Dpj_IwEXnws87kzMJwtYoPOZcPnga8SVC1rzl7RDmEx0g7d_qUfMu5QlD0MROk&usqp=CAU' width='100'><br>");
        }
        out.println("<form method='post'>");
        if (isBulbOn) {
            out.println("<button type='submit' name='action' value='off'>Turn OFF</button>");
        } else {
            out.println("<button type='submit' name='action' value='on'>Turn ON</button>");
        }
        out.println("</form>");
        out.println("</center>");
        out.println("</body></html>");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if ("on".equals(action)) {
            isBulbOn = true;
        } else if ("off".equals(action)) {
            isBulbOn = false;
        }
        doGet(request, response);
    }
}
