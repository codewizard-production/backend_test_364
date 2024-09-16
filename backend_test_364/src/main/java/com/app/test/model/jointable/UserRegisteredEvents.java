package com.app.test.model.jointable;

import com.sap.olingo.jpa.metadata.core.edm.annotation.EdmIgnore;
import lombok.Data;
import javax.persistence.*;

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

@Entity(name = "UserRegisteredEvents")
@Table(schema = "\"test\"", name = "\"UserRegisteredEvents\"")
@Data
public class UserRegisteredEvents{

 	@Id
    @Column(name = "\"Id\"")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
	
	@Column(name = "\"UserId\"")
	private Integer userId;

    
    @Column(name = "\"EventId\"")
    private Integer eventId;
 
}