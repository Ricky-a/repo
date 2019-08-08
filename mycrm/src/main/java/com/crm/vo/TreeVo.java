package com.crm.vo;

import java.util.List;

/**
 * 
 * @author admin
 *
 */
public class TreeVo {

	private int id;
	private String text;
	private String state;
	private boolean checked;
	private TreeData attributes;
	private List<TreeVo> children;

	public TreeVo() {
		super();
	}

	public TreeVo(int id, String text, String state, boolean checked, TreeData attributes) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
	}

	public TreeVo(int id, String text, String state, boolean checked, TreeData attributes, List<TreeVo> children) {
		super();
		this.id = id;
		this.text = text;
		this.state = state;
		this.checked = checked;
		this.attributes = attributes;
		this.children = children;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public TreeData getAttributes() {
		return attributes;
	}

	public void setAttributes(TreeData attributes) {
		this.attributes = attributes;
	}

	public List<TreeVo> getChildren() {
		return children;
	}

	public void setChildren(List<TreeVo> children) {
		this.children = children;
	}

	@Override
	public String toString() {
		return "TreeDtos [id=" + id + ", text=" + text + ", state=" + state + ", checked=" + checked + ", attributes="
				+ attributes + ", children=" + children + "]";
	}

}
