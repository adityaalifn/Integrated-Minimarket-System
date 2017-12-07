/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tabul
 */
public class Session {
    private static User manajer = null;
    private static Pegawai pegawai = null;
    
    private Session() {
    }
    
    public static Session getInstance() {
        return SessionHolder.INSTANCE;
    }
    
    private static class SessionHolder {

        private static final Session INSTANCE = new Session();
    }

    public static User getManajer() {
        return manajer;
    }

    public static Pegawai getPegawai() {
        return pegawai;
    }

    public static void setManajer(User manajer) {
        Session.manajer = manajer;
    }

    public static void setPegawai(Pegawai pegawai) {
        Session.pegawai = pegawai;
    }
    
    public void login(String username, String password){
        try {
            Database.getInstance().connect();
            AbstractFactory af = new AbstractFactory();
            String query = "SELECT * FROM user WHERE username='" + username + "' AND password='" + password + "'";
            Statement statement = Database.getInstance().getStatement();
            ResultSet rs = statement.executeQuery(query);
            rs.next();
            if ("manajer".equals(rs.getString("akses"))){
                System.out.println("a");
                Session.manajer = af.userFactory(username, password, rs.getString("nama"), rs.getString("email"), rs.getString("akses"));
                Session.pegawai = null;
            }
            else{
                System.out.println("b");
                Session.pegawai = af.pegawaiFactory(username, password, rs.getString("nama"), rs.getString("email"), rs.getString("akses"), rs.getLong("gaji"));
                Session.manajer = null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Session.class.getName()).log(Level.SEVERE, null, ex);
            throw new IllegalArgumentException("Error!");
        }
    }
}
