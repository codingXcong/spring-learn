package cn.zgc.springtrans;

import cn.zgc.springtrans.mapper.domain.Acct;
import cn.zgc.springtrans.service.AcctServiceTxInCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootTest(classes = SpringTransApplication.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class AcctServiceTxInCodeTest {
    @Autowired
    private AcctServiceTxInCode acctServiceTxInCode;

    @Test
    public void testSaveAcct(){
        Acct acct = new Acct("jack",2000);
        acctServiceTxInCode.saveAcct(acct);
    }
}
