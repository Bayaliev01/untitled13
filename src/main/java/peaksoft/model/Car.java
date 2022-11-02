package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.CascadeType.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String model;
    private int price;
    private String color;
    @ManyToOne(cascade = {DETACH, MERGE, REFRESH, PERSIST}, fetch = FetchType.EAGER)

    private Person person;


    public Car(String model, int price, String color) {
        this.model = model;
        this.price = price;
        this.color = color;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", person=" + person +
                '}';
    }
}
