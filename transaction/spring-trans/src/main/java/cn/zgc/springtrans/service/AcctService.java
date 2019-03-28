package cn.zgc.springtrans.service;

import cn.zgc.springtrans.mapper.AcctMapper;
import cn.zgc.springtrans.mapper.domain.Acct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

@Service
public class AcctService {
    @Autowired
    private AcctMapper acctMapper;

    @Transactional(rollbackFor = RuntimeException.class)
    public void transfer(Acct in,Acct out) throws IOException {
        acctMapper.transOut(out);
        mockException();
        acctMapper.transIn(in);
    }

    private void mockException() throws IOException {
        throw new IOException("runtime error");

    }
}
