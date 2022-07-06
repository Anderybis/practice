package com.company.myoption.entity;

import io.jmix.core.entity.annotation.JmixGeneratedValue;
import io.jmix.core.metamodel.annotation.JmixEntity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@JmixEntity
@Table(name = "OPERATION", indexes = {
        @Index(name = "IDX_OPERATION_BILL_ID", columnList = "BILL_ID")
})
@Entity
public class Operation {
    @JmixGeneratedValue
    @Column(name = "ID", nullable = false)
    @Id
    private UUID id;

    @JoinColumn(name = "BILL_ID", nullable = false)
    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private Bill bill;

    @Column(name = "TYPE_", nullable = false)
    @NotNull(message = "{msg://com.company.myoption.entity/Operation.type.validation.NotNull}")
    private String type = "Оплата";

    @Min(message = "{msg://com.company.myoption.entity/Operation.sum.validation.Min}", value = 1)
    @Column(name = "SUM_", nullable = false)
    @NotNull
    private Integer sum;

    @Column(name = "DATE_", nullable = false)
    @Temporal(TemporalType.DATE)
    @NotNull
    private Date date;

    @Column(name = "CATEGORY", nullable = false)
    @NotNull(message = "{msg://com.company.myoption.entity/Operation.category.validation.NotNull}")
    private String category;

    @Column(name = "COMMENT_")
    private String comment;

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSum() {
        return sum;
    }

    public void setSum(Integer sum) {
        this.sum = sum;
    }

    public String getType() {
        return type;
    }

    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}