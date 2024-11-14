package dev.taimoor_sasha.recipely;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Recipes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    private String id;
    private String userId;
    private String firstName;
    private String lastName;
    private String userPicturePath;
    private String picturePath;
    private String name;
    private String description;
    private String ingredients;

    public Recipe(String userId, String firstName, String lastName, String userPicturePath, String picturePath, String name, String description, String ingredients) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userPicturePath = userPicturePath;
        this.picturePath = picturePath;
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
    }
}
