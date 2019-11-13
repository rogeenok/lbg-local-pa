package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.MemberPersonalInfo;

public interface MemberPersonalInfoService {

    boolean existsByAccountID(String accountID);

    void save(MemberPersonalInfo memberPersonalInfo);

    MemberPersonalInfo deleteByAccountID(String accountID);

    MemberPersonalInfo findByAccountID(String accountID);

    MemberPersonalInfo findByName(String firstName, String lastName);
}
