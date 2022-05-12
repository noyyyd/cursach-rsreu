package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;
import cursach.dto.Author;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AuthorAdd implements Command {
    private static final String LAST_NAME = "lastName";
    private static final String NAME = "name";
    private static final String PATRONYMIC = "patronymic";
    private static final String PHONE = "phone";
    private static final String PASSPORT_SERIES = "passportSeries";
    private static final String PASSPORT_NUMBER = "passportNumber";
    private static final String EMAIL = "email";
    public final SQLPublishingHouse sqlPublishingHouse;

    public AuthorAdd(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Author author = new Author(Integer.toString(sqlPublishingHouse.getNumberNextAuthor()),
                    req.getParameter(LAST_NAME), req.getParameter(NAME),
                    req.getParameter(PATRONYMIC), req.getParameter(PHONE),
                    req.getParameter(PASSPORT_SERIES), req.getParameter(PASSPORT_NUMBER),
                    req.getParameter(EMAIL));
            sqlPublishingHouse.addNewAuthor(author);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EnterData enterData = new EnterData();
        enterData.execute(req, resp);
    }
}
