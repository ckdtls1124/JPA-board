package org.spring.jpaboard.repository;

import org.spring.jpaboard.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepo extends JpaRepository<BoardEntity, Long> {


    @Query(value = "update BoardEntity b set b.views=b.views+1 where b.number=:number")
    void incrementViews(Long number);

}
