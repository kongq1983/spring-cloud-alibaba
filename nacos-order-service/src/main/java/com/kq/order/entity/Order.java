package com.kq.order.entity;

/**
 * @author kq
 * @date 2021-04-17 14:48
 * @since 2020-0630
 */
public class Order {

    private Long id;
    private String name;
    private String orderCode;

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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", orderCode='" + orderCode + '\'' +
                '}';
    }
}
