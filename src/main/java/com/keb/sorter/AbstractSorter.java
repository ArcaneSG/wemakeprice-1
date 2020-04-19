package com.keb.sorter;

public abstract class AbstractSorter {
	String input;
	
	String output;
	
	public String getResult(String input) {
		init(input);
		sort();
		merge();
		setOutput();
		
		return output;
	}
	
	void init(String input) {
		this.input = input;
	};
	
	abstract void sort();
	abstract void merge();
	abstract void setOutput();
}
