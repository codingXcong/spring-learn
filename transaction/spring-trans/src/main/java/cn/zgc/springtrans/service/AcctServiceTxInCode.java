package cn.zgc.springtrans.service;

import cn.zgc.springtrans.mapper.AcctMapper;
import cn.zgc.springtrans.mapper.domain.Acct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Service
public class AcctServiceTxInCode {
    @Autowired
    private AcctMapper acctMapper;
    @Autowired
    private PlatformTransactionManager transactionManager;

    public boolean saveAcct(Acct acct){
        TransactionDefinition def = new DefaultTransactionDefinition();
        TransactionStatus transaction = transactionManager.getTransaction(def);
        try {
            acctMapper.insert(acct);
            mockRuntimeException();
            transactionManager.commit(transaction);
        } catch (Exception e) {
            transactionManager.rollback(transaction);
            throw e;
        }
        return true;
    }

    private void mockRuntimeException(){
        throw new RuntimeException("DB Error");
    }
}
