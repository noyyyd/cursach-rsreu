package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;
import cursach.dto.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BookAdd implements Command {
    private static final String CONTRACT_NUMBER = "contractNumber";
    private static final String TITLE = "title";
    private static final String CIRCULATION = "circulation";
    private static final String PRINT_DATE = "printDate";
    private static final String COST_PRICE = "costPrice";
    private static final String COST = "cost";
    private static final String FEE = "fee";
    private final SQLPublishingHouse sqlPublishingHouse;

    public BookAdd(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Book book = new Book(Integer.toString(sqlPublishingHouse.getNumberNextBook()),
                    req.getParameter(CONTRACT_NUMBER), req.getParameter(TITLE),
                    req.getParameter(CIRCULATION), req.getParameter(PRINT_DATE),
                    req.getParameter(COST_PRICE), req.getParameter(COST),
                    req.getParameter(FEE));
            sqlPublishingHouse.addNewBook(book);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EnterData enterData = new EnterData();
        enterData.execute(req, resp);
    }
}
