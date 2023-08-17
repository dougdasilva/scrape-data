package database;

import entities.ScrapePage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConnectDatabase {
    private String url;
    private String username;
    private String password;

    public ConnectDatabase(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public void saveToDatabase(ScrapePage scrapePage) {
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO scrape_page (id, session_url, created) VALUES (?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, scrapePage.getId());
            preparedStatement.setString(2, scrapePage.getSessionUrl());
            preparedStatement.setObject(3, scrapePage.getCreated());

            preparedStatement.executeUpdate();
            System.out.println("ScrapePage salvo no banco de dados!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
