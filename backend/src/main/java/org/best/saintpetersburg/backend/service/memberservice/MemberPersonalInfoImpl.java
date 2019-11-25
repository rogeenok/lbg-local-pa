package org.best.saintpetersburg.backend.service.memberservice;

import org.best.saintpetersburg.backend.model.MemberPersonalInfo;
import org.best.saintpetersburg.backend.persistance.members.MemberPersonalInfoRepository;
import org.springframework.stereotype.Service;

@Service
public class MemberPersonalInfoImpl implements MemberPersonalInfoService {

    private MemberPersonalInfoRepository memberPersonalInfoRepository;

    MemberPersonalInfoImpl(MemberPersonalInfoRepository memberPersonalInfoRepository) { this.memberPersonalInfoRepository = memberPersonalInfoRepository; }

    @Override
    public boolean existsByAccountID(String accountID) {
        return memberPersonalInfoRepository.existsByAccountID(accountID);
    }

    @Override
    public void save(MemberPersonalInfo memberPersonalInfo) {
        memberPersonalInfoRepository.save(memberPersonalInfo);
    }

    @Override
    public MemberPersonalInfo deleteByAccountID(String accountID) {
        // TEMPORARY NOT AVAILABLE
        return null;
    }

    @Override
    public MemberPersonalInfo findByAccountID(String accountID) {
        return memberPersonalInfoRepository.findByAccountID(accountID);
    }

    @Override
    public MemberPersonalInfo findByName(String firstName, String lastName) {
        return memberPersonalInfoRepository.findByLastNameEngAndFirstNameEng(lastName, firstName);
    }
}
