package cn.zgc.springtrans.mapper;

import cn.zgc.springtrans.mapper.domain.Acct;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AcctMapper {
    int transIn(Acct acct);
    int transOut(Acct acct);
    long selectBalance(String acctName);
    int insert(Acct acct);
}
