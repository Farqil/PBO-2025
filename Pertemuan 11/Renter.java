/**
 *
 * @author Farrel Aqilla Novianto
 */
public class Renter{
    private String nama;
    private String nomorKTP;
    private String nomorTelepon;
    private Vehicle kendaraanDisewa;
    
    public Renter(String nama, String nomorKTP, String nomorTelepon){
        this.nama = nama;
        this.nomorKTP = nomorKTP;
        this.nomorTelepon = nomorTelepon;
        this.kendaraanDisewa = null;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getNomorKTP(){
        return nomorKTP;
    }
    
    public String getNomorTelepon(){
        return nomorTelepon;
    }
    
    public Vehicle getKendaraanDisewa(){
        return kendaraanDisewa;
    }
    
    public boolean sewaKendaraan(Vehicle kendaraan){
        if(kendaraan.isTersedia() && this.kendaraanDisewa == null){
            this.kendaraanDisewa = kendaraan;
            kendaraan.setTersedia(false);
            return true;
        }
        return false;
    }
    
    public boolean kembalikanKendaraan(){
        if(this.kendaraanDisewa != null){
            this.kendaraanDisewa.setTersedia(true);
            this.kendaraanDisewa = null;
            return true;
        }
        return false;
    }
    
    public String getInfoLengkap(){
        String info = String.format("Nama: %s\nNo. KTP: %s\nTelepon: %s\n", nama, nomorKTP, nomorTelepon);
        if(kendaraanDisewa != null){
            info += "Kendaraan yang disewa:\n  " + kendaraanDisewa.getInfoDetail();
        }
        else{
            info += "Tidak ada kendaraan yang disewa";
        }
        return info;
    }
}