package com.example.demo.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "OTM_Person")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
public class Person implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer pid;
	
	@NonNull
	private String pname;
	@NonNull
	private String paddress;
	
	@OneToMany(targetEntity = PhoneNumber.class, cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "pid")
	private Set<PhoneNumber>phones; // for one to many assocatiaon
}

/*In association mapping the cascading type are related to non-select persistence operation which indicates any select persistence  operation on main object will be cascaded to the associated child object. CascadeType.ALL/MERGE/PERSIST/REMOVE/REFRESBH/DETACH

In association mapping the fetch type are related to select persistence operation which indicates the associated child object should be loaded along with the  parent objects or not. 

FetchType.EAGER: Child object will be loaded along with parent objects.

FetchType.LAZY: Parent object will be loaded normally but associated child objects will be loaded lazly on demand basis

One-To-Many association default fetch type is “LAZY”.

Many-To-One association default fetch type is “EAGER”*/

