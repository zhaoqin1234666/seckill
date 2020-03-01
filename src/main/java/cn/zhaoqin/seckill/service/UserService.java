package cn.zhaoqin.seckill.service;

import cn.zhaoqin.seckill.entity.User;
import cn.zhaoqin.seckill.param.LoginParam;
import cn.zhaoqin.seckill.result.Result;

/**
 * My Blog : www.hfbin.cn
 * github: https://github.com/hfbin
 * Created by: HuangFuBin
 * Date: 2018/7/10
 * Time: 12:00
 * Such description:
 */
public interface UserService {
    Result<User> login(LoginParam loginParam);
}
