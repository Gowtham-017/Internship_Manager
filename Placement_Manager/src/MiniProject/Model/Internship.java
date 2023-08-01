package MiniProject.Model;

public class Internship {
	
    private int id;
    private String company;
    private int duration;
    private String role;
    private String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Internship(int id, String company, int duration, String role, String description) {
		super();
		this.id = id;
		this.company = company;
		this.duration = duration;
		this.role = role;
		this.description = description;
	}
    public Internship() {
    	
    }
}
