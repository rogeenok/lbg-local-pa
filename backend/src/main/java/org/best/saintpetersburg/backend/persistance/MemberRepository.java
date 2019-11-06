package org.best.saintpetersburg.backend.persistance;

import org.best.saintpetersburg.backend.model.Member;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends MongoRepository<Member, String>{

    Member findByLogin(String login);

    boolean existsByLogin(String login);
}
