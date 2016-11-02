package by.netcracker.chef.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "menu")
@NamedQueries({
        @NamedQuery(name="Menu.findAll", query = "select m from Menu m"),
        @NamedQuery(name = "Menu.findByIdWithSalads",
                query = "select distinct m from Menu m left join fetch " +
                "m.saladList where m.id = :id")
})
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int id;

    @Column(name = "menu_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "menu_m2m_salad",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "salad_id"))
    private Collection<Salad> saladList = new ArrayList<>();

}
