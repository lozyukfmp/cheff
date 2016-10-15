package by.netcracker.chef.entity;

import java.util.List;

public class Salad {
    private int id;
    private String name;
    private List<Vegetable> ingredients;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vegetable> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Vegetable> ingredients) {
        this.ingredients = ingredients;
    }

    public double getCalories() {
        return getIngredients().stream().mapToDouble(vegetable -> vegetable.getCalories()).sum();
    }

    public double getProteins() {
        return getIngredients().stream().mapToDouble(vegetable -> vegetable.getProteins()).sum();
    }

    public double getFats() {
        return getIngredients().stream().mapToDouble(vegetable -> vegetable.getFats()).sum();
    }

    public double getCarbohydrates() {
        return getIngredients().stream().mapToDouble(vegetable -> vegetable.getCarbohydrates()).sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Salad salad = (Salad) o;

        if (getId() != salad.getId()) return false;
        return getName() != null ? getName().equals(salad.getName()) : salad.getName() == null ;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getIngredients() != null ? getIngredients().hashCode() : 0);
        return result;
    }
}
