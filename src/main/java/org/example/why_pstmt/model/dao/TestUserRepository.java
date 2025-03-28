package org.example.why_pstmt.model.dao;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.javapoet.ClassName;
import org.springframework.stereotype.Repository;

import javax.xml.transform.Result;
import java.sql.*;

@Repository
public class TestUserRepository {
    private final Connection connection;
    private Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

    public TestUserRepository() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 주의!
        String url = "jdbc:mysql://%s:%s/%s".formatted(
                dotenv.get("DB_HOST"),
                dotenv.get("DB_PORT"),
                dotenv.get("DB_DATABASE")
        );
        String username = dotenv.get("DB_USERNAME");
        String password = dotenv.get("DB_PASSWORD");
        connection = DriverManager.getConnection(url, username, password);
    }

    public void createTestUser(String username, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "INSERT INTO test_user (username, password) VALUES ('%s', '%s')".formatted(username, password);
        // executeUpdate VS executeQuery
        stmt.executeUpdate(sql);
    }

    public boolean login(String username, String password) throws SQLException {
        Statement stmt = connection.createStatement();
        String sql = "SELECT * FROM test_user WHERE username = '%s' and password = '%s'".formatted(username, password);
        ResultSet rs = stmt.executeQuery(sql);
        return rs.next();
    }
}
