package com.dipendi.rest.webservices.restfulwebservices.recipe;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class RecipeResource {

	//GET /recipes
	//Retrieve all recipes
	
	@Autowired
	private RecipeDaoService service;
	
	@GetMapping("/recipes")
	public List<Recipe> retrieveAllRecipes(){
		return service.findAll();
	}
	
	//GET /recipes/{id}
	//Retrieve recipe by id
	@GetMapping("recipes/{id}")
	public Recipe retriveRecipe(@PathVariable long id) {
		return service.findOne(id);
	}
	
	//GET /recipes/{name}
	//Retrieve recipe by name
	@GetMapping("recipes/{name}")
	public Recipe retriveRecipe(@PathVariable String name) {
		return service.findByName(name);
	}
	
	// DELETE /users/{username}/recipes/{id}
	@DeleteMapping("users/{username}/recipes/{id}")
	public ResponseEntity<Void> deleteRecipe(
			@PathVariable String username, @PathVariable long id){
		Recipe recipe = service.deleteById(id);
		if(recipe!=null) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	//EDIT/SAVE Recipe 
	//PUT recipes/{id}
	@PutMapping("/users/{username}/recipes/{id}")
	public ResponseEntity<Recipe> updateRecipe(
			@PathVariable String username,
			@PathVariable long id, @RequestBody Recipe recipe) {
		Recipe recipeUpdated = service.save(recipe);
		return new ResponseEntity<Recipe>(recipe, HttpStatus.OK);
	}
	
	
	//CREATE recipe
	//POST
	
	@PostMapping("/users/{username}/recipes")
	public ResponseEntity<Void> createdRecipe(
			@PathVariable String username, @RequestBody Recipe recipe) {
		
		Recipe createdRecipe = service.save(recipe);
		
		//return the uri of the new recipe added in the response 
		URI uri = ServletUriComponentsBuilder
			.fromCurrentRequest()
			.path("/{id}")
			.buildAndExpand(createdRecipe.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
}
