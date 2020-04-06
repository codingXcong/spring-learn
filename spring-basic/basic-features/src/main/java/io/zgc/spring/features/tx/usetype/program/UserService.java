package io.zgc.spring.features.tx.usetype.program;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private TransactionTemplate transactionTemplate;

	/**
	 * 编程式事务
	 */
	public void insertUser(boolean hasException){
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				userDao.insert();
				System.out.println("...");
				if (hasException) {
					int i = 10 / 0;
				}
			}
		});
	}

}