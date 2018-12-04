package cn.zgc.ssm.service;

import cn.zgc.ssm.mapper.ItemsMapper;
import cn.zgc.ssm.po.Items;
import cn.zgc.ssm.po.QueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class OrderService {
    @Autowired
    private ItemsMapper itemsMapper;

    public List<Items> findItemsList(QueryVo queryVo) throws Exception {
        //查询商品信息
        return itemsMapper.findItemsList(queryVo);
    }

}
