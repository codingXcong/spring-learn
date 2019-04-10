package cn.zgc.springtrans.service;

import cn.zgc.springtrans.mapper.AcctMapper;
import cn.zgc.springtrans.mapper.domain.Acct;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class AcctService implements ApplicationContextAware{
    @Autowired
    private AcctMapper acctMapper;

    private ApplicationContext applicationContext;

    @Transactional
    public void batchTransfer(TransferRequest request) {
        for(int i=0; i<10; i++) {
            /**
             * 输出：cn.zgc.springtrans.service.AcctService@4f66ffc8
             *
             * 这里的this指向target对象，即没有被代理的实际的对象，故此
             * 此处调用的transfer是没有经过AOP处理的(一般而言@Transactional注解会通过AOP动态生成代理对象)
             * 所以事务的传播机制会失效
             */
            System.out.println(this);
            transfer(request);

        /*AcctService acctService = applicationContext.getBean(AcctService.class);
        acctService.transfer(request);*/
        }
    }

    @Transactional(rollbackFor = Exception.class,propagation= Propagation.REQUIRES_NEW)
    public void transfer(TransferRequest request) {
        Acct out = new Acct(request.getOutAcctName(),request.getBalance());
        check4Out(out);
        acctMapper.transOut(out);
        //mockException();
        Acct in = new Acct(request.getInAcctName(), request.getBalance());
        acctMapper.transIn(in);
    }

    private void check4Out(Acct out){
        long bal = acctMapper.selectBalance(out.getAcctName());
        if(bal - out.getBalance() < 0) {
            throw new RuntimeException("余额不足");
        }
    }

    @Transactional(rollbackFor = Exception.class)
    public void transferNoRollback(TransferRequest request) throws IOException {
        Acct out = new Acct(request.getOutAcctName(),request.getBalance());
        acctMapper.transOut(out);
        mockException();
        //mockRuntimeException();
        Acct in = new Acct(request.getInAcctName(), request.getBalance());
        acctMapper.transIn(in);
    }

    private void mockException() throws IOException {
        throw new IOException("checked exception");
    }

    private void mockRuntimeException(){
        throw new RuntimeException("runtime exception");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }


}
