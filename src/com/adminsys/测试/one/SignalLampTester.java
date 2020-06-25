package com.adminsys.测试.one;

public class SignalLampTester extends TestCase{
	//声明引用
	SignalLamp sl;
	//SignalLampTester的构造方法
	public SignalLampTester(String TestCaseName){
		//调用了父类的构造方法
		super(TestCaseName);
	}
    public SignalLamp newObject(String state){
    	sl = new SignalLamp(state);
    	return sl;
    }
	public void runAllTestSuites(){
    	testSignalLamp();
        testChangeStat();
    }
    public void testSignalLamp(){
    	setObject(newObject(SignalLamp.GREEN));
        SignalLamp SL = (SignalLamp)getObject();
        logTestCaseResult(passOrFail(SL.getState()==SignalLamp.GREEN));
        disposeObject();
    }
    public void testChangeStat(){
    	setObject(newObject(SignalLamp.RED));
        SignalLamp SL01 = (SignalLamp)getObject();
        setObject(newObject(SignalLamp.RED));
        SignalLamp SL02 = (SignalLamp)getObject();
        SL01.changeStat(SL02);
        logTestCaseResult(passOrFail(SL01.getState() != SL02.getState()));
        disposeObject();    	
    }
    public static void main(String args[]){
    	//执行测试用例SignalLampTester
    	SignalLampTester mt = new SignalLampTester("SignalLampTester");
    	mt.runAllTestSuites();
    	mt.dispose();
    	System.out.println("All Test done!");    	
    }
}