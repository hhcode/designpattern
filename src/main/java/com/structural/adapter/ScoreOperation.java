package com.structural.adapter;

public interface ScoreOperation {
	/**
	 * 成绩排序
	 * 
	 * @param array
	 * @return
	 */
	public int[] sort(int array[]);

	/**
	 * 成绩查找
	 * 
	 * @param array
	 * @param key
	 * @return
	 */
	public int search(int array[], int key);
}
