package com.cjs.homeworkOJ.singleClassLearn;

/** 静态内部类
 * @author jinsheng
 * @date 2022年07月13日 21:16
 */
public class StaticInnerClassSingletonClass {

    private StaticInnerClassSingletonClass(){}

    private static class InnerClass{
        private static final StaticInnerClassSingletonClass INSTANCE = new StaticInnerClassSingletonClass();
    }

    public StaticInnerClassSingletonClass getInstance(){
        return InnerClass.INSTANCE;
    }
}
