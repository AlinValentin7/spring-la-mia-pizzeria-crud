package it.exercise.java.spring.mvc.model;





import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "pizze")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotNull(message = "Name must be insert")
	@NotBlank(message ="Name cannot be emty")
	private String name;
	@NotNull(message = "Descpirtion must be insert")
	@NotBlank(message ="Description cannot be emty")
	private String description;
	@NotNull(message = "Price must be insert")
	private Double price;
	private String photo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Override
	public String toString() {
		return "Pizzeria [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", photo=" + photo + "]";
	}

}
