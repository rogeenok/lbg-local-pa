package org.best.saintpetersburg.backend.persistance.members;

import org.best.saintpetersburg.backend.model.MemberAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberAccountRepository extends MongoRepository<MemberAccount, String>{

    MemberAccount findByLogin(String login);

    boolean existsByLogin(String login);
}