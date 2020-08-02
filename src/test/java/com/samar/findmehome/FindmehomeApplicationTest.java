package com.samar.findmehome;

import com.samar.findmehome.service.PropertyApiService;
import com.samar.findmehome.service.model.Property;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
    public void somthing() throws Exception{
        List<Property> propertyList = new ArrayList<>();
        propertyList.add(new Property());

        when(service.getProperties()).thenReturn(propertyList);
        this.mockMvc.perform(post("/search").param("location", "Los Angeles"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("search")));
    }
}
