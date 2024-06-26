package com.bit2024.mysite.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2024.mysite.vo.UserVo;

@Repository
public class UserRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public Boolean insert(UserVo vo) {
		return  1 == sqlSession.insert("user.insert", vo);
	}

	public UserVo findByEmailAndPassword(String email, String password) {
		Map<String, Object> map =new HashMap<>();
		map.put("email", email);
		map.put("password", password);
		
		return sqlSession.selectOne("user.findByEmailAndPassword", map);
	}
}