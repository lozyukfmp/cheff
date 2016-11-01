package by.netcracker.chef.entity;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Builder
@Entity
@Table(name = "vegetable")
public class Vegetable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vegetable_id")
    private Integer vegetableId;

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
