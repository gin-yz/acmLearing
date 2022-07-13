package com.cjs.homeworkOJ.singleClassLearn;

/** 双标志检查法
 * @author jinsheng
 * @date 2022年07月12日 23:04
 */
public class TwoSignalSingletonClass {
    private volatile static TwoSignalSingletonClass INSTANCE;

    private TwoSignalSingletonClass() {
    }

    public TwoSignalSingletonClass getInstance() {
        if (null == INSTANCE) {
            synchronized (TwoSignalSingletonClass.class) {
                if(null == INSTANCE){
                    INSTANCE = new TwoSignalSingletonClass();
                }
            }
        }
        return INSTANCE;
    }
}
