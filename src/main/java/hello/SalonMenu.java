package hello;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="menu")
public class SalonMenu {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	int id;
	String name;
	int type;
	
	
	public SalonMenu(String name, String price, String description) {
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public SalonMenu(int id, String name, String price, String description) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.description = description;
	}
	public SalonMenu() {
		super();
		// TODO Auto-generated constructor stub
	}
	String price;
	String description;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public SalonMenu(String name, int type, String price,
			String description) {
		super();
		this.name = name;
		this.type = type;
		this.price = price;
		this.description = description;
	}
}
