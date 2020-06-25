package com.adminsys.测试.one;

public class TestResult {
    private String _value;
    public static final TestResult Fail = new TestResult("Fail");
    public static final TestResult Pass = new TestResult("Pass");
    public TestResult(String value) {
        _value = value;
    }
    public String toString() {
        return _value;
    }
}