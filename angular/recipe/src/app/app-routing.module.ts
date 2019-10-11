import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { WelcomeComponent } from './welcome/welcome.component';
import { ErrorComponent } from './error/error.component';
import { RecipesComponent } from './recipes/recipes.component';
import { FavouritesComponent } from './favourites/favourites.component';
import { LogoutComponent } from './logout/logout.component';
import { RouteGuardServiceService } from './service/route-guard-service.service';
import { UpdateRecipeComponent } from './update-recipe/update-recipe.component';
import { MyRecipesComponent } from './my-recipes/my-recipes.component';

const routes: Routes = [
  { path:'', component: WelcomeComponent},
  { path:'login', component: LoginComponent},
  { path: 'welcome', component: WelcomeComponent},
  { path: 'searchrecipe/:name', component: WelcomeComponent},
  { path: 'recipes/:id', component: RecipesComponent},
  { path: 'favourites', component: FavouritesComponent, canActivate:[RouteGuardServiceService]},
  { path: 'recipes', component: MyRecipesComponent, canActivate:[RouteGuardServiceService]},
  { path: 'jpa/updaterecipe/:id', component: UpdateRecipeComponent, canActivate:[RouteGuardServiceService]},
  { path: 'addrecipe/:id', component: UpdateRecipeComponent, canActivate:[RouteGuardServiceService]},
  { path: 'logout', component: LogoutComponent, canActivate:[RouteGuardServiceService]},
  { path: '**', component: ErrorComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
