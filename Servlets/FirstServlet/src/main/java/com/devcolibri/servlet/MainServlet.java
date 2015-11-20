package com.devcolibri.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Lucky on 02.07.2015.
 */

 @WebServlet("/s")
public class MainServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
    {
        PrintWriter out = resp.getWriter();
        out.print("<h1>Hello WORLD!</h1>");

        req.setAttribute("name", "Don Corleone 3");
        req.getRequestDispatcher("mypage.jsp").forward(req, resp);


    }
}
