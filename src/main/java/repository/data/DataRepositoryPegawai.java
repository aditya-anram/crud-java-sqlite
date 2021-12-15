package repository.data;

import pegawai.data.DataPegawai;
import source.data.DataSourcePegawai;

import java.util.List;

public class DataRepositoryPegawai {

    public DataSourcePegawai dataSource;

    public DataRepositoryPegawai(DataSourcePegawai dataSource) {
        this.dataSource = dataSource;
        System.out.println("Database Terkoneksi");
        this.dataSource.createTable();
    }

    public void insertDataPegawai(DataPegawai dataPegawai){
        dataSource.insertData(dataPegawai);
        System.out.println("Berhasil insert data pegawai");
    }

    public void updateDataPegawai(DataPegawai nidnPegawai, DataPegawai newDataPegawai){
        dataSource.updateData(nidnPegawai, newDataPegawai);
        System.out.println("Berhasil update data pegawai");
    }

    public void deleteDataPegawai(DataPegawai nidnPegawai){
        dataSource.deleteData(nidnPegawai);
        System.out.println("Berhasil delete data pegawai " + nidnPegawai.getNidn());
    }

    public List<DataPegawai> selectDataPegawai(){
        System.out.println("Berhasil select data pegawai");
        return dataSource.selectData();
    }

    public List<DataPegawai> selectDataPegawaiByNidn(DataPegawai nidnPegawai){
        System.out.println("Berhasil select data pegawai by nidn");
        return dataSource.selectDataByNidn(nidnPegawai);
    }
}
