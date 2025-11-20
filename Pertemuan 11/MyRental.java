/**
 *
 * @author Farrel Aqilla Novianto
 */
import java.util.ArrayList;
import java.util.Scanner;

public class MyRental{
    private static ArrayList<Vehicle> daftarKendaraan = new ArrayList<>();
    private static ArrayList<Renter> daftarPenyewa = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        inisialisasiData();
        boolean running = true;
        while(running){
            tampilkanMenuUtama();
            int pilihan = inputAngka("Pilih menu: ");
            switch(pilihan){
                case 1:
                    tampilkanDaftarKendaraan();
                    break;
                case 2:
                    tampilkanDaftarPenyewa();
                    break;
                case 0:
                    System.out.println("\nTerima kasih telah menggunakan myRental!");
                    running = false;
                    break;
                default:
                    System.out.println("\nPilihan tidak valid!");
            }
        } 
        scanner.close();
    }
    
    private static void inisialisasiData(){
        daftarKendaraan.add(new Car("Toyota", "Avanza", 2022, 4));
        daftarKendaraan.add(new Car("Honda", "Civic", 2021, 4));
        daftarKendaraan.add(new Car("Suzuki", "Ertiga", 2023, 4));
        
        daftarKendaraan.add(new Motorcycle("Yamaha", "NMAX", 2023, 2));
        daftarKendaraan.add(new Motorcycle("Honda", "Vario 160", 2022, 2));
        daftarKendaraan.add(new Motorcycle("Suzuki", "GSX-R150", 2021, 2));
        
        daftarKendaraan.add(new Bicycle("Polygon", "Xtrada", 2023, "Gunung"));
        daftarKendaraan.add(new Bicycle("United", "Clovis", 2022, "BMX"));
        daftarKendaraan.add(new Bicycle("Wimcycle", "Roadtech", 2023, "Balap"));
        
        Renter penyewa1 = new Renter("Budi Santoso", "3201234567890123", "081234567890");
        Renter penyewa2 = new Renter("Siti Nurhaliza", "3301234567890456", "082345678901");
        Renter penyewa3 = new Renter("Ahmad Fadli", "3501234567890789", "083456789012");
        
        penyewa1.sewaKendaraan(daftarKendaraan.get(1));
        penyewa2.sewaKendaraan(daftarKendaraan.get(4));
        penyewa3.sewaKendaraan(daftarKendaraan.get(7));
        
        daftarPenyewa.add(penyewa1);
        daftarPenyewa.add(penyewa2);
        daftarPenyewa.add(penyewa3);
    }
    
    private static void tampilkanMenuUtama(){
        System.out.println("\n=== myRental ===");
        System.out.println("1. Tampilkan Daftar Kendaraan");
        System.out.println("2. Tampilkan Daftar Penyewa");
        System.out.println("0. Keluar");
    }
    
    private static void tampilkanDaftarKendaraan(){
        System.out.println("\n=== Daftar Kendaraan ===");
        if(daftarKendaraan.isEmpty()){
            System.out.println("Tidak ada kendaraan dalam sistem.");
            return;
        }
        int nomor = 1;
        for(Vehicle kendaraan : daftarKendaraan){
            System.out.printf("%d. %s\n", nomor++, kendaraan.getInfoDetail());
        }
    }
    
    private static void tampilkanDaftarPenyewa(){
        System.out.println("\n=== Daftar Penyewa ===");
        if(daftarPenyewa.isEmpty()){
            System.out.println("Belum ada penyewa terdaftar.");
            return;
        }
        for(int i = 0; i < daftarPenyewa.size(); i++){
            System.out.println("\n" + (i + 1) + ". " + daftarPenyewa.get(i).getInfoLengkap());
            System.out.println("---");
        }
    }
    
    private static int inputAngka(String prompt){
        while(true){
            try{
                System.out.print(prompt);
                int angka = Integer.parseInt(scanner.nextLine());
                return angka;
            }
            catch(NumberFormatException e){
                System.out.println("Input harus berupa angka!");
            }
        }
    }
}