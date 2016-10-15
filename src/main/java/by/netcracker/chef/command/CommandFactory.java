package by.netcracker.chef.command;

import by.netcracker.chef.command.impl.*;
import by.netcracker.chef.command.impl.menu.*;
import by.netcracker.chef.command.impl.salad.*;
import by.netcracker.chef.command.impl.vegetable.*;

import java.util.HashMap;
import java.util.Map;

public class CommandFactory {
    private static volatile CommandFactory instance = null;

    private Map<CommandName, Command> commands = null;

    private CommandFactory() {
        commands = new HashMap<>();

        commands.put(null, new EmptyCommand());

        commands.put(CommandName.GET_INDEX_PAGE, new GetIndexPageCommand());

        commands.put(CommandName.GET_CREATE_MENU_PAGE, new GetCreateMenuPageCommand());
        commands.put(CommandName.GET_EDIT_MENU_PAGE, new GetEditMenuPageCommand());
        commands.put(CommandName.CREATE_MENU, new CreateMenuCommand());
        commands.put(CommandName.ADD_SALAD_TO_MENU, new AddSaladToMenuCommand());
        commands.put(CommandName.DELETE_SALAD_FROM_MENU, new DeleteSaladFromMenuCommand());
        commands.put(CommandName.SHOW_MENU, new ShowMenuCommand());
        commands.put(CommandName.EDIT_MENU, new EditMenuCommand());
        commands.put(CommandName.DELETE_MENU, new DeleteMenuCommand());

        commands.put(CommandName.GET_CREATE_SALAD_PAGE, new GetCreateSaladPageCommand());
        commands.put(CommandName.CREATE_SALAD, new CreateSaladCommand());
        commands.put(CommandName.ADD_INGREDIENT_TO_SALAD, new AddIngredientToSaladCommand());
        commands.put(CommandName.DELETE_INGREDIENT_FROM_SALAD, new DeleteIngredientFromSaladCommand());
        commands.put(CommandName.GET_EDIT_SALAD_PAGE, new GetEditSaladPageCommand());
        commands.put(CommandName.EDIT_SALAD, new EditSaladCommand());
        commands.put(CommandName.DELETE_SALAD, new DeleteSaladCommand());
        commands.put(CommandName.SHOW_SALAD, new ShowSaladCommand());

        commands.put(CommandName.GET_CREATE_VEGETABLE_PAGE, new GetCreateVegetablePageCommand());
        commands.put(CommandName.CREATE_VEGETABLE, new CreateVegetableCommand());
        commands.put(CommandName.GET_EDIT_VEGETABLE_PAGE, new GetEditVegetablePageCommand());
        commands.put(CommandName.EDIT_VEGETABLE, new EditVegetableCommand());
        commands.put(CommandName.SHOW_VEGETABLE, new ShowVegetableCommand());
        commands.put(CommandName.DELETE_VEGETABLE, new DeleteVegetableCommand());

    }

    public static CommandFactory getInstance() {
        if (instance == null) {
            synchronized (CommandFactory.class) {
                if (instance == null) {
                    instance = new CommandFactory();
                } else {
                    return instance;
                }
            }
        }

        return instance;
    }

    public Command getCommand(CommandName commandName) {
        return commands.get(commandName);
    }
}
