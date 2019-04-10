package cn.zgc.springtrans.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MutiAcctService {
    @Autowired
    private AcctService acctService;

    @Transactional
    public void batchTransfer(TransferRequest request) {
        for(int i=0; i<10; i++) {
            acctService.transfer(request);
        }
    }
}
