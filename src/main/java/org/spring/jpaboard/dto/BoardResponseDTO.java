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
    private int views;
    private String boardPw;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    //    ========Entity -> DTO ==================
    public static BoardResponseDTO toResponseDTO(BoardEntity entity){
        BoardResponseDTO dto=new BoardResponseDTO();
        dto.setNumber(entity.getNumber());
        dto.setTitle(entity.getTitle());
        dto.setContent(entity.getContent());
        dto.setWriter(entity.getWriter());
        dto.setBoardPw(entity.getBoardPw());
        dto.setViews(entity.getViews());
        dto.setCreateTime(entity.getCreateTime());
        dto.setUpdateTime(entity.getUpdateTime());
        return dto;
    }
    //    Using Builder
    public static BoardResponseDTO toResponseDTOByBuilder(BoardEntity entity){
        return BoardResponseDTO.builder()
                .title(entity.getTitle())
                .content(entity.getContent())
                .writer(entity.getWriter())
                .boardPw(entity.getBoardPw())
                .views(entity.getViews())
                .number(entity.getNumber())
                .createTime(entity.getCreateTime())
                .updateTime(entity.getUpdateTime())
                .build();
    }

}
