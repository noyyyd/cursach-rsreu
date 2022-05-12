package cursach.datalayer;

import cursach.dto.Author;
import cursach.dto.Book;
import cursach.dto.Contract;
import cursach.providers.DBParameters;
import cursach.providers.QueriesProvider;
import cursach.providers.ResourceProvider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLPublishingHouse {
    private final String driverName;
    private final String url;
    private final String user;
    private final String password;

    public SQLPublishingHouse() {
        this.driverName = ResourceProvider.get(DBParameters.DB_DRIVER);
        this.url = ResourceProvider.get(DBParameters.DB_URL);
        this.user = ResourceProvider.get(DBParameters.DB_USER);
        this.password = ResourceProvider.get(DBParameters.DB_PASSWORD);
    }

    public void addNewBook(Book book) throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                QueriesProvider.get(DBParameters.NEW_BOOK));
        preparedStatement.setString(1, book.getID());
        preparedStatement.setString(2, book.getContractNumber());
        preparedStatement.setString(3, book.getTitle());
        preparedStatement.setString(4, book.getCirculation());
        preparedStatement.setString(5, book.getPrintDate());
        preparedStatement.setString(6, book.getCostPrice());
        preparedStatement.setString(7, book.getCost());
        preparedStatement.setString(8, book.getFee());
        preparedStatement.executeUpdate();

        connection.close();
    }

    public void addNewAuthor(Author author) throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                QueriesProvider.get(DBParameters.NEW_BOOK));
        preparedStatement.setString(1, author.getID());
        preparedStatement.setString(2, author.getLastName());
        preparedStatement.setString(3, author.getName());
        preparedStatement.setString(4, author.getPatronymic());
        preparedStatement.setString(5, author.getPhone());
        preparedStatement.setString(6, author.getPassportSeries());
        preparedStatement.setString(7, author.getPassportNumber());
        preparedStatement.setString(8, author.getEmail());
        preparedStatement.executeUpdate();

        connection.close();
    }

    public void addNewContract(Contract contract) throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                QueriesProvider.get(DBParameters.NEW_CONTRACT));
        preparedStatement.setString(1, contract.getID());
        preparedStatement.setString(2, contract.getDateOfConclusion());
        preparedStatement.setString(3, contract.getTerminationDate());
        preparedStatement.setString(4, contract.getTerm());
        preparedStatement.setString(5, contract.getStatus());
        preparedStatement.executeUpdate();

        connection.close();
    }

    public void delBook(String title) throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                QueriesProvider.get(DBParameters.DEL_BOOK));
        preparedStatement.setString(1, title);
        preparedStatement.executeUpdate();

        connection.close();
    }
    public void delAuthor(String lastName) throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                QueriesProvider.get(DBParameters.DEL_AUTHOR));
        preparedStatement.setString(1, lastName);
        preparedStatement.executeUpdate();

        connection.close();
    }

    public void delContract(String id) throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(
                QueriesProvider.get(DBParameters.DEL_CONTRACT));
        preparedStatement.setString(1, id);
        preparedStatement.executeUpdate();

        connection.close();
    }

    public ArrayList<Author> getAllAuthors() throws SQLException, ClassNotFoundException {
        ArrayList<Author> authors = new ArrayList<Author>();
        Connection connection = getNewConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                QueriesProvider.get(DBParameters.ALL_AUTHORS));
        while (resultSet.next()) {
            Author author = new Author(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));
            authors.add(author);
        }
        connection.close();

        return authors;
    }

    public ArrayList<Book> getAllBooks() throws SQLException, ClassNotFoundException {
        ArrayList<Book> books = new ArrayList<Book>();
        Connection connection = getNewConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                QueriesProvider.get(DBParameters.ALL_BOOKS));
        while (resultSet.next()) {
            Book book = new Book(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5),
                    resultSet.getString(6),
                    resultSet.getString(7),
                    resultSet.getString(8));
            books.add(book);
        }
        connection.close();

        return books;
    }

    public ArrayList<Contract> getAllContracts() throws SQLException, ClassNotFoundException {
        ArrayList<Contract> contracts = new ArrayList<Contract>();
        Connection connection = getNewConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                QueriesProvider.get(DBParameters.ALL_CONTRACTS));
        while (resultSet.next()) {
            Contract contract = new Contract(resultSet.getString(1),
                    resultSet.getString(2),
                    resultSet.getString(3),
                    resultSet.getString(4),
                    resultSet.getString(5));
            contracts.add(contract);
        }
        connection.close();

        return contracts;
    }

    public int getNumberNextAuthor() throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                QueriesProvider.get(DBParameters.COUNT_AUTHORS));
        resultSet.next();
        int ID = resultSet.getInt(1) + 1;
        connection.close();

        return ID;
    }

    public int getNumberNextBook() throws SQLException, ClassNotFoundException {
        Connection connection = getNewConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(
                QueriesProvider.get(DBParameters.COUNT_BOOKS));
        resultSet.next();
        int ID = resultSet.getInt(1) + 1;
        connection.close();

        return ID;
    }

    private Connection getNewConnection() throws ClassNotFoundException, SQLException {
        Class.forName(driverName);
        return DriverManager.getConnection(url, user, password);
    }
}
