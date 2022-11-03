package com.stussy.stussyclone20220930oh.repository;

import com.stussy.stussyclone20220930oh.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper // IoC 등록 됨.
public interface AccountRepository {
// 구현부는 mappers의 xml이다.
    public User findUserByEmail(String email) throws Exception;
    public int saveUser(User user) throws Exception;
    public int updateProvider(User user) throws Exception;
}
