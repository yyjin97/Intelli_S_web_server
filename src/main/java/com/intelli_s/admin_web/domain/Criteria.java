package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Criteria {

    private int pageNum;
    private int amount;

    public Criteria() {
        this(1, 10);
    }

    public Criteria(int pageNum, int amount) {
        this.pageNum = pageNum;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "pageNum=" + pageNum +
                ", amount=" + amount +
                '}';
    }
}
