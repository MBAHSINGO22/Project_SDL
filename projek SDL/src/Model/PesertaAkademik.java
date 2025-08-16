package Model;

public class PesertaAkademik extends Peserta {
    private double nilaiBahasaIndonesia;
    private double nilaiMatematika;
    private double nilaiIpa;
    private double nilaiBahasaInggris;

    public PesertaAkademik(String nama, String noPendaftaran) {
        super(nama, noPendaftaran);
    }

    public double getNilaiBahasaIndonesia() {
        return nilaiBahasaIndonesia;
    }

    public void setNilaiMatematika(double nilaiMatematika) {
        this.nilaiMatematika = nilaiMatematika;
    }

    public void setNilaiIpa(double nilaiIpa) {
        this.nilaiIpa = nilaiIpa;
    }

    public void setNilaiBahasaInggris(double nilaiBahasaInggris) {
        this.nilaiBahasaInggris = nilaiBahasaInggris;
    }

    public double getNilaiMatematika() {
        return nilaiMatematika;
    }

    public double getNilaiIpa() {
        return nilaiIpa;
    }

    public double getNilaiBahasaInggris() {
        return nilaiBahasaInggris;
    }

    public void setNilaiBahasaIndonesia(double nilaiBahasaIndonesia) {
        this.nilaiBahasaIndonesia = nilaiBahasaIndonesia;
    }

}
