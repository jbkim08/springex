package org.zerock.springex.dto;

import lombok.*;

import java.time.LocalDate;

//롬복으로 toString 메소드, 겟셋메소드, 빌더, 전체변수생성자, 기본생성자
@ToString
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TodoDTO {
    private Long tno;           //번호
    private String title;       //제목
    private LocalDate dueDate;  //날짜
    private boolean finished;   //완료됨?
    private String writer;      //작성자
}
