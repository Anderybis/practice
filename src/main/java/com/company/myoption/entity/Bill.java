package com.company.myoption.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.InstanceName;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import java.util.UUID;

@JmixEntity
@Table(name = "BILL")
@Entity
public class Bill {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @InstanceName
    @Column(name = "NAME", nullable = false)
    @NotNull(message = "{msg://com.company.myoption.entity/Bill.name.validation.NotNull}")
    private String name;

    @Column(name = "CURRENCY", nullable = false)
    @NotNull(message = "{msg://com.company.myoption.entity/Bill.currency.validation.NotNull}")
    private String currency;

    @PositiveOrZero(message = "{msg://com.company.myoption.entity/Bill.balance.validation.PositiveOrZero}")
    @Column(name = "BALANCE")
    private Integer balance;

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }



}