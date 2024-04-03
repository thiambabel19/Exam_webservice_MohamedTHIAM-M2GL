package com.groupeisi.service;

import com.groupeisi.dao.ResponsesRepository;
import com.groupeisi.dao.SearchItemsRepository;
import com.groupeisi.dao.SearchResultRepository;
import com.groupeisi.domain.Responses;
import com.groupeisi.domain.SearchItems;
import com.groupeisi.domain.SearchResult;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class DayCalculatorService {
    private final SearchResultRepository searchResultRepository;
    private final SearchItemsRepository searchItemsRepository;
    private final ResponsesRepository responsesRepository;

    public DayCalculatorService(SearchResultRepository searchResultRepository,
                                SearchItemsRepository searchItemsRepository,
                                ResponsesRepository responsesRepository) {
        this.searchResultRepository = searchResultRepository;
        this.searchItemsRepository = searchItemsRepository;
        this.responsesRepository = responsesRepository;
    }

    public String calculateDayOfWeek(String dateStr) {
        try {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
            Date date = format.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(date);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            String[] days = {"Dimanche", "Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi"};
            return days[dayOfWeek - 1];
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Transactional
    public Object getDay(String date){
        Map<String, String> result = new HashMap<>();
        String days = calculateDayOfWeek(date);
        result.put("date", date);
        result.put("dayOfWeek", days);

        // save response
        Responses response = new Responses();
        response.setDate(date);
        response.setDay(days);
        Responses savedResponse = responsesRepository.save(response);

        // save search items
        SearchItems searchItems = new SearchItems();
        searchItems.setRequest(date);
        searchItems.setResponse(savedResponse);
        SearchItems savedSearchItems = searchItemsRepository.save(searchItems);

        // Update response with search items
        savedResponse.setSearchItems(savedSearchItems);
        responsesRepository.save(savedResponse);

        // save search result
        SearchResult searchResult = new SearchResult();
        searchResult.setSearchDate(date);
        searchResult.setSearchItems(savedSearchItems);
        SearchResult savedSearchResult = searchResultRepository.save(searchResult);

        // Update search items with search result
        savedSearchItems.setSearchResult(savedSearchResult);
        searchItemsRepository.save(savedSearchItems);

        return result;
    }

    public List<SearchResult> historique(){
        return searchResultRepository.findAll();
    }
}
