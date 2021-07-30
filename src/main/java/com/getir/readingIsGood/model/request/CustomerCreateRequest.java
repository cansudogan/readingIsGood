package com.getir.readingIsGood.model.request;

import com.getir.readingIsGood.domain.Order;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerCreateRequest {
    @NotNull(message = "Customer name is required.")
    @Size(min = 3, max = 50, message = "Please use 3 to 50 characters")
    private String name;

    @NotNull(message = "Customer surname is required.")
    @Size(min = 3, max = 50, message = "Please use 3 to 50 characters")
    private String surname;

    @Email(message = "Invalid email format")
    private String email;


    @Override
    public String toString() {
        return "CustomerCreateRequest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                '}';
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
