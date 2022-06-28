package fr.afpa.tptodolist.dal;

import fr.afpa.tptodolist.bo.Todo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TodoSQL {
    public ArrayList<Todo> selectAll() {
        ArrayList<Todo> todos = new ArrayList<>();
        try {
            Connection connection = ConnectionProvider.getConnection();
            PreparedStatement pstmt= connection.prepareStatement(
                    "SELECT sasie FROM todo"
            );
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Todo todo= new Todo(rs.getString("sasie"));
                todos.add(todo);
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return todos;
    }
}
