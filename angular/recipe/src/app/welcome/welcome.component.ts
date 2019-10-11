import { Component, OnInit } from '@angular/core';
import { RecipeDataService } from '../service/data/recipe-data.service';
import { Router } from '@angular/router';
import { Recipe } from '../recipes/recipes.component';
import { welcome } from '../../datamodel/welcome.model';

@Component({
  selector: 'app-welcome',
  templateUrl: './welcome.component.html',
  styleUrls: ['./welcome.component.css']
})
export class WelcomeComponent implements OnInit {

  welcome: welcome[] = [];
  name : string;
  recipes: Recipe[]
  message: string

  // recipes = [
  //   new Recipe(1, 'Pizza', "Here's an appetizer that's exciting and unique!"),
  //   new Recipe(2, 'Pancake', "Tall, fluffy pancakes make the best breakfast"),
  //   new Recipe(3, 'Lasagne', "Layers and layers of deliciosness.")
  // ]
  constructor(private recipeDataService : RecipeDataService,
    private router : Router
  ) { }

  ngOnInit() {
    this.refreshRecipes();
    this.welcome = [];
  }

  refreshRecipes() {
    this.recipeDataService.retrieveAllRecipes().subscribe(
      response => {
        console.log(response);
        this.recipes = response;
      }
    )
  }
 //when you fetch collection from server.
  // deleteRecipe(id) {
  //   this.recipeDataService.deleteRecipe(id).subscribe(
  //     response => {
  //       this.message = 'Delete Successful!'
  //       this.refreshRecipes();
  //     }
  //   )
  // }

  showRecipe(id) {
    console.log(`update ${id}`)
    this.router.navigate(['recipes',id])
  }

  updateRecipe(id) {
    console.log(`update ${id}`)
    this.router.navigate(['recipes',id])
  }

  addRecipe() {
    this.router.navigate(['recipes', -1])
  }

  // searchRecipe() {
  //   this.router.navigate(['searchrecipe',name])
  // }

  // search() {
  //   this.welcome = this.welcome.filter(res=>{
  //     return res.name.toLocaleLowerCase().match(this.name.toLocaleLowerCase());
  //   }
  //     )
  // }
 
}
