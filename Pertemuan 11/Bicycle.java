/**
 *
 * @author Farrel Aqilla Novianto
 */
public class Bicycle extends Vehicle{
    private String jenisSepeda;
    
    public Bicycle(String merk, String model, int tahunProduksi, String jenisSepeda){
        super(merk, model, tahunProduksi);
        this.jenisSepeda = jenisSepeda;
    }
    
    public String getJenisSepeda(){
        return jenisSepeda;
    }
    
    public String getInfoDetail(){
        return String.format("Sepeda %s %s (%d) - Jenis: %s - Status: %s", merk, model, tahunProduksi, jenisSepeda, tersedia ? "Tersedia" : "Disewa");
    }
    
    public String getJenisKendaraan(){
        return "Sepeda";
    }
}