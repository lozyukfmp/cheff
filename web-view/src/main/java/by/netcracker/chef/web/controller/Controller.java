package by.netcracker.chef.web.controller;

import by.netcracker.chef.web.command.CommandFactory;
import by.netcracker.chef.web.command.CommandUtil;
import by.netcracker.chef.web.command.Command;
import by.netcracker.chef.web.command.exception.CommandException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    private static Logger logger = LogManager.getLogger(Controller.class);
    private static final String COMMAND = "command";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String page = processRequest(req);

            logger.trace("FORWARD TO " + page);

            RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath() + page);
            dispatcher.forward(req, resp);

        } catch (CommandException e) {
            logger.error(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String responseCommand = processRequest(req);

            logger.trace("REDIRECT TO " + req.getContextPath() + "/Controller?command=" + responseCommand);

            resp.sendRedirect(req.getContextPath() + "/Controller?command=" + responseCommand);


        } catch (CommandException e) {
            logger.error(e);
        }
    }

    private String processRequest(HttpServletRequest request) throws CommandException{


        String commandName = request.getParameter(COMMAND);
        Command command = CommandFactory.getInstance()
                .getCommand(CommandUtil.convertFromParameter(commandName));

        logger.trace("REQUEST: " + request.getMethod() + ", COMMAND : " +
                CommandUtil.convertFromParameter(commandName));

        return command.execute(request);
    }
}
