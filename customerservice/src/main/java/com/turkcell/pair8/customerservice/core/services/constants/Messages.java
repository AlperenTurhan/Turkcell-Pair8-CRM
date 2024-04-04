package com.turkcell.pair8.customerservice.core.services.constants;

public class Messages {
    public static class ValidationErrors {
        public static final String VALIDATION_NOT_BLANK = "validation.notBlank";
        public static final String VALIDATION_LENGTH = "validation.length";
    }

    public static class BusinessErrors {
        public static final String NOT_FOUND_ERROR = "notFoundError";
        public static final String CUSTOMERS_WITH_SAME_NATIONAL_ID_SHOULD_NOT_EXIST = "customersWithSameNationalIDShouldNotExist";
    }
}