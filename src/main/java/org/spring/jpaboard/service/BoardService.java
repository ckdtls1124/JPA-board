package org.spring.jpaboard.service;

import org.spring.jpaboard.dto.BoardRequestDTO;
import org.spring.jpaboard.dto.BoardResponseDTO;
import org.spring.jpaboard.entity.BoardEntity;
import org.spring.jpaboard.repository.BoardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.persistence.Id;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class BoardService {
    @Autowired
    private BoardRepo boardRepo;
    public BoardService(BoardRepo boardRepo){
        this.boardRepo=boardRepo;
    }


    @Transactional
    public void write(BoardRequestDTO dto) {
        BoardEntity entity=BoardRequestDTO.toEntity(dto);
        boardRepo.save(entity);
    }

    public List<BoardResponseDTO> showAllLists() {
        List<BoardResponseDTO> dtoList=new ArrayList<>();

        List<BoardEntity> entityList=boardRepo.findAll();

        for(BoardEntity i:entityList){
            dtoList.add(BoardResponseDTO.toResponseDTO(i));
        }

        return dtoList;
    }

//    @Transactional
//    public void incrementViews(Long number) {
//        boardRepo.incrementViews(number);
//    }


    @Transactional
    public BoardResponseDTO showOneList(Long number) {
        BoardResponseDTO oneWriting;
        Optional<BoardEntity> list=boardRepo.findById(number);
        if(list.isPresent()){
                oneWriting=BoardResponseDTO.toResponseDTO(list.get());
            return oneWriting;
        } else {
            return null;
        }
    }

    public Page<BoardResponseDTO> boardPaging(Pageable pageable) {
        Page<BoardEntity> boardEntities = boardRepo.findAll(pageable);
        Page<BoardResponseDTO> boardResponseDTOS = boardEntities.map(BoardResponseDTO :: toResponseDTO);

        return boardResponseDTOS;
    }
}
