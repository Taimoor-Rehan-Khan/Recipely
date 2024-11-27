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
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private ClientService clientService;
    @GetMapping
    public ResponseEntity<List<Recipe>> getAllRecipes() {
        return new ResponseEntity<List<Recipe>>(recipeService.allRecipes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Recipe>> getSingleRecipe(@PathVariable String id) {
        return new ResponseEntity<Optional<Recipe>>(recipeService.singleRecipe(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Recipe> createRecipe(@RequestBody Map<String, String> payload) {
        Client client = clientService.singleClient(payload.get("userId"));
        System.out.print(client);
        return new ResponseEntity<Recipe>(recipeService.createRecipe(client.getId(), client.getFirstName(), client.getLastName(), payload.get("name"), payload.get("description"), payload.get("ingredients")), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Recipe>> deleteSingleRecipe(@PathVariable String id) {
        return new ResponseEntity<Optional<Recipe>>(recipeService.deleteRecipe(id), HttpStatus.OK);
    }

}
