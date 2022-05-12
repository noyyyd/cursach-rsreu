package cursach.commands;

import cursach.datalayer.SQLPublishingHouse;
import cursach.dto.Book;
import cursach.dto.Contract;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;

public class ContractAdd implements Command {
    private static final String ID = "id";
    private static final String DATE_OF_CONCLUSION = "dateOfConclusion";
    private static final String TERMINATION_DATE = "terminationDate";
    private static final String TERM = "term";
    private static final String STATUS = "status";
    private final SQLPublishingHouse sqlPublishingHouse;

    public ContractAdd(){
        this.sqlPublishingHouse = new SQLPublishingHouse();
    }
    @Override
    public void execute(HttpServletRequest req, HttpServletResponse resp) {
        try {
            Contract contract = new Contract(req.getParameter(ID),
                    req.getParameter(DATE_OF_CONCLUSION), req.getParameter(TERMINATION_DATE),
                    req.getParameter(TERM), req.getParameter(STATUS));
            sqlPublishingHouse.addNewContract(contract);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        EnterData enterData = new EnterData();
        enterData.execute(req, resp);
    }
}
