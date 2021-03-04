package hibernateobjects;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Products")
public class Product {
	
	@Id
	private int id;
	private String description;
	private String name;
	private String price;
	
	public Product(int _id, String _description, String _name, String _price) {
		this.id = _id;
		this.description = _description;
		this.name = _name;
		this.price = _price;
	}
	
	public Product() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
	

}
