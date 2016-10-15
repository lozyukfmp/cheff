package by.netcracker.chef.entity;

import java.util.List;

public class Menu {
    private int id;
    private String name;
    private List<Salad> saladList;

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

    public List<Salad> getSaladList() {
        return saladList;
    }

    public void setSaladList(List<Salad> saladList) {
        this.saladList = saladList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        if (getId() != menu.getId()) return false;
        if (getName() != null ? !getName().equals(menu.getName()) : menu.getName() != null) return false;
        return getSaladList() != null ? getSaladList().equals(menu.getSaladList()) : menu.getSaladList() == null;

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + (getName() != null ? getName().hashCode() : 0);
        result = 31 * result + (getSaladList() != null ? getSaladList().hashCode() : 0);
        return result;
    }
}

