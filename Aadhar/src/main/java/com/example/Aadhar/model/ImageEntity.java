package com.example.Aadhar.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name = "images")
public class ImageEntity {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    private String name;

	    @Lob
	    @Column(columnDefinition = "LONGBLOB") // Use LONGBLOB for large images
	    private byte[] data;

	    // Constructors
	    public ImageEntity() {}

	    public ImageEntity(String name, byte[] data) {
	        this.name = name;
	        this.data = data;
	    }

	    // Getters and Setters
	    public Long getId() { return id; }
	    public void setId(Long id) { this.id = id; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public byte[] getData() { return data; }
	    public void setData(byte[] data) { this.data = data; }
}
