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
public class BoardRequestDTO {

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
    public static BoardEntity toEntity(BoardRequestDTO dto){
        BoardEntity entity=new BoardEntity();

        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        entity.setWriter(dto.getWriter());
        entity.setBoardPw(dto.getBoardPw());

        entity.setViews(dto.getViews());
        entity.setCreateTime(dto.getCreateTime());
        entity.setUpdateTime(dto.getUpdateTime());

        return entity;
    }

//    Using Builder
    public static BoardEntity toEntityByBuilder(BoardRequestDTO dto){
        return BoardEntity.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .writer(dto.getWriter())
                .boardPw(dto.getBoardPw())
                .views(dto.getViews())
                .build();
    }



}
