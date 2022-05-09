package com.huawei.classroom.student.h13;

public class Word implements Comparable<Word>{

	private String word;
	private int count;
	
	@Override
	public int compareTo(Word o) {
		// TODO Auto-generated method stub
		if (this.count != o.count) {
			return -Integer.valueOf(this.count).compareTo(o.count);
		} else {
			return this.word.compareTo(o.word);
		}
	}

	public Word(String word, int count) {
		super();
		this.word = word;
		this.count = count;
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
