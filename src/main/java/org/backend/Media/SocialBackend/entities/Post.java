package org.backend.Media.SocialBackend.entities;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Document(collection = "post_collection")
public class Post {
    @Id
    private String id;
    private String userName;
    private String title;
    private String description;
    private String url_to_Image;
}
