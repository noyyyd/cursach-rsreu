package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class BookDel implements Command {
    private static final String TITLE = "title";
    private final SQLPublishingHouse sqlPublishingHouse;

    public BookDel(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            sqlPublishingHouse.delBook(req.getParameter(TITLE));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EnterData enterData = new EnterData();
        enterData.execute(req, resp);
    }
}
