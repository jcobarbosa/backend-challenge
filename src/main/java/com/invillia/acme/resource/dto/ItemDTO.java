package com.invillia.acme.resource.dto;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.math.BigDecimal;

public class ItemDTO implements Serializable {
    private Long id;

    @ApiModelProperty(notes = "Descrição do item - campo obrigatório")
    private String description;
    @ApiModelProperty(notes = "Valor unitário - campo obrigatório")
    private BigDecimal unityPrice;
    @ApiModelProperty(notes = "Quantidade - campo obrigatório")
    private Integer quantity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnityPrice() {
        return unityPrice;
    }

    public void setUnityPrice(BigDecimal unityPrice) {
        this.unityPrice = unityPrice;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
