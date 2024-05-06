package com.turkcell.pair8.customerservice.services.messages;

public class CustomerMessages {
    public static class ValidationErrors {
        public static final String VALIDATION_NOT_BLANK = "validation.notBlank";
        public static final String VALIDATION_LENGTH = "validation.length";
        public static final String VALIDATION_NOT_NULL = "validation.notNull";
        public static final String VALIDATION_PAST = "validation.past";
    }

    public static class BusinessErrors {
        public static final String NOT_FOUND_ERROR = "notFoundError";
        public static final String CUSTOMERS_WITH_SAME_NATIONAL_ID_SHOULD_NOT_EXIST = "customersWithSameNationalIDShouldNotExist";
        public static final String ACCOUNTS_WITH_SAME_NAME_SHOULD_NOT_EXIST = "accountsWithSameNameShouldNotExist";
    }
}
