package com.example.examen.controlador;

import com.example.examen.modelo.GestorOperador;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "ServletListadoDeOperaciones", value = "/ServletListadoDeOperaciones")
public class ServletListadoDeOperaciones extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        GestorOperador gc = new GestorOperador();

        String[] operaciones=gc.listaDeOperaciones();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Listado de operaciones</h1>");
        out.println("<ul>");
        for (int i =0; i<operaciones.length;i++) {
            out.println("<li>"+operaciones[i]+"</li>");
        }
        out.println("</ul>");
        out.println(" <a href=\"menu.jsp\">Volver a inicio</a>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
