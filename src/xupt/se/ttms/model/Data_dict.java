package xupt.se.ttms.model;

public class Data_dict {

	private int dict_id;
	private int dict_parent_id;
	private int dict_index;
	private String dict_name;
	private String value;
	public int getDict_id() {
		return dict_id;
	}
	public void setDict_id(int dict_id) {
		this.dict_id = dict_id;
	}
	public int getDict_parent_id() {
		return dict_parent_id;
	}
	public void setDict_parent_id(int dict_parent_id) {
		this.dict_parent_id = dict_parent_id;
	}
	public int getDict_index() {
		return dict_index;
	}
	public void setDict_index(int dict_index) {
		this.dict_index = dict_index;
	}
	public String getDict_name() {
		return dict_name;
	}
	public void setDict_name(String dict_name) {
		this.dict_name = dict_name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
}
