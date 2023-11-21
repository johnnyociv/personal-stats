package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "climbrecords")
public class Climb {

	@Id
	@Column(name = "climb_id", insertable = false)
	private int climbId;
	private String grade; // v1-v9 or 5.5-5.12
	private String type; // Boulder, TopRope or Lead
	private String location; // Indoor or Outdoor
	private int year;

	public int getClimbId() {
		return climbId;
	}

	public void setClimbId(int climbId) {
		this.climbId = climbId;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Climb [climbId=" + climbId + ", grade=" + grade + ", type=" + type + ", location=" + location
				+ ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(climbId, grade, location, type, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Climb other = (Climb) obj;
		return climbId == other.climbId && Objects.equals(grade, other.grade)
				&& Objects.equals(location, other.location) && Objects.equals(type, other.type) && year == other.year;
	}

}