package com.example.demo.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "swimrecords")
public class Swim {

	@Id
	@Column(name="swim_id", insertable=false)
	private int swimId;
	private String stroke;
	private int distance;
	private char distanceType; // Yards or Meters
	private double time; // in Seconds
	private int year;

	public int getSwimId() {
		return swimId;
	}

	public void setSwimId(int swimId) {
		this.swimId = swimId;
	}

	public String getStroke() {
		return stroke;
	}

	public void setStroke(String stroke) {
		this.stroke = stroke;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public char getDistanceType() {
		return distanceType;
	}

	public void setDistanceType(char distanceType) {
		this.distanceType = distanceType;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Swim [swimId=" + swimId + ", stroke=" + stroke + ", distance=" + distance + ", distanceType="
				+ distanceType + ", time=" + time + ", year=" + year + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance, distanceType, stroke, swimId, time, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Swim other = (Swim) obj;
		return distance == other.distance && distanceType == other.distanceType && Objects.equals(stroke, other.stroke)
				&& swimId == other.swimId && Double.doubleToLongBits(time) == Double.doubleToLongBits(other.time)
				&& year == other.year;
	}
	
	
	

}
