package Control;

import Model.*;
import java.util.ArrayList;

public class DataHandle {
    public DataHandle() {

    }

    public String[] getDataPeserta(Peserta peserta) {
        if (peserta instanceof PesertaAkademik) {
            PesertaAkademik pst = (PesertaAkademik) peserta;
            String[] data = { pst.getNoPendaftaran(), pst.getNama(), String.valueOf(pst.getNilaiMatematika()),
                    String.valueOf(pst.getNilaiIpa()), String.valueOf(pst.getNilaiBahasaIndonesia()),
                    String.valueOf(pst.getNilaiBahasaInggris()), String.valueOf(hitungRata(pst)),
                    cekLulus(hitungRata(pst)) };
            return data;
        } else {
            PesertaNonAkademik pst = (PesertaNonAkademik) peserta;
            ArrayList<String> data = new ArrayList<String>();
            data.add(pst.getNoPendaftaran());
            data.add(pst.getNama());
            for (Sertifikat sertif : pst.getSertifikat()) {
                data.add(sertif.getPrestasi());
                data.add(sertif.getTingkat());
                data.add(String.valueOf(sertif.getJuara()));
            }
            data.add(cekLulus(konversiSertif(pst)));
            String[] data2 = new String[data.size()];
            data2 = data.toArray(data2);
            return data2;
        }
    }

    public int binarySearch(ArrayList<Peserta> array, String key) {
        int start = 0;
        int end = array.size() - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            Peserta Mid = array.get(mid);
            int compare = ((Comparable<String>) Mid.getNoPendaftaran()).compareTo(key);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int sequentialSearch(ArrayList<Peserta> array, String key) {
        for (int i = 0; i < array.size(); i++) {
            Peserta peserta = array.get(i);
            if (peserta.getNoPendaftaran().compareTo(key) == 0) {
                return i;
            }
        }
        return -1;
    }

    public double hitungRata(PesertaAkademik peserta) {
        return (peserta.getNilaiBahasaIndonesia() + peserta.getNilaiBahasaInggris() + peserta.getNilaiIpa()
                + peserta.getNilaiMatematika()) / 4;
    }

    public double konversiSertif(PesertaNonAkademik peserta) { // Method public untuk mengonversi sertifikat peserta non-akademik menjadi nilai bobot
        double bobot = 0; // Inisialisasi variabel bobot dengan nilai awal 0
        for (Sertifikat sertif : peserta.getSertifikat()) { // Iterasi melalui setiap sertifikat yang dimiliki oleh peserta
            if (sertif.getTingkat().equals("Internasional")) { // Jika tingkat sertifikat adalah Internasional
                if (sertif.getJuara() == 1) { // Jika juara adalah 1
                    bobot += 60; // Tambahkan 60 ke bobot
                } else if (sertif.getJuara() == 2) { // Jika juara adalah 2
                    bobot += 55; // Tambahkan 55 ke bobot
                } else { // Jika juara bukan 1 atau 2
                    bobot += 50; // Tambahkan 50 ke bobot
                }
            } else if (sertif.getTingkat().equals("Nasional")) { // Jika tingkat sertifikat adalah Nasional
                if (sertif.getJuara() == 1) { // Jika juara adalah 1
                    bobot += 45; // Tambahkan 45 ke bobot
                } else if (sertif.getJuara() == 2) { // Jika juara adalah 2
                    bobot += 40; // Tambahkan 40 ke bobot
                } else { // Jika juara bukan 1 atau 2
                    bobot += 35; // Tambahkan 35 ke bobot
                }
            } else if (sertif.getTingkat().equals("Provinsi")) { // Jika tingkat sertifikat adalah Provinsi
                if (sertif.getJuara() == 1) { // Jika juara adalah 1
                    bobot += 30; // Tambahkan 30 ke bobot
                } else if (sertif.getJuara() == 2) { // Jika juara adalah 2
                    bobot += 25; // Tambahkan 25 ke bobot
                } else { // Jika juara bukan 1 atau 2
                    bobot += 20; // Tambahkan 20 ke bobot
                }
            } else { // Jika tingkat sertifikat bukan Internasional, Nasional, atau Provinsi
                if (sertif.getJuara() == 1) { // Jika juara adalah 1
                    bobot += 15; // Tambahkan 15 ke bobot
                } else if (sertif.getJuara() == 2) { // Jika juara adalah 2
                    bobot += 10; // Tambahkan 10 ke bobot
                } else { // Jika juara bukan 1 atau 2
                    bobot += 5; // Tambahkan 5 ke bobot
                }
            }
        }
        return bobot; // Mengembalikan nilai total bobot
    }
    
    public String cekLulus(double nilaiFinal) {
        double standarLulus = 82.5;
        if (nilaiFinal >= standarLulus) {
            return "Lolos";
        } else if (nilaiFinal < standarLulus) {
            return "Tidak Lolos";
        }
        return null;
    }
}
