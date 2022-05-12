package cursach;

import cursach.datalayer.SQLPublishingHouse;
import cursach.dto.Author;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String url = "jdbc:sqlserver://DESKTOP-5LQO5UO;databaseName=Авторы";
        String user = "oleg";
        String password = "love";
        SQLPublishingHouse sqlPublishingHouse = new SQLPublishingHouse();
        Author author = new Author("11", "asdf", "asdf", "asdf", "asdf",
                "123", "123", "asdf");

        ArrayList<Author> aethor = null;
        try {
            sqlPublishingHouse.delAuthor("11");
            aethor = sqlPublishingHouse.getAllAuthors();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

        for (Author arg : aethor) {
            System.out.println(arg.toString());
        }
    }
}
