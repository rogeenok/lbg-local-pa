package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.MemberAccount;
import org.best.saintpetersburg.backend.persistance.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    private MemberRepository memberRepository;

    MemberServiceImpl(MemberRepository memberRepository) { this.memberRepository = memberRepository; }


    @Override
    public boolean existsByUsername(String username) {
        return memberRepository.existsByLogin(username);
    }

    @Override
    public void save(MemberAccount memberAccount) {
        memberRepository.save(memberAccount);
    }

    @Override
    public MemberAccount delete(String username) {
        // TEMPORARY NOT AVAILABLE
        return null;
    }

    @Override
    public MemberAccount findByUsername(String username) {
        return memberRepository.findByLogin(username);
    }
}
