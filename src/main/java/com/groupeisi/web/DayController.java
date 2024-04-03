package com.groupeisi.web;

import com.groupeisi.domain.SearchResult;
import com.groupeisi.service.DayCalculatorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DayController {
    private final DayCalculatorService dayCalculatorService;

    public DayController(DayCalculatorService dayCalculatorService) {
        this.dayCalculatorService = dayCalculatorService;
    }

    @PostMapping("/services/calendar/dayfinder")
    public ResponseEntity<?> getDay(@RequestBody String date){
        return ResponseEntity.ok(dayCalculatorService.getDay(date));
    }

    @GetMapping("/historique/all")
    public ResponseEntity<List<SearchResult>> getAllSearchResults() {
        List<SearchResult> searchResults = dayCalculatorService.historique();
        return ResponseEntity.ok(searchResults);
    }
}
