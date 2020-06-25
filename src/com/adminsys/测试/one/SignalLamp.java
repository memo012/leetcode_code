package com.adminsys.测试.one;

public class SignalLamp implements Lamp {
    //定义Lamp状态"GREEN"和"RED"
    public static final String GREEN = "GREEN";
    public static final String RED = "RED";
    private String _stat;
    //SignalLamp的构造方法,创建一个 SignalLamp实例
    public SignalLamp() {
        _stat = GREEN;
    }
    //SignalLamp的构造方法,创建一个 SignalLamp实例
    public SignalLamp(String stat) {
        _stat = stat;
    }
    //改变SignalLamp实例状态
	public void setState(String stat) {
        _stat = stat;
    }
    //获取SignalLamp实例状态
    public String getState() {
        return _stat;
    }
    //改变输入SignalLamp实例状态
    public void changeStat(Lamp lamp) {
        if (this.getState().equals(lamp.getState())) {
            if (this.getState().equals(RED)) {
                lamp.setState(GREEN);
            } else if (this.getState().equals(GREEN)) {
                lamp.setState(RED);
            }
        }
    }
}