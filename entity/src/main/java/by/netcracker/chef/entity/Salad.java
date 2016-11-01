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
@Table(name = "salad")
public class Salad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "salad_id")
    private int saladId;

    @Column(name = "salad_name")
    private String name;

    @ManyToMany
    @JoinTable(name = "salad_m2m_vegetable",
            joinColumns = @JoinColumn(name = "salad_id"),
            inverseJoinColumns = @JoinColumn(name = "vegetable_id"))
    private Collection<Vegetable> ingredients = new ArrayList<>();

}
