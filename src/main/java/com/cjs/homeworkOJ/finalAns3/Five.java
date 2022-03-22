package com.cjs.homeworkOJ.finalAns3;

public class Five {
    public static int minOperate(int[] heightToys){
        int minOperate = 0;
        for (int i = heightToys.length-1;i>0;i--){
            if (heightToys[i]<heightToys[i-1]) minOperate += heightToys[i-1]-heightToys[i];
        }
        return minOperate;
    }
}
