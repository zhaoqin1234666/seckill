package cn.zhaoqin.seckill.controller;

import cn.zhaoqin.seckill.bo.GoodsBo;
import cn.zhaoqin.seckill.entity.OrderInfo;
import cn.zhaoqin.seckill.entity.User;
import cn.zhaoqin.seckill.redis.RedisService;
import cn.zhaoqin.seckill.redis.UserKey;
import cn.zhaoqin.seckill.result.CodeMsg;
import cn.zhaoqin.seckill.result.Result;
import cn.zhaoqin.seckill.service.SeckillGoodsService;
import cn.zhaoqin.seckill.service.SeckillOrderService;
import cn.zhaoqin.seckill.vo.OrderDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/19
 * Time: 0:56
 * Such description:
 */
@Controller
@RequestMapping("/order")
public class SeckillOrderController {
    @Autowired
    RedisService redisService;
    @Autowired
    SeckillOrderService seckillOrderService;
    @Autowired
    SeckillGoodsService seckillGoodsService;

    /**
     * @param model
     * @param orderId
     * @param request
     * @param session
     * @return
     */
    @RequestMapping("/detail")
    @ResponseBody
    public Result<OrderDetailVo> info(
            Model model,
            @RequestParam("orderId") long orderId ,
            HttpServletRequest request,
            HttpSession session)
    {
        User user = redisService.get(UserKey.getByName, session.getId(), User.class);
        if(user == null) {
            return Result.error(CodeMsg.USER_NO_LOGIN);
        }
        OrderInfo order = seckillOrderService.getOrderInfo(orderId);
        if(order == null) {
            return Result.error(CodeMsg.ORDER_NOT_EXIST);
        }
        long goodsId = order.getGoodsId();
        GoodsBo goods = seckillGoodsService.getseckillGoodsBoByGoodsId(goodsId);
        OrderDetailVo vo = new OrderDetailVo();
        vo.setOrder(order);
        vo.setGoods(goods);
        return Result.success(vo);
    }
}
