package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.Member;

public interface MemberService {

    boolean existsByUsername(String username);

    void save(Member member);

    Member delete(String username);

    Member findByUsername(String username);
}
