/**
 *
 * @author Farrel Aqilla Novianto
 */
public class Vehicle{
    protected String merk;
    protected String model;
    protected int tahunProduksi;
    protected boolean tersedia;
    
    public Vehicle(String merk, String model, int tahunProduksi){
        this.merk = merk;
        this.model = model;
        this.tahunProduksi = tahunProduksi;
        this.tersedia = true;
    }
    
    public String getMerk(){
        return merk;
    }
    
    public String getModel(){
        return model;
    }
    
    public int getTahunProduksi(){
        return tahunProduksi;
    }
    
    public boolean isTersedia(){
        return tersedia;
    }
    
    public void setTersedia(boolean tersedia){
        this.tersedia = tersedia;
    }
    
    public String getInfoDetail(){
        return "";
    }
    
    public String getJenisKendaraan(){
        return "";
    }
}