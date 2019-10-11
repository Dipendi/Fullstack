package com.dipendi.rest.webservices.restfulwebservices.recipe;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeJpaRepository extends JpaRepository<Recipe, Long> {

	List<Recipe> findByUsername(String username);
	List<Recipe> findByName(String name);
	
//	@Query(value = "select name from product where name like %:keyword%", nativeQuery = true)
//	List<String> search(@Param("keyword") String keyword);
}
