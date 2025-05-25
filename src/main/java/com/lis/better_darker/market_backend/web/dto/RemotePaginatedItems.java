package com.lis.better_darker.market_backend.web.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RemotePaginatedItems <T>{
    List<T> data;
    int page;
    int limit;
    String cursor;
    private int total;       // общее число элементов
    private int totalPages;  // (total + limit − 1) / limit
}
