package com.example.empdemo.jpa;
/**
 * 
 * @author kisho
 *
 */
public class SearchCriteria {
    private String filterKey;
    private Object value;
    private String operation;
    private String dataOption;

    public SearchCriteria(String filterKey, String operation, 
                          Object value){
        super();
        this.filterKey = filterKey;
        this.operation = operation;
        this.value = value;
    }

	public String getDataOption() {
		return dataOption;
	}

	public void setDataOption(String dataOption) {
		this.dataOption = dataOption;
	}

	public String getFilterKey() {
		return filterKey;
	}

	public Object getValue() {
		return value;
	}

	public String getOperation() {
		return operation;
	}

	
}
