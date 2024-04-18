package com.Club.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Club.Model.Member;
public interface MemberInterface extends JpaRepository<Member, Long> {
}
