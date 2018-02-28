package com.example.demo;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@Immutable
@IdClass(View.class)
@Subselect("select p.name as person_name, c.brand as car_brand, c.model as car_model from persons p join cars c on p.id = c.person_id")
public class View implements Serializable {
	
	@Id private String personName;
	@Id private String carBrand;
	@Id private String carModel;
}
