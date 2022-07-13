package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
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
@Table(name = "OTM_PHONE_NUMBER")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PhoneNumber implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@SequenceGenerator(name = "gen1", sequenceName = "reg_seq", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Long regno;
	
	@NonNull
	private Long phoneNo;
	@NonNull
	private String provider;
	@NonNull
	private String type;
	
//	@OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL,mappedBy = "person")
	@OneToOne(targetEntity = Person.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "PERSON_ID", referencedColumnName = "pid") // fk column
	private Person person; // for many to one assocation

	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNo=" + phoneNo + ", provider=" + provider + ", type=" + type
				+ ", person=" + person + "]";
	}
}
/*
 In bi-directonal Assocaition instead of specifying foreign key colum using @JoinColum in both parent and child
 classes we can specify only at one side with the support of mappedBy property.
 */

/*in one to Many association we need to specify mappedBy at one side (parent)
in many to many and one to one assocaition we can specify mappedBy any one side (parent class)*/
