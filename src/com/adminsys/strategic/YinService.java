package com.adminsys.strategic;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-02 08-57
 **/

public class YinService implements StrategicService {
    @Override
    public void getStrategic() {
        System.out.println("使用银联支付");
    }
}
