package dev.taimoor_sasha.recipely;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    private String password;

    // Add other profile fields if needed

    // Add Getters and Setters if needed
}
