package Model;
import java.util.ArrayList;

public class PesertaNonAkademik extends Peserta {
    private ArrayList<Sertifikat> sertifikat;

    public PesertaNonAkademik(String nama, String noPendaftaran){
        super(nama, noPendaftaran);
        sertifikat = new ArrayList<>();
    }

    public void addSertifikat(Sertifikat sertif) {
        sertifikat.add(sertif);
    }

    public ArrayList<Sertifikat> getSertifikat() {
        return sertifikat;
    }

    public void setSertifikat(ArrayList<Sertifikat> sertifikat) {
        this.sertifikat = sertifikat;
    }    
}
