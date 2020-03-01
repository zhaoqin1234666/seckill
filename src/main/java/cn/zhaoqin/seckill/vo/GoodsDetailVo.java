package cn.zhaoqin.seckill.vo;

import cn.zhaoqin.seckill.bo.GoodsBo;
import cn.zhaoqin.seckill.entity.User;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by: HuangFuBin
 * Date: 2018/7/19
 * Time: 0:38
 * Such description:
 */
@Getter
@Setter
public class GoodsDetailVo {
    private int miaoshaStatus = 0;
    private int remainSeconds = 0;
    private GoodsBo goods ;
    private User user;

}
