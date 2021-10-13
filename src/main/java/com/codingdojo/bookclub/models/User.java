package com.codingdojo.bookclub.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
     
	@NotEmpty
	@Size(min = 2, max = 255, message="This field is empty")
	private String name;
	
	@NotEmpty
	@Email
	@Size(min = 2, max = 255, message="This field is empty")
	private String email;
	
	@NotEmpty
	@Size(min = 8, max = 255, message="This field is empty")
	private String password;

	@Transient
	@NotEmpty
	@Size(min = 8, max = 255, message="This field is empty")
	private String confirm;
	
	
    @Column(updatable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createdAt;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updatedAt;
   
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
        this.updatedAt = new Date();
    }
    
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
    
    @OneToMany(mappedBy="user", fetch=FetchType.LAZY)
    private List<Book> books;
    
    
    public User () {
    }

	public User(@NotEmpty @Size(min = 2, max = 255, message = "This field is empty") String name,
			@NotEmpty @Email @Size(min = 2, max = 255, message = "This field is empty") String email,
			@NotEmpty @Size(min = 8, max = 255, message = "This field is empty") String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public User(@NotEmpty @Size(min = 2, max = 255, message = "This field is empty") String name,
			@NotEmpty @Email @Size(min = 2, max = 255, message = "This field is empty") String email,
			@NotEmpty @Size(min = 8, max = 255, message = "This field is empty") String password, List<Book> books) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.books = books;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirm() {
		return confirm;
	}

	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
    
    
	
}
