package cn.zgc.springtrans;

import cn.zgc.springtrans.mapper.domain.Acct;
import cn.zgc.springtrans.service.AcctService;
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
    @Test
    public void testTransfer() throws IOException {
        Acct in = new Acct("tom",100);
        Acct out = new Acct("jerry",100);
        acctService.transfer(in,out);
    }
}
