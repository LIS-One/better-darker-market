package com.lis.better_darker.market_backend.controller;

import com.lis.better_darker.market_backend.web.dto.PaginatedItems;
import com.lis.better_darker.market_backend.web.filter.ItemFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.lis.better_darker.market_backend.web.service.MarketDnDService;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class MarketController {
    final MarketDnDService marketDnDService;

    @GetMapping("/health-check")
    public String healthCheck(){
        return "ok";
    }
    @GetMapping("/items")
    public PaginatedItems getItems(
            @ModelAttribute ItemFilter filter,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "25") int limit,
            @RequestParam(required = false) String cursor
    ) {
        // Передаём всё в сервис, а он вернёт готовую обёртку с data + pagination
        return marketDnDService.getItems(filter, page, limit, cursor);
    }
}
