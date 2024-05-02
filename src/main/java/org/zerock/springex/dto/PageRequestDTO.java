package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;

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

    //넘어갈 게시글 숫자
    public int getSkip(){
        return (page - 1) * size;
    }
}
