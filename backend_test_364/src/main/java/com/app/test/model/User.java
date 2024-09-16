package com.app.test.model;


import lombok.Data;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


 
import com.app.test.model.Child;
import com.app.test.model.Interest;
import com.app.test.model.Document;
import com.app.test.model.User;
import com.app.test.model.Event;
import com.app.test.model.Group;
import com.app.test.enums.Lang;
import com.app.test.enums.InterestEnum;
import com.app.test.enums.Currency;
import com.app.test.enums.Gender;
import com.app.test.enums.Status;
import com.app.test.converter.LangConverter;
import com.app.test.converter.InterestEnumConverter;
import com.app.test.converter.StatusConverter;
import com.app.test.converter.GenderConverter;
import com.app.test.converter.CurrencyConverter;
import com.app.test.converter.DurationConverter;
import com.app.test.converter.UUIDToByteConverter;
import com.app.test.converter.UUIDToStringConverter;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmFunction;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.time.Duration;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Lob;
import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmMediaStream;

@Entity(name = "User")
@Table(name = "\"User\"", schema =  "\"test\"")
@Data
                        
public class User {
	public User () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"UserId\"", nullable = true )
  private Integer userId;
	  
  @Column(name = "\"EmailId\"", nullable = true )
  private String emailId;
  
	  
  @Column(name = "\"FirstName\"", nullable = true )
  private String firstName;
  
	  
  @Column(name = "\"LastName\"", nullable = true )
  private String lastName;
  
	  
  @Column(name = "\"ProfileName\"", nullable = true )
  private String profileName;
  
	  
  @Column(name = "\"BirthDate\"", nullable = true )
  @Temporal(value = TemporalType.DATE)
  private Date birthDate;  
  
	  
  @Column(name = "\"MobileNumber\"", nullable = true )
  private String mobileNumber;
  
	  
  @Column(name = "\"Bio\"", nullable = true )
  private String bio;
  
	  
	
	@Column(name = "\"Languages\"")
	@ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(schema = "\"test\"", name = "\"UserLanguages\"",joinColumns = @JoinColumn(name = "\"UserId\""))
    @Convert(converter = LangConverter.class)
    private List<Lang> languages = new ArrayList<>();
	  
  @Column(name = "\"Pincode\"", nullable = true )
  private String pincode;
  
	  
  @Column(name = "\"CreatedDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date createdDate;  
  
	  
  @Column(name = "\"Address\"", nullable = true )
  private String address;
  
	  
  @Column(name = "\"Password\"", nullable = true )
  private String password;
  
	  
  @Column(name = "\"IsVerified\"", nullable = true )
  private Boolean isVerified;
  
	  
  @Column(name = "\"Otp\"", nullable = true )
  private String otp;
  
	  
  @Column(name = "\"LastLoginDate\"", nullable = true )
  @Temporal(value = TemporalType.TIMESTAMP)
  private Date lastLoginDate;  
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"UserProfilePhoto\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document profilePhoto;
	
	@Column(name = "\"UserProfilePhoto\"")
	private Integer userProfilePhoto;
   
	
@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"UserFavorites\"",
            joinColumns = @JoinColumn( name="\"UserId\""),
            inverseJoinColumns = @JoinColumn( name="\"EventId\""), schema = "\"test\"")
private List<Event> favorites = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"UserRegisteredEvents\"",
            joinColumns = @JoinColumn( name="\"UserId\""),
            inverseJoinColumns = @JoinColumn( name="\"EventId\""), schema = "\"test\"")
private List<Event> registeredEvents = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"UserChildren\"",
            joinColumns = @JoinColumn( name="\"UserId\""),
            inverseJoinColumns = @JoinColumn( name="\"ChildId\""), schema = "\"test\"")
private List<Child> children = new ArrayList<>();


@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE})
@JoinTable(
            name="\"UserMyGroups\"",
            joinColumns = @JoinColumn( name="\"UserId\""),
            inverseJoinColumns = @JoinColumn( name="\"GroupId\""), schema = "\"test\"")
private List<Group> myGroups = new ArrayList<>();
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "User [" 
  + "UserId= " + userId  + ", " 
  + "EmailId= " + emailId  + ", " 
  + "FirstName= " + firstName  + ", " 
  + "LastName= " + lastName  + ", " 
  + "ProfileName= " + profileName  + ", " 
  + "BirthDate= " + birthDate  + ", " 
  + "MobileNumber= " + mobileNumber  + ", " 
  + "Bio= " + bio  + ", " 
  + "Languages= " + languages  + ", " 
  + "Pincode= " + pincode  + ", " 
  + "CreatedDate= " + createdDate  + ", " 
  + "Address= " + address  + ", " 
  + "Password= " + password  + ", " 
  + "IsVerified= " + isVerified  + ", " 
  + "Otp= " + otp  + ", " 
  + "LastLoginDate= " + lastLoginDate 
 + "]";
	}
	
}