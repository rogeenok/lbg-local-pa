package org.best.saintpetersburg.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members")
@Data
public class Member {

    @Id
    private String id;
    private String login;
    private String password;

// roles will be added in future (admins & users)
//    private String role;
}
