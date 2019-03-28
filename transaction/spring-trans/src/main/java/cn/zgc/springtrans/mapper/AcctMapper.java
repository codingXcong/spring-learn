package cn.zgc.springtrans.mapper;

import cn.zgc.springtrans.mapper.domain.Acct;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface AcctMapper {
    int transIn(Acct acct);
    int transOut(Acct acct);
}
