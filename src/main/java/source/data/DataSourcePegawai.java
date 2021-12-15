package source.data;

import pegawai.data.DataPegawai;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataSourcePegawai {

    public static final String TABLE_NAME= "pegawai";
    public static final String COLUMN_NIDN = "nidn";
    public static final String COLUMN_NAMA = "nama";
    public static final String COLUMN_GAJI = "gaji";
    public static final String COLUMN_STATUS = "status";

    Connection connection;

    public DataSourcePegawai() {
        try {
            this.connection = DriverManager.getConnection("jdbc:sqlite:database/db_pegawai.sql");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void createTable(){
        try {
            Statement statement = connection.createStatement();
            String query =
                    "CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" (id INTEGER PRIMARY KEY AUTOINCREMENT, "
                    +COLUMN_NIDN+" TEXT, " +COLUMN_NAMA+" TEXT, "+
                    COLUMN_GAJI+" TEXT, "+COLUMN_STATUS+" TEXT "+
                    ")";
            statement.execute(query);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void insertData(DataPegawai dataPegawai){
        PreparedStatement preparedStatement;
        String query = "INSERT INTO "+
                TABLE_NAME+" ("+COLUMN_NIDN+" ,"+COLUMN_NAMA+" ,"+COLUMN_GAJI+" ,"+
                COLUMN_STATUS+") VALUES (?,?,?,?);";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, dataPegawai.getNidn());
            preparedStatement.setString(2, dataPegawai.getNama());
            preparedStatement.setString(3, dataPegawai.getGaji());
            preparedStatement.setString(4, dataPegawai.getStatus());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateData(DataPegawai oldDataPegawai, DataPegawai newDataPegawai){
        PreparedStatement preparedStatement;
        String query = "UPDATE "+
                TABLE_NAME+" SET nidn = ?, nama = ?, gaji = ?, status = ? WHERE nidn = ? ;";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newDataPegawai.getNidn());
            preparedStatement.setString(2, newDataPegawai.getNama());
            preparedStatement.setString(3, newDataPegawai.getGaji());
            preparedStatement.setString(4, newDataPegawai.getStatus());
            preparedStatement.setString(5, oldDataPegawai.getNidn());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteData(DataPegawai nidnPegawai){
        PreparedStatement preparedStatement;
        String query = "DELETE FROM "+TABLE_NAME+" WHERE nidn = ? ";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nidnPegawai.getNidn());
            preparedStatement.execute();
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<DataPegawai> selectData(){

        List<DataPegawai> listDataPegawai = new ArrayList<>();

        PreparedStatement preparedStatement;

        String query = "SELECT * FROM "+TABLE_NAME+"";

        try {
            preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                DataPegawai item = new DataPegawai(
                        resultSet.getString("nidn"),
                        resultSet.getString("nama"),
                        resultSet.getString("gaji"),
                        resultSet.getString("status")
                );
                listDataPegawai.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDataPegawai;
    }

    public List<DataPegawai> selectDataByNidn(DataPegawai nidnPegawai){

        List<DataPegawai> listDataPegawai = new ArrayList<>();

        PreparedStatement preparedStatement;

        String query = "SELECT * FROM "+TABLE_NAME+" WHERE nidn = ?";

        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, nidnPegawai.getNidn());
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                DataPegawai item = new DataPegawai(
                        resultSet.getString("nidn"),
                        resultSet.getString("nama"),
                        resultSet.getString("gaji"),
                        resultSet.getString("status")
                );
                listDataPegawai.add(item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listDataPegawai;
    }
}
