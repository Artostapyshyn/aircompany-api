package com.artostapyshyn.aircompany.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "air_company")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AirCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", unique = true, nullable = false)
    private String name;

    @Column(name = "company_type", nullable = false)
    private String companyType;

    @Column(name = "founded_at", nullable = false)
    @CreationTimestamp
    private LocalDate foundedAt;

    @OneToMany(mappedBy = "airCompany", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Airplane> airplanes = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AirCompany that = (AirCompany) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}