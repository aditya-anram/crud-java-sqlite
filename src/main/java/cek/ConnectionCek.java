package cek;

import java.sql.*;

/**
 * Hello world!
 */
public class ConnectionCek {
    public static void main(String[] args) {

        System.out.println("CRUD DATA PEGAWAI\n");

        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:database/db_pegawai.sql");
            Statement statement = connection.createStatement();

            String query = "SELECT * FROM pegawai";
            statement.execute(query);

            ResultSet resultSet = statement.getResultSet();
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();

            int columnCount = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int i = 1; i <= columnCount; i++) {
                    if (i > 1) {
                        String value = resultSet.getString(i);
                        String column = resultSetMetaData.getColumnName(i);
                        System.out.println(column +" : "+ value);
                    }else if(i < 1){
                        System.out.println("Data Kosong");
                    }
                }
                System.out.println("");
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}