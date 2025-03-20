package com.clinic.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "owners")
public class Owner {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String contact;
    private String address;
    
    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private List<Pet> pets; 
    
    public Owner() {
    }

	public Owner(Long id, String name, String contact, String address, List<Pet> pets) {
		super();
		this.id = id;
		this.name = name;
		this.contact = contact;
		this.address = address;
		this.pets = pets;
	}

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

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public String toString() {
		return "Owner [id=" + id + ", name=" + name + ", contact=" + contact + ", address=" + address + ", pets=" + pets
				+ "]";
	}    
}


