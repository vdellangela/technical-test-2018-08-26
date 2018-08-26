package com.vdellangela.cab.repository;

import java.time.LocalDate;
import java.util.List;

public interface CabTripRepositoryCustom {
	List getCabTripByIdAndDate(List<String> listMedallions, LocalDate pickupDatetime, Boolean useCache);
}
