package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.time.LocalDate;
import java.util.Arrays;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageRequestDTO {

    //페이지
    @Builder.Default
    @Min(value = 1)
    @Positive
    private int page = 1;

    //한페이지 당 게시글 수
    @Builder.Default
    @Min(value = 10)
    @Max(value = 100)
    private int size = 10;

    private String link;      //추가링크
    private String[] types;   //검색종류
    private String keyword;   //키워드
    private boolean finished; //완료여부
    private LocalDate from;    //시작 날짜
    private LocalDate to;      //끝 날짜

    //넘어갈 게시글 숫자
    public int getSkip(){
        return (page - 1) * size;
    }

    //현재 페이지와 사이즈를 문자열 파라미터로 리턴
    public String getLink() {
        if(link == null){
            StringBuilder builder = new StringBuilder();
            builder.append("page=" + this.page);
            builder.append("&size=" + this.size);
            link = builder.toString();
        }
        return link;
    }

    //type 배열에서 매치되는 문자열이 있는지 확인
    public boolean checkType(String type){

        if(types == null || types.length == 0){
            return false;
        }
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
