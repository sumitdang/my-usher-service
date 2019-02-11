package com.usher.pojo.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.usher.utilities.CustomDateTimeDeserializer;
import com.usher.utilities.CustomDateTimeSerializer;

import lombok.Data;

@Entity
@Table(name = "user", schema = "usher")
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class User {

	@Id
	@Column(name = "email")
	private String email;

	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "pin")
	private String pin;

	@Column(name = "phone")
	private String phone;

	@Column(name = "created_by")
	@JsonIgnore
	private String createdBy;

	@Column(name = "created_date")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	@JsonIgnore
	private Timestamp createdDate;

	@Column(name = "updated_by")
	@JsonIgnore
	private String updatedBy;

	@Column(name = "updated_date")
	@JsonSerialize(using = CustomDateTimeSerializer.class)
	@JsonDeserialize(using = CustomDateTimeDeserializer.class)
	@JsonIgnore
	private Timestamp updatedDate;

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("email : ").append(this.email).append("\n");
		sb.append("firstName : ").append(this.firstName).append("\n");
		sb.append("lastName : ").append(this.lastName).append("\n");
		sb.append("pin : ").append(this.pin).append("\n");
		sb.append("phone : ").append(this.phone).append("\n");
		sb.append("createdDate : ").append(this.createdDate).append("\n");
		return sb.toString();
	}

}
