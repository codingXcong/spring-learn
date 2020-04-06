package io.zgc.spring.features.tx.propagation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserService self;
	
	@Transactional
	public void insertUser(boolean hasException){
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	}

	/**
	 * 一个用户都不会插入，事务的传播行为是REQUIRED
	 * 两个self.insertUser方法共用insetBatchUserWithRequred方法开启的事务
	 *
	 * 事务最终由于self.insertUser(true);执行抛出异常，而回滚
	 */
	@Transactional
	public void insetBatchUserWithRequred() {
		self.insertUser(false);

		self.insertUser(true);
	}

	/**
	 * 会插入1个用户，因为事务的传播行为为REQUIRES_NEW
	 * self.insertUserRn(false); 开启单独的事务，并成功执行
	 * self.insertUserRn(true); 开启单独的事务，执行失败
	 *
	 * insetBatchUserWithRequredNew的事务不会受self.insertUserRn(true)开启的事务影响
	 */
	@Transactional
	public void insetBatchUserWithRequredNew() {
		self.insertUserRn(false);

		self.insertUserRn(true);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void insertUserRn(boolean hasException){
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	}

}