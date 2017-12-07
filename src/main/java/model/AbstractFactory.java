/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Tabul
 */
public class AbstractFactory {

    public AbstractFactory() {
    }
    
    public User userFactory(String username, String password, String name, String email, String akses){
        if (akses.equalsIgnoreCase("manajer")){
            return new Manajer(username, password, name, email, akses);
        }
        return null;
    }
    
    public Pegawai pegawaiFactory(String username, String password, String name, String email, String akses, long gaji){
        if (akses.equalsIgnoreCase("gudang")){
            return new Gudang(username, password, name, email, akses, gaji);
        }
        else if (akses.equalsIgnoreCase("kasir")){
            return new Kasir(username, password, name, email, akses, gaji);
        }
        else if (akses.equalsIgnoreCase("koordinator")){
            return new Koordinator(username, password, name, email, akses, gaji);
        }
        return null;
    }
}
