package com.getir.readingIsGood.domain;


import com.getir.readingIsGood.model.dto.CustomerDTO;
import com.getir.readingIsGood.model.dto.CustomerResponseDTO;
import com.getir.readingIsGood.model.dto.OrderDTO;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "Name can not be empty.")
    private String name;

    @NotEmpty(message = "Surname can not be empty.")
    private String surname;

    @Email(message = "Invalid email format")
    private String mail;

    @OneToMany(cascade = {CascadeType.ALL})
    private List<Order> orderList = new ArrayList<Order>();

    public Customer() {
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", orderList=" + orderList +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public List<Order> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Order> orderList) {
        this.orderList = orderList;
    }

    public CustomerDTO customerDTO(Customer customer) {
        CustomerDTO dto = new CustomerDTO();
        dto.setId(getId());
        dto.setName(getName());
        dto.setSurname(getSurname());
        dto.setMail(getMail());

        List<OrderDTO> orderDTOS = new ArrayList<>();
        if (Objects.nonNull(getOrderList())) {
            getOrderList().forEach(order -> orderDTOS.add(order.orderDTO(order)));
        }

        dto.setOrderList(orderDTOS);

        return dto;
    }

    public CustomerResponseDTO responseDTO(Customer customer) {
        CustomerResponseDTO customerResponseDTO = new CustomerResponseDTO();
        customerResponseDTO.setName(customer.getName());
        customerResponseDTO.setSurname(customer.getSurname());
        customerResponseDTO.setEmail(customer.getMail());

        return customerResponseDTO;
    }
}
