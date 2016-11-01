package by.netcracker.chef.entity;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "menu")
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id")
    private int menuId;

    @Column(name = "menu_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "menu_m2m_salad",
            joinColumns = @JoinColumn(name = "menu_id"),
            inverseJoinColumns = @JoinColumn(name = "salad_id"))
    private Collection<Salad> saladList = new ArrayList<>();

}
