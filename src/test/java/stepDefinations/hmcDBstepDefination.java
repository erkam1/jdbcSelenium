package stepDefinations;

import io.cucumber.java.en.Given;

import java.sql.*;

public class hmcDBstepDefination {

    String url="jdbc:sqlserver://184.168.194.58:1433;databaseName=hotelmycamp ; user=techproed; password=P2s@rt65";
    String username="techproed";
    String password="P2s@rt65";

    Connection connection;
    Statement statement;
    ResultSet resultSet;

    @Given("kullanici HMC veri tabanina baglanir")
    public void kullanici_hmc_veri_tabanina_baglanir() throws SQLException {
        connection= DriverManager.getConnection(url,username,password);
        statement= connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);


    }
    @Given("kullanici {string} tablosundaki {string} verilerini alır")
    public void kullanici_tablosundaki_verilerini_alır(String table, String field) throws SQLException {
        String query="SELECT "+field+" FROM "+ table;
        resultSet=statement.executeQuery(query);
    }
    @Given("kullanici {string} stunundaki verileri okur")
    public void kullanici_stunundaki_verileri_okur(String field) throws SQLException {

        resultSet.first();
        System.out.println(resultSet.getString("Price"));
        resultSet.next();//ıterretore benzer şekilde çalısır imleci bir sonraki değerin yanına götürür
                         // TRUE ya da FALSE döner
        System.out.println(resultSet.getString("Price"));
        //ResutSet kullanırken çok dikkatli olmalıyız çünkü nerede olursa olsun imleci bir yana kaydırıcaktır

        System.out.println("=========================Liste============================");

        while (resultSet.next()){

            System.out.println(resultSet.getString("Price"));
        }


    }
}
