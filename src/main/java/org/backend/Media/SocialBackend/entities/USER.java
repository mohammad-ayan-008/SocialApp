package org.backend.Media.SocialBackend.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user_data")
public class USER {
    @Id
    private String id;
    @Indexed(unique = true)
    @NonNull
    private String userName;

    @NonNull
    private String password;
    @DBRef
    private List<Post> users_posts = new ArrayList<>();

    private List<String> Roles = new ArrayList<>();
}
