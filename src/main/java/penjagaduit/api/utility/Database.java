package penjagaduit.api.utility;

import java.sql.*;

//Specification
//Merupakan Class Database yang mengatur Tentang Koneksi dan Program Website dengan Database
//Require : Driver Database, Database Link, Database User, Database Password
//Process : Class ini dibuat dengan tujuan mengatur koneksi website dengan databse, CRUD ke/dari Database ke/dari Website
//Return : Website dapat melakukan Proses CRUD

public class Database {
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql//localhsot/fintech";
    static final String USER = "root";
    static final String PASS = "";

    static Connection conn;
    static Statement stmt;
    static ResultSet rs;

    //Specification -> Method : query
    //Merupakan Method yang bertujuan untuk menjalankan SQL pada database melalui Server Website
    //Require : Database Connection, Query Language
    //Process : Koneksi ke Database pada URL Menggunakan Driver dengan User & Password Akses Database -> Membuat Penyataan untuk proses eksekusi Query
    //          -> Eksekusi Query dan masukkan pada variabel rs
    //Return : variabel rs berisi hasil dari Query bertipe Result Set yang masih dapat dioperasikan lagi melalui objek pemanggil

    public ResultSet query(String SQL){
        try{
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL,USER,PASS);
            stmt = conn.createStatement();

            rs = stmt.executeQuery(SQL);

            } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    //Specification -> Method : close
    //Merupakan Method yang bertujuan untuk Menutup Konsksi Website ke database
    //Require : Database Connected
    //Process : Tutup koneksi pada stmt -> Tutup koneksi seutuhnya;
    //Return : Koneksi Database Tertutup

    public void close(){
        try {
            stmt.close();
            conn.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
