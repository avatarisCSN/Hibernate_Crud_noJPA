package org.example.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "planet")
public class Planet {
    @Id
    @Column(length = 100)
    @Pattern(regexp = "[A-Z0-9]+", message = "ID должен быть только в верхнем регистре и цифры")
    private String id;


    @Column(nullable = false, length = 500)
    @Size(min = 1, max = 500, message = "Довжина повинна бути від 3 до 200 символів")
    private String name;

    @OneToMany(mappedBy = "fromPlanet", fetch = FetchType.EAGER)
    private java.util.List<Ticket> departures = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "toPlanet", fetch = FetchType.EAGER)
    private java.util.List<Ticket> arrivals = new java.util.ArrayList<>();

    public Planet(String id, String name) {
       /* if (!id.matches("[A-Z0-9]+")) {
            throw new IllegalArgumentException("ID должен быть только в верхнем регистре и цифры");
        }*/
        this.id = id;
        this.name = name;
    }

    public Planet() {
        // пустой конструктор для Hibernate
    }

    public void setId(String id) {
       /* if (!id.matches("[A-Z0-9]+")) {
            throw new IllegalArgumentException("ID должен быть только в верхнем регистре и цифры");
        }*/
        this.id = id;
    }

    public String getId(){
        return this.id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public List<Ticket> getDepartures() {
        return departures;
    }
    public void setDepartures(List<Ticket> departures) {
        this.departures = departures;
    }

    public List<Ticket> getArrivals() {
        return arrivals;
    }
    public void setArrivals(List<Ticket> arrivals) {
        this.arrivals = arrivals;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Objects.equals(id, planet.id) && Objects.equals(name, planet.name) && Objects.equals(departures, planet.departures) && Objects.equals(arrivals, planet.arrivals);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, departures, arrivals);
    }

    @Override
    public String toString() {
        return "Planet{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}