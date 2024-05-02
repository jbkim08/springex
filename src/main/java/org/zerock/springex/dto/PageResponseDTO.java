package org.zerock.springex.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
public class PageResponseDTO<E> {
    private int page;
    private int size;
    private int total; //총 게시글

    private int start; //시작페이지
    private int end;   //끝페이지

    private boolean prev; //이전페이지 있음?
    private boolean next; //다음페이지 있음?

    private List<E> dtoList; //여러 타입 리스트 사용가능

    @Builder(builderMethodName = "withAll")
    public PageResponseDTO(PageRequestDTO pageRequestDTO,
                           List<E> dtoList, int total) {
        this.page = pageRequestDTO.getPage();
        this.size = pageRequestDTO.getSize();
        this.total = total;
        this.dtoList = dtoList;
        //현재페이지 기준으로 끝페이지 계산
        this.end = (int)(Math.ceil(this.page/10.0))*10;
        //시작페이지는 끝페이지 - 9
        this.start = this.end - 9;
        //총 게시글 / 10 => 총 페이지숫자를 계산 (나머지 있으면 + 1)
        int last = (int)(Math.ceil(total/(double)size));
        //총 페이지보다 끝페이지가 크면 총페이지가 끝페이지 숫자가 됨
        this.end = end > last ? last : end;
        //1페이지보다 크면 이전 페이지 있다.
        this.prev = this.start > 1;
        //총게시글이 끝페이지*10보다 크면 다음페이지 있다.
        this.next = total > this.end * this.size;
    }
}
