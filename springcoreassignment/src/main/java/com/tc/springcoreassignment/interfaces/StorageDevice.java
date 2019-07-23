package com.tc.springcoreassignment.interfaces;

import org.springframework.beans.factory.annotation.Qualifier;


public interface StorageDevice {
	void write();
	void read();
	void format();
}
