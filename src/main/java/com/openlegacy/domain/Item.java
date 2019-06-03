package com.openlegacy.domain;



import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * A Item.
 */
@Entity
@Table(name = "item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "itemno")
    private Long itemno;

    @Column(name = "name")
    private String name;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "code")
    private String code;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getItemno() {
        return itemno;
    }

    public Item itemno(Long itemno) {
        this.itemno = itemno;
        return this;
    }

    public void setItemno(Long itemno) {
        this.itemno = itemno;
    }

    public String getName() {
        return name;
    }

    public Item name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public Item amount(Integer amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getCode() {
        return code;
    }

    public Item code(String code) {
        this.code = code;
        return this;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Item)) {
            return false;
        }
        return id != null && id.equals(((Item) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Item{" +
            "id=" + getId() +
            ", itemno=" + getItemno() +
            ", name='" + getName() + "'" +
            ", amount=" + getAmount() +
            ", code='" + getCode() + "'" +
            "}";
    }
}
