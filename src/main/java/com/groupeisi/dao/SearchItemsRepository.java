package com.groupeisi.dao;

import com.groupeisi.domain.SearchItems;
import com.groupeisi.domain.SearchResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchItemsRepository extends JpaRepository<SearchItems, Integer> {
}
