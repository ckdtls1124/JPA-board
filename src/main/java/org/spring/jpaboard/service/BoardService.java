package org.spring.jpaboard.service;

import org.spring.jpaboard.dto.BoardRequestDTO;
import org.spring.jpaboard.entity.BoardEntity;
import org.spring.jpaboard.repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardService {
    @Autowired
    private final BoardRepo boardRepo;
    public BoardService(BoardRepo boardRepo){
        this.boardRepo=boardRepo;
    }


    public void write(BoardRequestDTO dto) {
        BoardEntity entity=BoardRequestDTO.toEntity(dto);
        boardRepo.save(entity);
    }
}
