package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;
import cursach.dto.Author;
import cursach.dto.Book;
import cursach.dto.Contract;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class EnterData implements Command {
    private static final String BOOKS = "books";
    private static final String CONTRACTS = "contracts";
    private static final String AUTHORS = "authors";
    private static final String CHAT_PATH = "/index.jsp";
    public final SQLPublishingHouse sqlPublishingHouse;

    public EnterData(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        List<Author> authors = null;
        List<Book> books = null;
        List<Contract> contracts = null;
        try {
            authors = sqlPublishingHouse.getAllAuthors();
            books = sqlPublishingHouse.getAllBooks();
            contracts = sqlPublishingHouse.getAllContracts();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        req.getServletContext().setAttribute(AUTHORS, authors);
        req.getServletContext().setAttribute(BOOKS, books);
        req.getServletContext().setAttribute(CONTRACTS, contracts);
        ServletContext servletContext = req.getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(CHAT_PATH);
        try {
            requestDispatcher.forward(req, resp);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }
}
