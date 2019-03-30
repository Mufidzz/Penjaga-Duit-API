package penjagaduit.api.main;

import penjagaduit.api.controller.User;
import spark.Filter;
import spark.Request;
import spark.Response;
import spark.Spark;

import static spark.Spark.*;

public class Server {

    public Server(int port, int maxThrds, int minThrds, int Timeout){
        Spark.port(port);
        threadPool(maxThrds,minThrds,Timeout);

        path("/api",() -> {
            before("/*", (q, a) -> System.out.println("Recieved API Call"));
            path("/user", () -> {
                get("", (request, response) -> User.read());
                get("/:uid", (request, response) -> User.read(Integer.parseInt(request.params(":uid"))));
                post("", (request, response) -> User.create());
                put("", (request, response) -> User.update());
                delete("", (request, response) -> User.delete());
            });
        });

        apply();
    }

    public final static void apply(){
        Filter filter = new Filter(){

            @Override
            public void handle(Request request, Response response) throws Exception {
                response.type("application/json");
            }
        };
        Spark.after(filter);
    }
}
