package com.xebia.designpattern.structural.adapter;

import java.util.ArrayList;
//Client deals with ArrayList<String> but not with string.
//We have provided a PrintableList interface that expects the client input.This is our target.

public interface PrintableList {
	StringBuilder printList(ArrayList<String> list);
}