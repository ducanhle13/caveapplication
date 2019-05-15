package com.game.cave.model;

import javax.persistence.*;

@Entity
@Table(name = "cave")
public class Cave {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String info;
    private int phonenumber;
    private String password;

    @ManyToOne
    @JoinColumn(name = "zone_id")
    private Zone zone;

    public Cave() {
    }

    public Cave(String name, String password, String info) {
        this.name = name;
        this.password = password;
        this.info = info;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Zone getZone() {
        return zone;
    }

    public void setZone(Zone zone) {
        this.zone = zone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public int getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(int phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
