package cn.zgc.ssm.mapper;

import cn.zgc.ssm.po.Items;
import cn.zgc.ssm.po.QueryVo;

import java.util.List;

public interface ItemsMapper {
    //商品列表
    public List<Items> findItemsList(QueryVo queryVo) throws Exception;

}
