package com.example.demo.board.repository;

import com.example.demo.board.entity.BoardFileEntity;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.Mapping;

@Mapper
public interface BoardFileRepository extends JpaRepository<BoardFileEntity, Long> {
}
