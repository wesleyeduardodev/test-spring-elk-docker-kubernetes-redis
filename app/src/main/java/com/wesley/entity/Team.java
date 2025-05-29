package com.wesley.entity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "team")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "api_id", nullable = false, unique = true)
    private Long apiId;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    @Column(name = "founded")
    private Integer founded;

    @Column(name = "national")
    private Boolean national;

    @Column(name = "logo")
    private String logo;
}