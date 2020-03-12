package entities;

public class TableStatus {
    
        public static final int EMPTY = 1;
        
        public static final int FULL = 2;
        
        public static final int ORDERED = 3;
        
	private Integer id;
	private String name;
	
	public TableStatus() {
	}
	
	public TableStatus(Integer id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
