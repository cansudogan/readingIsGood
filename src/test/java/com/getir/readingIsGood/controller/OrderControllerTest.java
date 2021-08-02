package com.getir.readingIsGood.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.getir.readingIsGood.model.request.OrderByDateRequest;
import com.getir.readingIsGood.model.request.OrderCreateRequest;
import com.getir.readingIsGood.service.OrderService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;


public class OrderControllerTest {
    private MockMvc mockMvc;

    @InjectMocks
    private OrderController orderController;

    @Mock
    private OrderService orderService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.standaloneSetup(orderController).build();
    }

    @Test
    public void testCreateOrderEnpoint() throws Exception {

        OrderCreateRequest request = new OrderCreateRequest();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(post("/api/order").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));

    }

    @Test
    public void testGetOrderByIdEndpoint() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/order/{id}", 1)
                .accept(MediaType.APPLICATION_JSON));

    }

    @Test
    public void testGetOrderByDateIntervalEnpoint() throws Exception {

        OrderByDateRequest request = new OrderByDateRequest();

        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        String requestBody = objectWriter.writeValueAsString(request);

        mockMvc.perform(post("/api/order/date").contentType(MediaType.APPLICATION_JSON_VALUE).content(requestBody));

    }
}
