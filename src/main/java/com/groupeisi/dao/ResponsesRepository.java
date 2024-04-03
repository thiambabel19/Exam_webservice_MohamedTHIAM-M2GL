package com.groupeisi.dao;

import com.groupeisi.domain.Responses;
import com.groupeisi.domain.SearchItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponsesRepository extends JpaRepository<Responses, Integer> {
}
