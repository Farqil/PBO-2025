/**
 *
 * @author Farrel Aqilla Novianto
 */
public class Motorcycle extends Vehicle{
    private int jumlahRoda;
    
    public Motorcycle(String merk, String model, int tahunProduksi, int jumlahRoda){
        super(merk, model, tahunProduksi);
        this.jumlahRoda = jumlahRoda;
    }
    
    public int getJumlahRoda(){
        return jumlahRoda;
    }
    
    public String getInfoDetail(){
        return String.format("Motor %s %s (%d) - Roda: %d - Status: %s", merk, model, tahunProduksi, jumlahRoda, tersedia ? "Tersedia" : "Disewa");
    }
    
    public String getJenisKendaraan(){
        return "Motor";
    }
}