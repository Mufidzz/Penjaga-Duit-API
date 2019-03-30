package penjagaduit.api.controller;

import org.json.JSONObject;
import penjagaduit.api.utility.Database;
import spark.Request;

//Specification
//Merupakan Class User yang mengatur Tentang Pengoperasian Tabel user pada Database
//Require : Class Database, JSON
//Process : Class ini dibuat dengan tujuan mengatur Tabel User utamanya pada proses CRUD
//Return : Tabel User memiliki kemampuan memproses CRUD

public class User {
    protected int uid;
    protected String idTelegram;
    protected String Nama;
    protected String tanggalLahir;
    protected String tempatTinggal;
    protected String jenisKelamin;

    //Specification -> Method : parseJson
    //Merupakan Method yang bertujuan untuk Mengambil dan Memecah JSON agar dapat disimpan pada Variabel
    //Require : Request Body as JSON
    //Process : Mengabil isi dari Request Body -> Pecah isi json -> simpan isi json dalam variabel
    //Return : Variabel Global terisi

    private void parseJson(Request req) {
        JSONObject obj = new JSONObject(req.body());

        this.uid = Integer.parseInt(obj.getString("uid"));
        this.idTelegram = obj.getString("idTelegram");
        this.Nama = obj.getString("nama");
        this.tanggalLahir = obj.getString("tanggalLahir");
        this.tempatTinggal = obj.getString("tempatTinggal");
        this.jenisKelamin = obj.getString("jenisKelamin");
    }


    //Specification -> Method : create
    //Merupakan Method yang bertujuan untuk Membuat Data Baru pada tabel User
    //Require : Request Body as JSON, Database Object
    //Process : Mengabil isi dari Request Body -> jalankan method parseJson(); -> Jalankan Method Query Melalui Objek Database -> tutup koneksi Databse
    //Return : 200 if success, 400 if not success and tabel user terisi data baru

    public int create(Request req){
        parseJson(req);

        try {
            Database db = new Database();
            db.query("INSERT INTO `user` (`uid`, `idTelegram`, `nama`, `tanggalLahir`, `tempatTinggal`, `jenisKelamin`)" +
                    " VALUES ('" + this.uid + "', '" + this.idTelegram + "', '" + this.Nama + "', '" + this.tanggalLahir + "', '" + this.tempatTinggal + "', '" + this.jenisKelamin + "')"); // Query Insert
            db.close();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            return 400;
        }
    }

    //Specification -> Method : read
    //Merupakan Method yang bertujuan untuk Membaca Seluruh Data pada tabel User
    //Require : Database Object
    //Process : Jalankan Method Query Melalui Objek Database -> tutup koneksi Databse
    //Return : 200 if success, 400 if not success and Website mendapat masukan JSON


    public int read(){
        try {
            Database db = new Database();
            db.query("SELECT * FROM user"); // Query Read
            db.close();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            return 400;
        }
    }

    //Specification -> Method : read w/ argument
    //Merupakan Method yang bertujuan untuk Membaca satu Data pada tabel User
    //Require : uid, Database Object
    //Process : Mengabil isi dari parameter get -> Jalankan Method Query Melalui Objek Database -> tutup koneksi Databse
    //Return : 200 if success, 400 if not success and Website mendapat masukan JSON

    public int read(int uid){
        try {
            Database db = new Database();
            db.query("SELECT * FROM user WHERE `uid` = " + uid); // Query Read Where
            db.close();
            return 200;
        } catch (Exception e){
            e.printStackTrace();
            return 400;
        }
    }

    //Specification -> Method : update
    //Merupakan Method yang bertujuan untuk memperbarui Data Baru pada tabel User
    //Require : Request Body as JSON, Database Object
    //Process : Mengabil isi dari Request Body -> jalankan method parseJson(); -> Jalankan Method Query Melalui Objek Database -> tutup koneksi Databse
    //Return : 200 if success, 400 if not success and tabel user dengan uid x terupdate

    public int update(Request req){
        parseJson(req);

        try {
            Database db = new Database();
            db.query("UPDATE `user` SET " +
                    "`uid` = '" + this.uid + "', " +
                    "`idTelegram` = '" + this.idTelegram + "', " +
                    "`nama` = '" + this.Nama + "', " +
                    "`tanggalLahir` = '" + this.tanggalLahir + "', " +
                    "`tempatTinggal` = '" + this.tempatTinggal + "', " +
                    "`jenisKelamin` = '" + this.jenisKelamin + "' " +
                    "WHERE `user`.`uid` = " + this.uid); // Query Update
            db.close();
            return 200;
        } catch (Exception e) {
            e.printStackTrace();
            return 400;
        }
    }

    //Specification -> Method : delete
    //Merupakan Method yang bertujuan untuk Menghapus Data pada tabel User
    //Require : Request Body as JSON, Database Object
    //Process : Mengabil isi dari Request Body -> jalankan method parseJson(); -> Jalankan Method Query Melalui Objek Database -> tutup koneksi Databse
    //Return : 200 if success, 400 if not success and tabel user dengan uid x terupdate

    public int delete(Request req){
        parseJson(req);

        try {
            Database db = new Database();
            db.query("DELETE FROM `user` WHERE `user`.`uid` = " + this.uid); // Query Dalete
            db.close();
            return 200;
        }catch (Exception e){
            e.printStackTrace();
            return 400;
        }
    }
}
