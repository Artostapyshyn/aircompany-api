package com.artostapyshyn.aircompany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "airplane")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Airplane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @NotBlank
    private String name;

    @Column(name = "factory_serial_number", unique = true)
    @NotBlank
    private String factorySerialNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    @Column(name = "number_of_flights", nullable = false)
    @Min(value = 0)
    private Integer numberOfFlights;

    @Column(name = "flight_distance", nullable = false)
    @Min(value = 0)
    private Double flightDistance;

    @Column(name = "fuel_capacity", nullable = false)
    @Min(value = 0)
    private Double fuelCapacity;

    @Column(name = "type", nullable = false)
    @NotBlank
    private String type;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airplane airplane = (Airplane) o;
        return Objects.equals(id, airplane.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
