package fr.afpa.tptodolist.servlets;

import fr.afpa.tptodolist.dal.ConnectionProvider;
import fr.afpa.tptodolist.dal.TodoSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "AjouterServlet", value = "/ajouter")
public class AjouterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoSQL todoSQL = new TodoSQL();
        String saisieUtilisateur = request.getParameter("saisie");
        todoSQL.insert(saisieUtilisateur);
        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }
}
