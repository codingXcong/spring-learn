package io.zgc.spring.features.tx.usetype.xml;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service("userServiceTarget")
public class UserService {
	
	@Autowired
	private UserDao userDao;

	public void insertUser(boolean hasException){
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	}

}