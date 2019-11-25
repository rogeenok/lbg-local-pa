package org.best.saintpetersburg.backend.persistance.members;

import org.best.saintpetersburg.backend.model.MemberPersonalInfo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberPersonalInfoRepository extends MongoRepository<MemberPersonalInfo, String> {

    MemberPersonalInfo findByAccountID(String accountID);

    MemberPersonalInfo findByLastNameEngAndFirstNameEng(String lastNameEng, String firstNameEng);

    boolean existsByAccountID(String accountID);
}
