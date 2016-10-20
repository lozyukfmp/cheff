package by.netcracker.chef.web.command;

import by.netcracker.chef.entity.Salad;
import by.netcracker.chef.entity.Vegetable;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.stream.Collectors;

public final class CommandUtil {

    public static final String MENU = "menu";
    public static final String MENU_ID = "menu-id";
    public static final String MENU_NAME = "menu-name";
    public static final String SALAD_LIST = "saladList";
    public static final String MENU_SALAD_LIST = "menuSaladList";

    public static final String SALAD = "salad";
    public static final String SALAD_ID = "salad-id";
    public static final String SALAD_NAME = "salad-name";
    public static final String VEGETABLE_LIST = "vegetableList";
    public static final String INGREDIENT_LIST = "ingredientList";
    public static final String VEGETABLE = "vegetable";

    public static final String VEGETABLE_ID = "vegetable-id";
    public static final String VEGETABLE_NAME = "vegetable-name";
    public static final String VEGETABLE_CALORIES = "vegetable-calories";
    public static final String VEGETABLE_FATS = "vegetable-fats";
    public static final String VEGETABLE_PROTEINS = "vegetable-proteins";
    public static final String VEGETABLE_CARBOHYDRATES = "vegetable-carbohydrates";

    public static final String PATH = "path";

    public static CommandName convertFromParameter(String parameter) {
        return CommandName.valueOf(parameter.replace("-", "_").toUpperCase());
    }

    public static String convertFromCommandName(CommandName commandName) {
        return commandName.name().replace("_", "-").toLowerCase();
    }

    public static List<Vegetable> formVegetableList(List<Vegetable> ingredientList, List<Vegetable> vegetableList) {
        return vegetableList.stream()
                .filter(vegetable -> !ingredientList.contains(vegetable))
                .collect(Collectors.toList());
    }

    public static List<Salad> formSaladList(List<Salad> menuSaladList, List<Salad> saladList) {
        return saladList.stream()
                .filter(salad -> !menuSaladList.contains(salad))
                .collect(Collectors.toList());
    }

    public static void clearSession(HttpServletRequest request) {
        request.getSession().removeAttribute(SALAD);
        request.getSession().removeAttribute(INGREDIENT_LIST);
        request.getSession().removeAttribute(VEGETABLE_LIST);

        request.getSession().removeAttribute(MENU);
        request.getSession().removeAttribute(MENU_SALAD_LIST);
        request.getSession().removeAttribute(SALAD_LIST);

        request.getSession().removeAttribute(PATH);
    }
}
