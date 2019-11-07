package org.best.saintpetersburg.backend.persistance;

import org.best.saintpetersburg.backend.model.MemberAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<MemberAccount, String>{

    MemberAccount findByLogin(String login);

    boolean existsByLogin(String login);
}
