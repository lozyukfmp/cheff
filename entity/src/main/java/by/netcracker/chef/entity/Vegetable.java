package by.netcracker.chef.entity;

public class Vegetable {
    private int id;
    private String name;
    private double calories;
    private double fats;
    private double proteins;
    private double carbohydrates;

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

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getFats() {
        return fats;
    }

    public void setFats(double fats) {
        this.fats = fats;
    }

    public double getProteins() {
        return proteins;
    }

    public void setProteins(double proteins) {
        this.proteins = proteins;
    }

    public double getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(double carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vegetable vegetable = (Vegetable) o;

        if (getId() != vegetable.getId()) return false;
        if (Double.compare(vegetable.getCalories(), getCalories()) != 0) return false;
        if (Double.compare(vegetable.getFats(), getFats()) != 0) return false;
        if (Double.compare(vegetable.getProteins(), getProteins()) != 0) return false;
        if (Double.compare(vegetable.getCarbohydrates(), getCarbohydrates()) != 0) return false;
        return getName() != null ? getName().equals(vegetable.getName()) : vegetable.getName() == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        temp = Double.doubleToLongBits(getCalories());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getFats());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getProteins());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getCarbohydrates());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
