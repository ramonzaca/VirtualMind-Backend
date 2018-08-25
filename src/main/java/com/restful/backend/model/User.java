package com.restful.backend.model;

/**
 * Implementación del modelo de usuario.
 * @author Agustín Dye
 */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt", "updatedAt","id"}, 
        allowGetters = true)
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "name can't empty!")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "surname can't empty!")
    @Column(nullable = false)
    private String surname;
    
    @NotBlank
    @Column(nullable = false)
    private String email;
    
    @NotBlank
    @Column(nullable = false)
    private String password;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;
    
    public User() {}
    
    public User(Long id, String name, String apellido, String email, String password) {
    	this.id = id;
    	this.name = name;
    	this.surname = apellido;
    	this.email = email;
    	this.password = password;
    }

    public Long getID() {
    	return this.id;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public String getSurname() {
    	return this.surname;
    }
    
    public String getEmail() {
    	return this.email;
    }
    
    public String getPassword() {
    	return this.password;
    }
    
    public void setId(Long id) {
    	this.id = id;
    }
    
    public void setName(String name) {
    	this.name = name;
    }
    
    public void setSurname(String surname) {
    	this.surname = surname;
    }
    
    public void setEmail(String email) {
    	this.email = email;
    }
    
    public void setPassword(String password) {
    	this.password = password;
    }
}