package com.lis.better_darker.market_backend.web.service;

import com.lis.better_darker.market_backend.web.dto.PaginatedItems;
import com.lis.better_darker.market_backend.web.filter.ItemFilter;

public interface MarketDnDService {
    PaginatedItems getItems(ItemFilter filter, int page, int limit, String cursor);
}
