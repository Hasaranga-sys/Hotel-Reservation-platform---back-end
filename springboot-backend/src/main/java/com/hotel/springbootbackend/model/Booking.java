package com.hotel.springbootbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Table;

import javax.persistence.*;

import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

//making this class as a jpa entity
@Entity
//@Table(name="bookings")
@Table(name = "bookings")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="checkInDate")
    private String checkInDate;

    @Column(name="checkOutDate")
    private String checkOutDate;

    @Column(name="email")
    private String email;

    @Column(name="guests")
    private String guests;

    @Column(name="kids")
    private String kids;
}
