package dev.taimoor_sasha.recipely;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/recipes")
public class RecipeController {

    @Autowired
    private RecipeService recipeService;

    // Get all recipes for the authenticated user
    @GetMapping
    public ResponseEntity<List<Recipe>> getUserRecipes() {
        return new ResponseEntity<>(recipeService.getUserRecipes(), HttpStatus.OK);
    }

    // Get a single recipe by name for the authenticated user
    @GetMapping("/{name}")
    public ResponseEntity<Optional<Recipe>> getSingleRecipe(@PathVariable String name) {
        return new ResponseEntity<>(recipeService.singleRecipe(name), HttpStatus.OK);
    }

    // Create a new recipe for the authenticated user
    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Map<String, String> payload) {
        Recipe recipe = recipeService.createRecipe(
                payload.get("firstName"),
                payload.get("lastName"),
                payload.get("userPicturePath"),
                payload.get("picturePath"),
                payload.get("name"),
                payload.get("description"),
                payload.get("ingredients")
        );
        return new ResponseEntity<>(recipe, HttpStatus.CREATED);
    }

    // Delete a single recipe by name
    @DeleteMapping("/{name}")
    public ResponseEntity<Optional<Recipe>> deleteSingleRecipe(@PathVariable String name) {
        return new ResponseEntity<>(recipeService.deleteRecipe(name), HttpStatus.OK);
    }
}
