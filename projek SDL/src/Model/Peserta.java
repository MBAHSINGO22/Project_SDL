package Model;

import java.io.Serializable;

public class Peserta implements Serializable {
    protected String nama;
    protected String noPendaftaran;

    public Peserta(String nama, String noPendaftaran) {
        this.nama = nama;
        this.noPendaftaran = noPendaftaran;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNoPendaftaran(String noPendaftaran) {
        this.noPendaftaran = noPendaftaran;
    }

    public String getNama() {
        return nama;
    }

    public String getNoPendaftaran() {
        return noPendaftaran;
    }
}
