package com.sparta.spa_spring_homework1.repository;

import com.sparta.spa_spring_homework1.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {

}
