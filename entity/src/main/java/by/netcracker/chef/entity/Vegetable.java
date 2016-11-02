package by.netcracker.chef.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vegetable")
@NamedQueries({
        @NamedQuery(name="Vegetable.findAll", query = "select v from Vegetable v")
})
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegetable_id")
    private Integer id;

    @Column(name = "vegetable_name")
    private String name;

    @Column(name = "calories")
    private Double calories;

    @Column(name = "fats")
    private Double fats;

    @Column(name = "proteins")
    private Double proteins;

    @Column(name = "carbohydrates")
    private Double carbohydrates;

}
