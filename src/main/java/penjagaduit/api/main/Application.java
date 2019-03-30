package penjagaduit.api.main;

//Specification
//Merupakan Class Utama yang mengatur Alur Program
//Require : Class Server -> Port, Maximum Threads, Minimum Threads, Timeout Connection
//Process : Class ini akan Membuka Port pada Port x, dan meng-set Minimum Threads, Maximum Threads, dan Timeout Connection pada Website
//Return : Server Terbuka Pada Port x dan user dapat mengakses website melalui server ini

public class Application {
    public static void main(String[] args){
        try {
            new Server(8007, 30, 200, 20000);
            System.out.println("Program Running Without Error");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
