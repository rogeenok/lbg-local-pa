package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.MemberAccount;

public interface MemberAccountService {

    boolean existsByUsername(String username);

    void save(MemberAccount memberAccount);

    MemberAccount delete(String username);

    MemberAccount findByUsername(String username);
}
