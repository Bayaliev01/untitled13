package peaksoft.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.CascadeType.*;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private int age;
    @OneToMany(cascade = {DETACH, MERGE, REFRESH, PERSIST, REMOVE},mappedBy = "person")
    private List<Car> cars = new ArrayList<>();

    @ManyToMany(cascade = {DETACH, MERGE, PERSIST, REFRESH}, mappedBy = "personList")
    private List<SocialMedia> socialMedia = new ArrayList<>();

    public Person(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }




    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", cars=" + cars +
                ", socialMedia=" + socialMedia +
                '}';
    }
}
