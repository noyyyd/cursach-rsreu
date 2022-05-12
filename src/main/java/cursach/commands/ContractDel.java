package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ContractDel implements Command {
    private static final String ID = "id";
    private final SQLPublishingHouse sqlPublishingHouse;

    public ContractDel(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }

    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            sqlPublishingHouse.delContract(req.getParameter(ID));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EnterData enterData = new EnterData();
        enterData.execute(req, resp);
    }
}
