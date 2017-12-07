/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package driver;

import controller.Controller;
import java.awt.Desktop;
import java.io.File;
import model.Database;

/**
 *
 * @author Tabul
 */
public class Driver {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database.getInstance().connect();
        Controller controller = new Controller();
    }
    
}
