package com.artostapyshyn.aircompany.model;

import com.artostapyshyn.aircompany.enums.FlightStatus;
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
@Table(name = "flight")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "flight_status", nullable = false)
    private FlightStatus flightStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "air_company_id")
    private AirCompany airCompany;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "airplane_id")
    private Airplane airplane;

    @Column(name = "departure_country", nullable = false)
    @NotBlank
    private String departureCountry;

    @Column(name = "destination_country", nullable = false)
    @NotBlank
    private String destinationCountry;

    @Column(name = "distance", nullable = false)
    @Min(value = 0)
    private Double distance;

    @Column(name = "estimated_flight_time", nullable = false)
    @Min(value = 0)
    private Integer estimatedFlightTime;

    @Column(name = "started_at")
    private LocalDateTime startedAt;

    @Column(name = "ended_at")
    private LocalDateTime endedAt;

    @Column(name = "delay_started_at")
    private LocalDateTime delayStartedAt;

    @Column(name = "created_at", nullable = false)
    @CreationTimestamp
    private LocalDateTime createdAt;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
