package Model;

import java.io.Serializable; // Mengimpor interface Serializable untuk memungkinkan objek Sertifikat di-serialize

public class Sertifikat implements Serializable { // Deklarasi kelas Sertifikat yang mengimplementasikan interface Serializable
    private String prestasi; // Deklarasi variabel instance prestasi bertipe String
    private String tingkat; // Deklarasi variabel instance tingkat bertipe String
    private int juara; // Deklarasi variabel instance juara bertipe int

    public Sertifikat(String prestasi) { // Konstruktor Sertifikat yang menerima parameter prestasi bertipe String
        this.prestasi = prestasi; // Menginisialisasi variabel instance prestasi dengan nilai parameter prestasi
    }

    public void setPrestasi(String prestasi) { // Method setter untuk mengubah nilai prestasi
        this.prestasi = prestasi; // Menginisialisasi variabel instance prestasi dengan nilai parameter prestasi
    }

    public void setTingkat(String tingkat) { // Method setter untuk mengubah nilai tingkat
        this.tingkat = tingkat; // Menginisialisasi variabel instance tingkat dengan nilai parameter tingkat
    }

    public void setJuara(int juara) { // Method setter untuk mengubah nilai juara
        this.juara = juara; // Menginisialisasi variabel instance juara dengan nilai parameter juara
    }

    public String getPrestasi() { // Method getter untuk mendapatkan nilai prestasi
        return prestasi; // Mengembalikan nilai variabel instance prestasi
    }

    public String getTingkat() { // Method getter untuk mendapatkan nilai tingkat
        return tingkat; // Mengembalikan nilai variabel instance tingkat
    }

    public int getJuara() { // Method getter untuk mendapatkan nilai juara
        return juara; // Mengembalikan nilai variabel instance juara
    }
}
