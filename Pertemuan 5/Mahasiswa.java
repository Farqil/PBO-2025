/**
 *
 * @author Farrel Aqilla Novianto
 */
import java.util.ArrayList;

public class Mahasiswa{
    String nama;
    String nim;
    ArrayList<MataKuliah> matkulDiambil = new ArrayList<>();

    public Mahasiswa(String namaInput, String nimInput){
        nama = namaInput;
        nim = nimInput;
    }

    public void ambilMatkul(MataKuliah mk){
        for(MataKuliah m : matkulDiambil){
            if(m.namaMK.equals(mk.namaMK)){
                System.out.println("Kamu sudah mengambil mata kuliah " + mk.namaMK);
                return;
            }
        }
        if(mk.kuota > 0){
            matkulDiambil.add(mk);
            mk.kuota--;
            System.out.println("Berhasil mengambil " + mk.namaMK);
        }
        else{
            System.out.println("Mata kuliah " + mk.namaMK + " sudah penuh!");
        }
    }

    public void dropMatkul(String namaMK){
        for(MataKuliah m : matkulDiambil){
            if(m.namaMK.equals(namaMK)){
                matkulDiambil.remove(m);
                m.kuota++;
                System.out.println("Berhasil drop mata kuliah " + namaMK);
                return;
            }
        }
        System.out.println("Mata kuliah " + namaMK + " tidak ditemukan di FRS kamu!");
    }

    public void tampilkanFRS(){
        System.out.println("\nFRS Mahasiswa " + nama + " (" + nim + "):");
        if(matkulDiambil.isEmpty()){
            System.out.println("Belum mengambil mata kuliah");
        }
        else{
            for(MataKuliah mk : matkulDiambil){
                System.out.println("- " + mk.namaMK + " (Dosen: " + mk.dosen.nama + ")");
            }
        }
    }
}