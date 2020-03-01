package cn.zhaoqin.seckill.service.ipml;

import cn.zhaoqin.seckill.dao.OrdeInfoMapper;
import cn.zhaoqin.seckill.entity.OrderInfo;
import cn.zhaoqin.seckill.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/17
 * Time: 10:50
 * Such description:
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrdeInfoMapper ordeInfoMapper;

    @Override
    public long addOrder(OrderInfo orderInfo) {
        return ordeInfoMapper.insertSelective(orderInfo);
    }

    @Override
    public OrderInfo getOrderInfo(long orderId) {
        return ordeInfoMapper.selectByPrimaryKey(orderId);
    }
}
