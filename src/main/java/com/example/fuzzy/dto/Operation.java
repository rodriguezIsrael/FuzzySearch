package com.example.fuzzy.dto;

import com.example.fuzzy.enums.OperationEnum;

public class Operation {

	private OperationEnum operatioEnumn;
	private String json;

	public OperationEnum getOperationEnum() {
		return operatioEnumn;
	}

	public void setOperationEnum(OperationEnum operationEnum) {
		this.operatioEnumn = operationEnum;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Operation [");
		if (operatioEnumn != null) {
			builder.append("operatioEnumn=");
			builder.append(operatioEnumn);
			builder.append(", ");
		}
		if (json != null) {
			builder.append("json=");
			builder.append(json);
		}
		builder.append("]");
		return builder.toString();
	}

}
