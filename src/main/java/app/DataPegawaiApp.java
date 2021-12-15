package app;

import pegawai.data.DataPegawai;
import repository.data.DataRepositoryPegawai;
import source.data.DataSourcePegawai;

import java.util.List;

public class DataPegawaiApp {
    public static void main(String[] args) {

        DataSourcePegawai dataSourcePegawai = new DataSourcePegawai();
        DataRepositoryPegawai dataRepositoryPegawai = new DataRepositoryPegawai(dataSourcePegawai);

        DataPegawai pegawaiA = new DataPegawai();

        pegawaiA.setNidn("2020880003");
        pegawaiA.setNama("John Doe");
        pegawaiA.setGaji("5.000.000");
        pegawaiA.setStatus("Pegawai Tetap");

        //INSERT
        dataRepositoryPegawai.insertDataPegawai(pegawaiA);

        //UPDATE
        DataPegawai updateDataPegawaiA = new DataPegawai("20200880001", "John Doe", "7.000.000", "Pegawai Tetap");
        dataRepositoryPegawai.updateDataPegawai(pegawaiA, updateDataPegawaiA);

        //DELETE
        DataPegawai deletDataPegawai = new DataPegawai();
        deletDataPegawai.setNidn("20200880002");
        dataRepositoryPegawai.deleteDataPegawai(deletDataPegawai);

        //SELECT ALL
        List<DataPegawai> listDataPegawai = dataRepositoryPegawai.selectDataPegawai();
        for (DataPegawai item : listDataPegawai) {
            System.out.println(item.getNidn()+" | "+item.getNama()+" | "+ item.getGaji()+" | "+item.getStatus());
        }

        //SELECT BY NIDN
        List<DataPegawai> dataPegawaiByNidn = dataRepositoryPegawai.selectDataPegawaiByNidn(pegawaiA);
        for (DataPegawai item : dataPegawaiByNidn) {
            System.out.println(item.getNidn()+" | "+item.getNama()+" | "+ item.getGaji()+" | "+item.getStatus());
        }
    }
}