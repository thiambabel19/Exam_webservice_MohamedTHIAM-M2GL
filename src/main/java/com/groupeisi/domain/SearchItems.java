package com.groupeisi.domain;

import jakarta.persistence.*;

@Entity
public class SearchItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String request;

    @OneToOne(mappedBy = "searchItems")
    private SearchResult searchResult;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "response_id")
    private Responses response;

    public SearchItems() {
    }

    public SearchItems(String request, SearchResult searchResult, Responses response) {
        this.request = request;
        this.searchResult = searchResult;
        this.response = response;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }

    public SearchResult getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(SearchResult searchResult) {
        this.searchResult = searchResult;
    }

    public Responses getResponse() {
        return response;
    }

    public void setResponse(Responses response) {
        this.response = response;
    }
}
