package kr.or.connect.todo.dto;

public class Todo {
	private Integer id; //순서
	private String title; //할일 제목
	private String name; //넣은 사람
	private Integer sequence; //순위
	private String type; //어디에 위치해있는지
	private String redate; //작성 날짜
	
	public Todo() {
		
	}
	
	public Todo(Integer id, String title, String name, Integer sequence, String type, String redate) {
		super();
		this.id = id;
		this.title = title;
		this.name = name;
		this.sequence = sequence;
		this.type = type;
		this.redate = redate;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getSequence() {
		return sequence;
	}
	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getRedate() {
		return redate;
	}
	public void setRedate(String redate) {
		this.redate = redate;
	}
	
	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", name=" + name + ", sequence=" + sequence + ", type=" + type
				+ ", redate=" + redate + "]";
	}	

}
