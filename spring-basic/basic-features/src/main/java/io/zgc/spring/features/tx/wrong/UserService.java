package io.zgc.spring.features.tx.wrong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.io.FileNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	/** 要想事务生效，必须通过代理类来调用事务方法 */
	@Autowired
	private UserService self;

	public void insertUserWrong1(boolean hasException) {
		insertUserPrivate(hasException);
	}

	/**
	 * 自调用
	 * @param hasException
	 */
	public void insetUserWrong2(boolean hasException) {
		insertUserPublic(hasException);
	}

	public void insertUserRight(boolean hasException) {
		self.insertUserPublic(hasException);
	}


	/**
	 * @Transactional 不能放在private方法上，不然事务不生效
	 * @param hasException
	 */
	@Transactional
	private void insertUserPrivate(boolean hasException){
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	}

	@Transactional
	public void insertUserPublic(boolean hasException){
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	}

	@Transactional
	public void insertUserWrong3(boolean hasException){
		try {
			userDao.insert();
			System.out.println("...");
			if (hasException) {
				int i = 10 / 0;
			}
		} catch (Exception e) {
			System.out.println("------------------");
			/* 异常被吃掉了，事务无法回滚 */
			e.printStackTrace();
		}
	}

	@Transactional
	public void insertUserWrong4() throws FileNotFoundException {
		userDao.insert();
		System.out.println("...");
		throw new FileNotFoundException();

	}

@Transactional
public void insertUserRight3(boolean hasException){
	try {
		userDao.insert();
		System.out.println("...");
		if (hasException) {
			int i = 10 / 0;
		}
	} catch (Exception e) {
		e.printStackTrace();
		// 手动设置让当前事务处于回滚状态
		TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
	}
}

	@Transactional(rollbackFor = Exception.class)
	public void insertUserRight4() throws FileNotFoundException {
		userDao.insert();
		System.out.println("...");
		throw new FileNotFoundException();

	}

}