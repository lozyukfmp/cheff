package by.netcracker.chef.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Data
@Entity
@Table(name = "salad")
@NamedQueries({
        @NamedQuery(name="Salad.findAll", query = "select s from Salad s"),
        @NamedQuery(name = "Salad.findByIdWithVegetables",
                query = "select distinct s from Salad s left join fetch " +
                        "s.ingredients where s.id = :id")
})
public class Salad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salad_id")
    private int id;

    @Column(name = "salad_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "salad_m2m_vegetable",
            joinColumns = @JoinColumn(name = "salad_id"),
            inverseJoinColumns = @JoinColumn(name = "vegetable_id"))
    private Collection<Vegetable> ingredients = new ArrayList<>();

}
