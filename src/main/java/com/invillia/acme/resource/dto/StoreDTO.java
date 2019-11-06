package com.invillia.acme.resource.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StoreDTO implements Serializable {
    private Long id;
    @ApiModelProperty(notes = "Nome da emppresa - campo obrigatório")
    private String name;
    @ApiModelProperty(notes = "Endereço - campo obrigatório")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
