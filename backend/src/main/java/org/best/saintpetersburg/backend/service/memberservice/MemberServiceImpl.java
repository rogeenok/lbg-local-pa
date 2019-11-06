package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.Member;
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
    public void save(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member delete(String username) {
        // TEMPORARY NOT AVAILABLE
        return null;
    }

    @Override
    public Member findByUsername(String username) {
        return memberRepository.findByLogin(username);
    }
}
