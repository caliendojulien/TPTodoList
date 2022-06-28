package fr.afpa.tptodolist.servlets;

import fr.afpa.tptodolist.dal.ConnectionProvider;
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
        try {
            Connection connection = ConnectionProvider.getConnection();
            String saisieUtilisateur = request.getParameter("saisie");
            if (saisieUtilisateur != null) {
                PreparedStatement pstmt = connection.prepareStatement(
                        "INSERT INTO todo VALUES (?)"
                );
                pstmt.setString(1, saisieUtilisateur);
                pstmt.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        request.getRequestDispatcher("WEB-INF/ajouter.jsp").forward(request, response);
    }
}
