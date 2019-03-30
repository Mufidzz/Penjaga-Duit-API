package penjagaduit.api.controller;

import penjagaduit.api.utility.Database;

public class User {
    static protected int uid;
    static protected String idTelegram;
    static protected String Nama;
    static protected String tanggalLahir;
    static protected String tempatTinggal;
    static protected String jenisKelamin;

    User(){

    }

    public static int create(){
        Database db = new Database();
        db.query("INSERT INTO `user` (`uid`, `idTelegram`, `nama`, `tanggalLahir`, `tempatTinggal`, `jenisKelamin`)" +
                " VALUES ('"+ uid +"', '"+idTelegram+"', '"+Nama+"', '"+tanggalLahir+"', '"+tempatTinggal+"', '"+jenisKelamin+"')"); // Query Insert
        return 200;
    }
    public static int read(){
        Database db = new Database();
        db.query("SELECT * FROM user"); // Query Read
        return 200;
    }
    public static int read(int uid){
        Database db = new Database();
        db.query("SELECT * FROM user WHERE `uid` = "+ uid ); // Query Read Where
        return 200;
    }
    public static int update(){
        Database db = new Database();
        db.query("UPDATE `user` SET " +
                "`uid` = '"+ uid +"', " +
                "`idTelegram` = '"+idTelegram+"', " +
                "`nama` = '"+Nama+"', " +
                "`tanggalLahir` = '"+tanggalLahir+"', " +
                "`tempatTinggal` = '"+tempatTinggal+"', " +
                "`jenisKelamin` = '"+jenisKelamin+"' " +
                "WHERE `user`.`uid` = "+uid); // Query Update
        return 200;
    }
    public static int delete(){
        Database db = new Database();
        db.query("DELETE FROM `user` WHERE `user`.`uid` = "+uid); // Query Dalete
        return 200;
    }
}
