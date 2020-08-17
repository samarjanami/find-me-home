package com.samar.findmehome;

import com.samar.findmehome.service.PropertyApiService;
import com.samar.findmehome.service.model.Media;
import com.samar.findmehome.service.model.Property;
import com.samar.findmehome.service.model.PropertiesResponse;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Created by Samar J on 8/1/2020.
 */

@WebMvcTest
public class FindmehomeApplicationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PropertyApiService service;

    @Test
    public void getSearchResultsSetTheModelWithPropertyListAndReturnsSearchPage() throws Exception{
        List<Property> propertyList = new ArrayList<>();
        propertyList.add(new Property("los angeles", "california", 90025,
                "12 30th st, some address",280000, 2, 1,
                "condo", "this is the short description", 1200,
                1550, Collections.singletonList(new Media()), 1, 1960));

        PropertiesResponse response = new PropertiesResponse();
        response.setProperties(propertyList);
        response.setCount(1);

        when(service.getPropertiesResponse( any())).thenReturn(response);
        this.mockMvc.perform(post("/search").param("location", "95314")
                .param("numberOfListingInAPage", "9").param("pageNumber", "0"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("search")))
                .andExpect(model().attribute("properties", Matchers.hasSize(propertyList.size())))
                .andExpect(model().attribute("properties", Matchers.hasItem(
                        allOf(
                                hasProperty("address", is("12 30th st, some address")),
                                hasProperty("price", is(280000)),
                                hasProperty("numberOfBedrooms", is(2)),
                                hasProperty("numberOfBathrooms", is(1)),
                                hasProperty("propertyType", is("condo")),
                                hasProperty("description", is("this is the short description")),
                                hasProperty("floorArea", is(1200)),
                                hasProperty("lotArea", is(1550)),
                                hasProperty("numberOfParking", is(1)),
                                hasProperty("yearBuilt", is(1960))
                                //TODO hasProperty("pictures", hasItem())
                        )
                )));
    }
}
