package com.example.examen.controlador;

import com.example.examen.modelo.GestorOperador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletCalculadora", value = "/ServletCalculadora")
public class ServletCalculadora extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        String num1=request.getParameter("pnum");
        String num2=request.getParameter("snum");
        String oper=request.getParameter("operador");
        GestorOperador gc = new GestorOperador();


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h3>El resultado es:</h3>");
        out.println("<ul>");



        out.println("<li>El resultado de la operacion ");
        out.println("<b>"+gc.MostrarOperacion(oper)+"</b>");
        out.println("es: "+gc.calculaRdo(oper,num1,num2)+"</li><br>");
        out.println("</ul>");
        out.println(" <a href=\"menu.jsp\">Volver a inicio</a>");

        out.println("</body></html>");
    }
    }
