package com.groupeisi.domain;

import jakarta.persistence.*;

@Entity
public class SearchResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String searchDate;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "search_items_id")
    private SearchItems searchItems;

    public SearchResult() {
    }

    public SearchResult(String searchDate, SearchItems searchItems) {
        this.searchDate = searchDate;
        this.searchItems = searchItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(String searchDate) {
        this.searchDate = searchDate;
    }

    public SearchItems getSearchItems() {
        return searchItems;
    }

    public void setSearchItems(SearchItems searchItems) {
        this.searchItems = searchItems;
    }
}
