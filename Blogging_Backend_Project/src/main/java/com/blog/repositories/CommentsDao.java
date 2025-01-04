package com.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blog.entities.Comments;

@Repository
public interface CommentsDao extends JpaRepository<Comments, Integer>
{

}
