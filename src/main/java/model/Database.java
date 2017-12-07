/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Tabul
 */
public class Database {
    private final String server = "jdbc:mysql://localhost:3306/ciisysoo";
    private final String dbuser = "root";
    private final String dbpass = "";
    private Statement statement = null;
    private Connection conn = null;
    
    private Database() {
    }
    
    public static Database getInstance() {
        return DatabaseHolder.INSTANCE;
    }
    
    private static class DatabaseHolder {
        private static final Database INSTANCE = new Database();
    }

    public Connection getConn() {
        return conn;
    }
    
    
    
    public void connect(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn = DriverManager.getConnection(server, dbuser, dbpass);
            this.statement = conn.createStatement();
        }
        catch (ClassNotFoundException | SQLException e){
            throw new IllegalArgumentException("Connection Error!");
        }
    }

    public Statement getStatement() {
        return statement;
    }

    
    
}
