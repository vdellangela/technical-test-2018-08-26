package com.vdellangela.cab.models;

import java.time.LocalDateTime;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

@Entity
@Table(name = "cab_trip_data")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class CabTrip {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String medallion;
	@Column(name = "hack_license")
	private String hackLicense;
	@Column(name = "vendor_id")
	private String vendorId;
	@Column(name = "rate_code")
	private Integer rateCode;
	@Column(name = "store_and_fwd_flag")
	private String storeAndFwdFlag;
	@Column(name = "pickup_datetime")
	private LocalDateTime pickupDatetime;
	@Column(name = "dropoff_datetime")
	private LocalDateTime dropoffDateTime;
	@Column(name = "passenger_count")
	private Integer passengerCount;
	@Column(name = "trip_time_in_secs")
	private Integer tripTimeInSecs;
	@Column(name = "trip_distance")
	private Double tripDistance;
	@Column(name = "pickup_longitude")
	private Double pickupLongitude;
	@Column(name = "dropoff_longitude")
	private Double dropoffLongitude;
	@Column(name = "dropoff_latitude")
	private Double dropoffLatitude;

	public CabTrip() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMedallion() {
		return medallion;
	}

	public void setMedallion(String medallion) {
		this.medallion = medallion;
	}

	public String getHackLicense() {
		return hackLicense;
	}

	public void setHackLicense(String hackLicense) {
		this.hackLicense = hackLicense;
	}

	public String getVendorId() {
		return vendorId;
	}

	public void setVendorId(String vendorId) {
		this.vendorId = vendorId;
	}

	public Integer getRateCode() {
		return rateCode;
	}

	public void setRateCode(Integer rateCode) {
		this.rateCode = rateCode;
	}

	public String getStoreAndFwdFlag() {
		return storeAndFwdFlag;
	}

	public void setStoreAndFwdFlag(String storeAndFwdFlag) {
		this.storeAndFwdFlag = storeAndFwdFlag;
	}

	public LocalDateTime getPickupDatetime() {
		return pickupDatetime;
	}

	public void setPickupDatetime(LocalDateTime pickupDatetime) {
		this.pickupDatetime = pickupDatetime;
	}

	public LocalDateTime getDropoffDateTime() {
		return dropoffDateTime;
	}

	public void setDropoffDateTime(LocalDateTime dropoffDateTime) {
		this.dropoffDateTime = dropoffDateTime;
	}

	public Integer getPassengerCount() {
		return passengerCount;
	}

	public void setPassengerCount(Integer passengerCount) {
		this.passengerCount = passengerCount;
	}

	public Integer getTripTimeInSecs() {
		return tripTimeInSecs;
	}

	public void setTripTimeInSecs(Integer tripTimeInSecs) {
		this.tripTimeInSecs = tripTimeInSecs;
	}

	public Double getTripDistance() {
		return tripDistance;
	}

	public void setTripDistance(Double tripDistance) {
		this.tripDistance = tripDistance;
	}

	public Double getPickupLongitude() {
		return pickupLongitude;
	}

	public void setPickupLongitude(Double pickupLongitude) {
		this.pickupLongitude = pickupLongitude;
	}

	public Double getDropoffLongitude() {
		return dropoffLongitude;
	}

	public void setDropoffLongitude(Double dropoffLongitude) {
		this.dropoffLongitude = dropoffLongitude;
	}

	public Double getDropoffLatitude() {
		return dropoffLatitude;
	}

	public void setDropoffLatitude(Double dropoffLatitude) {
		this.dropoffLatitude = dropoffLatitude;
	}

}
