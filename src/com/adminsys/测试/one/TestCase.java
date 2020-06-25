package com.adminsys.测试.one;

public abstract class TestCase {
    private Object _OUT;
    private int _passTally;
    private int _failTally;
    //TestCase的带参数构造方法，TestCaseName表示测试用例名称，logFileName表示日志文件名称
    public TestCase(String TestCaseName) {
        _OUT = null;
        _passTally = 0;
        _failTally = 0;
    }
    //最后的测试统计结果
    public void dispose() {
        int total = totalTally();
        System.out.println("---------------------------------------------------");
        System.out.println("Summary of result:");
        System.out.println(total + " test cases be run");
        System.out.println("Pass:" + passTally());
        System.out.println("Fail:" + failTally());
    }
    //返回测试用例通过个数
    public int passTally() {
        return _passTally;
    }
    //返回测试 用例失败个数
    public int failTally() {
        return _failTally;
    }
    //返回测试用总数
    public int totalTally() {
        return _passTally + _failTally;
    }
    //释放被创建的实例资源
    public void disposeObject() {
        _OUT = null;
    }
    protected void setObject(Object outptr) {
        _OUT = outptr;
    }
    public Object getObject() {
        return _OUT;
    }
    //在测试日志中记录测试用例通过或失败的状态
    protected void logTestCaseResult(TestResult result) {
        if (result == TestResult.Fail) {
            ++_failTally;
        } else if (result == TestResult.Pass) {
            ++_passTally;
        }
    }
    //测试用例通过或失败的判断方法，参数condition为TRUE，通过量增加1，为FALSE，失败量增加1
    protected TestResult passOrFail(boolean condition) {
        if (condition) {
            return TestResult.Pass;
        } else {
            return TestResult.Fail;
        }
    }
}