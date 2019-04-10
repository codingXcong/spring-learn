package cn.zgc.springtrans;

import cn.zgc.springtrans.mapper.domain.Acct;
import cn.zgc.springtrans.service.AcctService;
import cn.zgc.springtrans.service.MutiAcctService;
import cn.zgc.springtrans.service.TransferRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

@SpringBootTest(classes = SpringTransApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AcctServiceTest {
    @Autowired
    private AcctService acctService;
    @Autowired
    private MutiAcctService mutiAcctService;

    @Test
    public void testTransfer() throws IOException {
        TransferRequest req = new TransferRequest("jerry","tom",600);
        acctService.transfer(req);
    }

    @Test
    public void testTransferNoRollback() throws IOException {
        TransferRequest req = new TransferRequest("jerry","tom",600);
        acctService.transferNoRollback(req);
    }

    @Test
    public void testBatchTransfer() throws IOException {
        TransferRequest req = new TransferRequest("jerry","tom",101);
        acctService.batchTransfer(req);
    }

    @Test
    public void testBatchTransfer_传播机制生效() throws IOException {
        TransferRequest req = new TransferRequest("jerry","tom",101);
        mutiAcctService.batchTransfer(req);
    }
}
