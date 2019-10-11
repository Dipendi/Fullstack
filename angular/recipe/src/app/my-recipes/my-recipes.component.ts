import { Component, OnInit } from '@angular/core';
import { RecipeDataService } from '../service/data/recipe-data.service';
import { Recipe } from '../recipes/recipes.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-my-recipes',
  templateUrl: './my-recipes.component.html',
  styleUrls: ['./my-recipes.component.css']
})
export class MyRecipesComponent implements OnInit {

  recipes: Recipe[]
  message: string

  constructor(private recipeDataService : RecipeDataService,
    private router : Router
  ) { }

  ngOnInit() {
    this.refreshRecipes();
  }

  refreshRecipes() {
    this.recipeDataService.retrieveAllRecipes().subscribe(
      response => {
        console.log(response);
        this.recipes = response;
      }
    )
  }
  deleteRecipe(id) {
    this.recipeDataService.deleteRecipe('Dipendi',id).subscribe(
      response => {
        this.message = 'Delete Successful!'
        this.refreshRecipes();
      }
    )
  }

  showRecipe(id) {
    console.log(`update ${id}`)
    this.router.navigate(['recipes',id])
  }

  updateRecipe(id) {
    console.log(`update ${id}`)
    this.router.navigate(['jpa/updaterecipe',id])
  }

  addRecipe() {
    this.router.navigate(['addrecipe', -1])
  }

}

