package io.zgc.spring.features.tx.usetype.anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userServiceTarget")
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Transactional
	public void insertUser(boolean hasException){
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	}

}