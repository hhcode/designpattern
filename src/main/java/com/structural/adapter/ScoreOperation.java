package com.structural.adapter;

public interface ScoreOperation {
    /**
     * 成绩排序
     *
     * @param array
     * @return
     */
    int[] sort(int[] array);

    /**
     * 成绩查找
     *
     * @param array
     * @param key
     * @return
     */
    int search(int[] array, int key);
}
