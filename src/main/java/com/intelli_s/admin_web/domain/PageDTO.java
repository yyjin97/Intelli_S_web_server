package com.intelli_s.admin_web.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PageDTO {

    private int startPage;
    private int endPage;
    private boolean next, prev;

    private int total;
    private Criteria cri;

    public PageDTO(Criteria cri, int total) {
        this.total = total;
        this.cri = cri;

        this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
        this.startPage = this.endPage - 9;

        int realEnd = (int)(Math.ceil((total * 1.0) / cri.getAmount()));

        if(realEnd < this.endPage)
            this.endPage = realEnd;

        this.prev = this.startPage > 1;
        this.next = this.endPage < realEnd;
    }
}
