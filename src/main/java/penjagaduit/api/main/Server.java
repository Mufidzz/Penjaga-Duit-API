package penjagaduit.api.main;

import penjagaduit.api.controller.User;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

import static spark.Spark.*;

//Specification
//Merupakan Class Server yang mengatur Pekerjaan yang seharusnya dilakukan oleh sebuah server pada Website
//Require : Spark Framework -> Filter, Request, Response
//Require : Spark Framework -> URL Path, URL Request Method
//Require : Class User -> CRUD
//Process : Class ini dibuat dengan tujuan mengatur isi URL Path, Mangatur kerja pada Path, Mendapatkan JSON untuk di parse di Class User
//Return : Path Terdaftar pada website, Isi Pada tiap-tiap path

public class Server {

    //Specification -> Method : Server
    //Merupakan Constructor dari Class Server
    //Require : Port, MaxThreads, MinThreads, Timeout
    //Process : Buka Port Menggunakan Spark -> Setting Thread pada Server -> Buat Objek User -> Buat Path & Handler -> Jalankan Method apply();
    //Return : Path Terfilter oleh Method apply(); dan URL path terhubung dengan Path Handlernya

    public Server(int port, int maxThrds, int minThrds, int Timeout){

        Spark.port(port);
        threadPool(maxThrds,minThrds,Timeout);

        User usr = new User();
        path("/api",() -> {
            before("/*", (request, response) -> System.out.println("Recieved API Call"));
            path("/user", () -> {

                get("", (request, response) -> usr.read());
                get("/:uid", (request, response) -> usr.read(Integer.parseInt(request.params(":uid"))));
                post("", (request, response) -> usr.create(request));
                put("", (request, response) -> usr.update(request));
                delete("", (request, response) -> usr.delete(request));
            });
        });

        apply();
    }

    //Specification -> Method : apply
    //Merupakan Method yang berfungsi Memfilter Request dan Menerapkan Response
    //Require : request & response (Pass by reference dari Method Server)
    //Process : Spark Filter memfilter Request -> Program Memberi Response dengan tipe JSON
    //Return : Clean JSON

    public final static void apply(){
        Filter filter = (request, response) -> response.type("application/json");
        Spark.after(filter);
    }
}
