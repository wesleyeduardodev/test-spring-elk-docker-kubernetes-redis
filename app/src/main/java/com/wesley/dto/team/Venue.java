package com.wesley.dto.team;

import lombok.Data;

@Data
public class Venue {
    private Long id;
    private String name;
    private String address;
    private String city;
    private Integer capacity;
    private String surface;
    private String image;
}