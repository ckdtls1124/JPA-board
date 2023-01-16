package org.spring.jpaboard.dto;

import lombok.*;
import org.spring.jpaboard.entity.BoardEntity;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class BoardResponseDTO {

//    Entity should not use the setter. Therefore, this DTO class needs a behavior to
//    transfer those data.


    private Long number;
    private String title;
    private String content;
    private String writer;

    //    set the default
    private int views=0;

    private String boardPw;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    //    ========DTO -> Entity ==================
    public static BoardEntity insertNewContent(BoardRequestDTO dto){
        BoardEntity entity=new BoardEntity();






//        entity.=dto.getTitle();
//        entity.content=dto.getContent();
//        entity.writer=dto.getWriter();
//        entity.boardPw=dto.getBoardPw();
//
//        entity.views=dto.getViews();
//        entity.createTime=dto.getCreateTime();
//        entity.updateTime=dto.getUpdateTime();

        return entity;
    }
    //    Using Builder
    public static BoardEntity toEntity(BoardRequestDTO dto){
        return BoardEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .boardPw(dto.getBoardPw())
                .views(dto.getViews())
                .build();
    }

}
