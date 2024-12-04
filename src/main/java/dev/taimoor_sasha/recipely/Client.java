package dev.taimoor_sasha.recipely;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "Clients")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;

    public Client (String firstName, String lastName, String userName, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
    }


}

