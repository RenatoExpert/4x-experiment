package org.scadalts;

import org.apache.plc4x.java.api.messages.PlcReadResponse;

public class ReadResponse {
	PlcReadResponse raw;
	public ReadResponse(PlcReadResponse plcResponse) {
		raw = plcResponse;
	}
	public void print() {
		for (String tagName: raw.getTagNames()) {
			String value = raw.getObject(tagName);
			System.out.println(String.format("%s => %s", tagName, value));
		}
	}
}

