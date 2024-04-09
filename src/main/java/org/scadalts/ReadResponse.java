package org.scadalts;

import org.apache.plc4x.java.api.messages.PlcReadResponse;

public class ReadResponse extends PlcReadResponse {
	public void print() {
		for (String tagName: getTagNames()) {
			String value = getObject(tagName);
			System.out.println(String.format("%s => %s", tagName, value));
		}
	}
}

