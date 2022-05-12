package cursach.servlet;

import cursach.commands.AuthorAdd;
import cursach.commands.AuthorDel;
import cursach.commands.BookAdd;
import cursach.commands.BookDel;
import cursach.commands.Command;
import cursach.commands.ContractAdd;
import cursach.commands.ContractDel;
import cursach.commands.EnterData;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String COMMAND_NAME = "command";
    private static final String AUTHOR_DELETE = "authorDelete";
    private static final String AUTHOR_ADD = "authorAdd";
    private static final String BOOK_ADD = "bookAdd";
    private static final String BOOK_DELETE = "bookDelete";
    private static final String CONTRACT_ADD = "contractAdd";
    private static final String CONTRACT_DELETE = "contractDelete";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String commandName = req.getParameter(COMMAND_NAME);
        Command command = defineCommand(commandName);
        command.execute(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }

    private Command defineCommand(String commandName) {
        switch (commandName) {
            case AUTHOR_ADD:
                return new AuthorAdd();
            case AUTHOR_DELETE:
                return new AuthorDel();
            case BOOK_DELETE:
                return new BookDel();
            case BOOK_ADD:
                return new BookAdd();
            case CONTRACT_DELETE:
                return new ContractDel();
            case CONTRACT_ADD:
                return new ContractAdd();
            default:
                return new EnterData();
        }
    }
}
