import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Recipe } from 'src/app/recipes/recipes.component';

@Injectable({
  providedIn: 'root'
})
export class RecipeDataService {

  constructor(
    private http:HttpClient
  ) { }

  retrieveAllRecipes() {
    return this.http.get<Recipe[]>('http://localhost:8080/jpa/recipes')
  }

  deleteRecipe(username, id) {
    return this.http.delete(`http://localhost:8080/jpa/users/${username}/recipes/${id}`)
  }

  retrieveRecipe(id) {
    return this.http.get<Recipe>(`http://localhost:8080/jpa/recipes/${id}`)
  }

  updateRecipe(username, id, recipe) {
    return this.http.put<Recipe>(`http://localhost:8080/jpa/users/${username}/recipes/${id}`, recipe)
  }

  createRecipe(username, recipe) {
    return this.http.post<Recipe>(`http://localhost:8080/jpa/users/${username}/recipes`, recipe)
  }

  searchRecipe(name) {
    return this.http.get<Recipe>(`http://localhost:8080/jpa/recipes/${name}`)
  }
}