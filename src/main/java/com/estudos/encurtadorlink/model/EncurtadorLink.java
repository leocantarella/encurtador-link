package com.estudos.encurtadorlink.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class EncurtadorLink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String linkOriginal;

    @Column(unique = true)
    private String shortCode;

    public EncurtadorLink(){}

    public EncurtadorLink(String linkOriginal, String shortCode){
        this.linkOriginal = linkOriginal;
        this.shortCode = shortCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLinkOriginal() {
        return linkOriginal;
    }

    public void setLinkOriginal(String linkOriginal) {
        this.linkOriginal = linkOriginal;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
