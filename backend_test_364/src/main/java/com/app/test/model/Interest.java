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

@Entity(name = "Interest")
@Table(name = "\"Interest\"", schema =  "\"test\"")
@Data
                        
public class Interest {
	public Interest () {   
  }
	  
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "\"IntId\"", nullable = true )
  private Integer intId;
	  
  @Column(name = "\"InterestName\"", nullable = true)
  @Enumerated(value = EnumType.ORDINAL)
  @Convert(converter = InterestEnumConverter.class)
  private InterestEnum interestName;
  
	  
  @Column(name = "\"IconPath\"", nullable = true )
  private String iconPath;
  
  
  
  
	
	@OneToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "\"InterestIcon\"", referencedColumnName = "\"DocId\"", insertable = false, updatable = false)
	private Document icon;
	
	@Column(name = "\"InterestIcon\"")
	private Integer interestIcon;
   
  
  
  
  
  
  
  
  
  
  @Override
  public String toString() {
	return "Interest [" 
  + "IntId= " + intId  + ", " 
  + "InterestName= " + interestName  + ", " 
  + "IconPath= " + iconPath 
 + "]";
	}
	
}