package com.vdellangela.cab.repository;

import org.springframework.data.repository.CrudRepository;

import com.vdellangela.cab.models.CabTrip;

public interface CabTripRepository extends CrudRepository<CabTrip, Integer>, CabTripRepositoryCustom {

}
