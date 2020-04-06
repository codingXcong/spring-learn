package io.zgc.spring.features.tx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Transactional
	public void insertUser(){
		userDao.insert();
		System.out.println("...");
		int i = 10/0;
	}

}