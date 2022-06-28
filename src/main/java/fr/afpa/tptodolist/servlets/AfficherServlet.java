package fr.afpa.tptodolist.servlets;

import fr.afpa.tptodolist.bo.Todo;
import fr.afpa.tptodolist.dal.ConnectionProvider;
import fr.afpa.tptodolist.dal.TodoSQL;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@WebServlet("/affichage")
public class AfficherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        TodoSQL todoSQL = new TodoSQL();
        ArrayList<Todo> todos = todoSQL.selectAll();
        request.setAttribute("todos", todos);
        request.getRequestDispatcher("WEB-INF/afficher.jsp").forward(request, response);
    }
}
