package org.spring.jpaboard.entity;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.spring.jpaboard.dto.BoardRequestDTO;

import javax.persistence.*;
import java.time.LocalDateTime;

@javax.persistence.Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name="board_table")
@Builder
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long number;

    @Column(nullable = false)
    private String title;
    @Column(nullable = false, length = 500)
    private String content;
    @Column(nullable = false)
    private String writer;
    @Column(columnDefinition = "integer default 0", nullable = false)
    private int views;
    @Column(nullable = false)
    private String boardPw;

    @CreationTimestamp
    @Column(updatable = false ) //
    private LocalDateTime createTime;

    @UpdateTimestamp
    @Column(insertable = false)
    private LocalDateTime updateTime;

    //    ========DTO -> Entity ==================
    public static BoardEntity insertNewContent(BoardRequestDTO dto){
        BoardEntity entity=new BoardEntity();

        entity.title=dto.getTitle();
        entity.content=dto.getContent();
        entity.writer=dto.getWriter();
        entity.boardPw=dto.getBoardPw();

        entity.views=dto.getViews();
        entity.createTime=dto.getCreateTime();
        entity.updateTime=dto.getUpdateTime();

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
