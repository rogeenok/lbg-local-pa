package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.MemberAccount;
import org.best.saintpetersburg.backend.persistance.members.MemberAccountRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberAccountServiceImpl implements MemberAccountService {
    private MemberAccountRepository memberAccountRepository;

    MemberAccountServiceImpl(MemberAccountRepository memberAccountRepository) { this.memberAccountRepository = memberAccountRepository; }


    @Override
    public boolean existsByUsername(String username) {
        return memberAccountRepository.existsByUsername(username);
    }

    @Override
    public void save(MemberAccount memberAccount) {
        memberAccountRepository.save(memberAccount);
    }

    @Override
    public MemberAccount delete(String username) {
        // TEMPORARY NOT AVAILABLE
        return null;
    }

    @Override
    public MemberAccount findByUsername(String username) {
        return memberAccountRepository.findByUsername(username);
    }
}
