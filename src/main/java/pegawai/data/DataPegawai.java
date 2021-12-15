package pegawai.data;

public class DataPegawai {

    public String nidn;
    public String nama;
    public String gaji;
    public String status;

    public DataPegawai(){}

    public DataPegawai(String nidn){
        this.nidn = nidn;
    }

    public DataPegawai(String nidn, String nama, String gaji, String status) {
        this.nidn = nidn;
        this.nama = nama;
        this.gaji = gaji;
        this.status = status;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGaji() {
        return gaji;
    }

    public void setGaji(String gaji) {
        this.gaji = gaji;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
