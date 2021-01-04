package com.example.model;

import java.util.ArrayList;

public class ArrayOfData {
	ArrayList<String> data = new ArrayList<String>();

	public ArrayOfData(ArrayList<String> data) {
		super();
		this.data = data;
	}

	public ArrayOfData() {
		super();
	}

	public ArrayList<String> getData() {
		return data;
	}

	public void setData(ArrayList<String> data) {
		this.data = data;
	}

}
