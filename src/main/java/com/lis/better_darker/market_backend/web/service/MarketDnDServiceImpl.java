package com.lis.better_darker.market_backend.web.service;

import com.lis.better_darker.market_backend.model.*;
import com.lis.better_darker.market_backend.web.dto.ItemDto;
import com.lis.better_darker.market_backend.web.dto.PaginatedItems;
import com.lis.better_darker.market_backend.web.dto.RemotePaginatedItems;
import com.lis.better_darker.market_backend.web.filter.ItemFilter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MarketDnDServiceImpl implements MarketDnDService{
    private final WebClient darkerDbClient;
    private final ModelMapper modelMapper;
    @Override
    public PaginatedItems getItems(ItemFilter filter, int page, int limit, String cursor) {
        //  Собираем все фильтры в MultiValueMap
        MultiValueMap<String, String> params = filter.toQueryParams();
        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder.fromPath("/items")
                .queryParams(params)
                .queryParam("page", page)
                .queryParam("limit", limit)
                .queryParam("cursor", Optional.ofNullable(cursor));
        String uri = uriComponentsBuilder.build().toUriString();
        //Вызываем внешний клиент
        RemotePaginatedItems<ItemDto> remoteItems = darkerDbClient.get()
                .uri(uri)
                .retrieve()
                .bodyToMono(new ParameterizedTypeReference<RemotePaginatedItems<ItemDto>>() {
                })
                .block();
        List<ItemDto> items = remoteItems.getData().stream()
                .map(itemDto -> modelMapper.map(itemDto, ItemDto.class))
                .toList();
        PaginatedItems result = new PaginatedItems();
        result.setData(items);
        result.setPage(page);
        result.setLimit(limit);
        result.setCursor(remoteItems.getCursor());
        result.setTotal(remoteItems.getTotalPages());
        return result;
    }

    }

