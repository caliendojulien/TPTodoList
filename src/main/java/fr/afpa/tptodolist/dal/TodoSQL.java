package fr.afpa.tptodolist.dal;

import fr.afpa.tptodolist.bo.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoSQL {

    private final String INSERT = "INSERT INTO todo VALUES (?)";
    private final String SELECT = "SELECT sasie FROM todo";

    public void insert(String saisieUtilisateur) {
        try {
            Connection connection = ConnectionProvider.getConnection();
            if (saisieUtilisateur != null) {
                PreparedStatement pstmt = connection.prepareStatement(INSERT);
                pstmt.setString(1, saisieUtilisateur);
                pstmt.executeUpdate();
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ArrayList<Todo> selectAll() {
        ArrayList<Todo> todos = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt = connection.prepareStatement(SELECT);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Todo todo = new Todo(rs.getString("sasie"));
                todos.add(todo);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }
}
