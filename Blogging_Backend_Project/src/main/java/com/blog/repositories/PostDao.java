package com.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.blog.entities.Post;

@Repository
public interface PostDao extends JpaRepository<Post, Integer>
{
	@Query(value = "select * from Post p where p.category_id= :catId",nativeQuery = true)
	public List<Post> findPostByCategory(@Param("catId") int catId);
	
	@Query(value = "select * from Post p where p.user_id=:userId",nativeQuery = true)
	public List<Post> findPostByUser(@Param("userId") int userId);
	
	@Query(value = "select * from Post p where p.title like %:title%",nativeQuery = true)
	public List<Post> searchByTitleContaining(@Param("title")String title);
}
