package by.netcracker.chef.controller;

import by.netcracker.chef.command.Command;
import by.netcracker.chef.command.CommandFactory;
import by.netcracker.chef.command.CommandUtil;
import by.netcracker.chef.command.exception.CommandException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {
    private static final String COMMAND = "command";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String page = processRequest(req);

            RequestDispatcher dispatcher = req.getRequestDispatcher(req.getContextPath() + page);
            dispatcher.forward(req, resp);

        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String responseCommand = processRequest(req);

            resp.sendRedirect(req.getContextPath() + "/Controller?command=" + responseCommand);

        } catch (CommandException e) {
            e.printStackTrace();
        }
    }

    private String processRequest(HttpServletRequest request) throws CommandException{
        String commandName = request.getParameter(COMMAND);
        Command command = CommandFactory.getInstance()
                .getCommand(CommandUtil.convertFromParameter(commandName));
        return command.execute(request);
    }
}
