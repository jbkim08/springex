package org.zerock.springex.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Positive;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
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

    //현재 페이지와 사이즈 및 여러 조건들 문자열 파라미터로 리턴
    public String getLink() {

        StringBuilder builder = new StringBuilder();
        builder.append("page=" + this.page);
        builder.append("&size=" + this.size);
        if(finished){
            //체크박스 완료체크가 되면 on 이 추가됨
            builder.append("&finished=on");
        }
        if(types != null && types.length > 0){
            for(int i=0; i<types.length; i++){
                builder.append("&types=" + types[i]);
            }
        }
        if(keyword != null){
            try {
                builder.append("&keyword=" + URLEncoder.encode(keyword,"UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        if(from != null){
            builder.append("&from=" + from.toString());
        }
        if(to != null){
            builder.append("&to=" + to.toString());
        }

        return builder.toString();
    }

    //types 배열에서 매치되는 문자열이 있는지 확인
    public boolean checkType(String type){
        //검색조건 types 가 없으면 false 로 리턴
        if(types == null || types.length == 0){
            return false;
        }
        //types 에서 입력 type 과 같은 문자열이 있는지 확인해서 있으면 true 리턴
        return Arrays.stream(types).anyMatch(type::equals);
    }
}
