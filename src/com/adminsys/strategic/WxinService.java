package com.adminsys.strategic;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 08-56
 **/

public class WxinService implements StrategicService {
    @Override
    public void getStrategic() {
        System.out.println("使用微信支付");
    }
}
