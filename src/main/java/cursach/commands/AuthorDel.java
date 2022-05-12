package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class AuthorDel implements Command {
    private static final String LAST_NAME = "lastName";
    public final SQLPublishingHouse sqlPublishingHouse;

    public AuthorDel(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            sqlPublishingHouse.delAuthor(req.getParameter(LAST_NAME));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EnterData enterData = new EnterData();
        enterData.execute(req, resp);
    }
}
