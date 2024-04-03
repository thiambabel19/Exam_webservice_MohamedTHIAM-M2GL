package com.groupeisi.dao;

import com.groupeisi.domain.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchResultRepository extends JpaRepository<SearchResult, Integer> {
}
