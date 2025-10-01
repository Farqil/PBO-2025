/**
 *
 * @author Farrel Aqilla Novianto
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        Dosen pakDwi = new Dosen("Pak Dwi", "12345");
        Dosen pakIrfan = new Dosen("Pak Irfan", "67890");

        ArrayList<MataKuliah> daftarMK = new ArrayList<>();
        daftarMK.add(new MataKuliah("Struktur Data (A)", 3, pakDwi));
        daftarMK.add(new MataKuliah("Pemrograman Web (D)", 5, pakIrfan));

        System.out.print("Masukkan nama mahasiswa: ");
        String namaMhs = sc.nextLine();
        System.out.print("Masukkan NRP mahasiswa: ");
        String nimMhs = sc.nextLine();
        Mahasiswa mhs = new Mahasiswa(namaMhs, nimMhs);

        int pilihan;
        do{
            System.out.println("\n=== SISTEM FRS ===");
            System.out.println("1. Info Mata Kuliah");
            System.out.println("2. Ambil Mata Kuliah");
            System.out.println("3. Drop Mata Kuliah");
            System.out.println("4. Tampilkan FRS");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch(pilihan){
                case 1:
                    System.out.println("\n--- INFO MATA KULIAH ---");
                    for(int i = 0; i < daftarMK.size(); i++){
                        MataKuliah mk = daftarMK.get(i);
                        System.out.println((i+1) + ". " + mk.namaMK + " | Dosen: " + mk.dosen.nama + " | Kuota tersisa: " + mk.kuota);
                    }
                    break;

                case 2:
                    System.out.println("\nPilih mata kuliah untuk diambil:");
                    for(int i = 0; i < daftarMK.size(); i++){
                        MataKuliah mk = daftarMK.get(i);
                        System.out.println((i+1) + ". " + mk.namaMK + " (Kuota: " + mk.kuota + ")");
                    }
                    int pilihMK = sc.nextInt();
                    sc.nextLine();
                    if(pilihMK > 0 && pilihMK <= daftarMK.size()){
                        mhs.ambilMatkul(daftarMK.get(pilihMK-1));
                    }
                    else{
                        System.out.println("Pilihan tidak valid!");
                    }
                    break;

                case 3:
                    if(mhs.matkulDiambil.isEmpty()){
                        System.out.println("Belum ada mata kuliah yang diambil");
                        break;
                    }
                
                    System.out.println("\n--- Mata Kuliah yang sudah diambil ---");
                    for(int i = 0; i < mhs.matkulDiambil.size(); i++){
                        MataKuliah mkDrop = mhs.matkulDiambil.get(i);
                        System.out.println((i+1) + ". " + mkDrop.namaMK + " (Dosen: " + mkDrop.dosen.nama + ")");
                    }
                
                    System.out.print("\nPilih nomor mata kuliah yang ingin didrop: ");
                    int dropIdx = sc.nextInt();
                    sc.nextLine();
                
                    if(dropIdx > 0 && dropIdx <= mhs.matkulDiambil.size()){
                        MataKuliah mkDrop = mhs.matkulDiambil.get(dropIdx-1);
                        mhs.dropMatkul(mkDrop.namaMK);
                    }
                    else{
                        System.out.println("Pilihan tidak valid!");
                    }
                    break;
                    
                case 4:
                    mhs.tampilkanFRS();
                    break;

                case 0:
                    System.out.println("Keluar dari sistem...");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
        while(pilihan != 0);
        sc.close();
    }
}