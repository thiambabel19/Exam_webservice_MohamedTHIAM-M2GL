package com.groupeisi.domain;

import jakarta.persistence.*;

@Entity
public class Responses {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String day;

    @OneToOne(mappedBy = "response")
    private SearchItems searchItems;

    public Responses() {
    }

    public Responses(String date, String day, SearchItems searchItems) {
        this.date = date;
        this.day = day;
        this.searchItems = searchItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public SearchItems getSearchItems() {
        return searchItems;
    }

    public void setSearchItems(SearchItems searchItems) {
        this.searchItems = searchItems;
    }
}
