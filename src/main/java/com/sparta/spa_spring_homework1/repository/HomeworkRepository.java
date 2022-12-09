package com.sparta.spa_spring_homework1.repository;

import com.sparta.spa_spring_homework1.dto.PostListDTO;
import com.sparta.spa_spring_homework1.entity.Homework;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework,Long> {



}
