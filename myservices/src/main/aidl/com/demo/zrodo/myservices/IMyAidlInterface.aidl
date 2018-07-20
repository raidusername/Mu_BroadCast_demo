// IMyAidlInterface.aidl
package com.demo.zrodo.myservices;

// Declare any non-default types here with import statements

interface IMyAidlInterface {
    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat,
            double aDouble, String aString);
    //自定义获取当前精度
    void showProcess();
}
