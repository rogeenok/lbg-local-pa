package org.best.saintpetersburg.backend.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "members_accounts")
@Data
public class MemberAccount {

    @Id
    private String id;
    private String username;
    private String password;

// roles will be added in future (admins & users)
//    private String role;
}
