package dev.taimoor_sasha.recipely;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<List<Recipe>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{name}")
    public ResponseEntity<Optional<Recipe>> getSingleRecipe(@PathVariable String name) {
        return new ResponseEntity<Optional<Recipe>>(recipeService.singleRecipe(name), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Recipe>(recipeService.createRecipe(payload.get("userId"), payload.get("firstName"), payload.get("lastName"), payload.get("userPicturePath"), payload.get("picturePath"), payload.get("name"), payload.get("description"), payload.get("ingredients")), HttpStatus.CREATED);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<Optional<Recipe>> deleteSingleRecipe(@PathVariable String name) {
        return new ResponseEntity<Optional<Recipe>>(recipeService.deleteRecipe(name), HttpStatus.OK);
    }

}
