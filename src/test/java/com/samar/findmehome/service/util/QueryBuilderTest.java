package com.samar.findmehome.service.util;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueryBuilderTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void generate() {
        String queryTest;
        QueryBuilder queryBuilder = new QueryBuilder();
        queryTest = queryBuilder.generate(95314, "Single Family Residence", 1, 1, 2000, 600000);

        assertEquals("contains(PostalCode,'95314') and PropertySubType eq 'Single Family Residence' and BedroomsTotal ge 1 and BathroomsFull ge 1 and ListPrice ge 2000 and ListPrice le 600000", queryTest);
    }
}