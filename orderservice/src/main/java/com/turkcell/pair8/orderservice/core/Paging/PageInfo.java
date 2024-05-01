package com.turkcell.pair8.orderservice.core.Paging;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @AllArgsConstructor
    @NoArgsConstructor
    @Data
    public class PageInfo {
        private int page;
        private int size;
    }

