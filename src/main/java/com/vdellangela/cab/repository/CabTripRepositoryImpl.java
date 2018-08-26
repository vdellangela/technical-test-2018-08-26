package com.vdellangela.cab.repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class CabTripRepositoryImpl implements CabTripRepositoryCustom {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List getCabTripByIdAndDate(List<String> listMedallions, LocalDate date, Boolean useCache) {
		LocalDateTime datePrior = date.atStartOfDay();
		LocalDateTime dateAfter = datePrior.plusDays(1);

		String hql = "select new map(C.medallion as medallion, count(*) as count) FROM CabTrip C WHERE C.medallion in :ids AND C.pickupDatetime >= :datePrior AND C.pickupDatetime < :dateAfter group by C.medallion";
		Query query = entityManager.createQuery(hql);
		query.setParameter("ids", listMedallions);
		query.setParameter("datePrior", datePrior);
		query.setParameter("dateAfter", dateAfter);

		// Remove Cache
		if (!useCache)
			query.setHint("javax.persistence.cache.retrieveMode", "BYPASS");

		List result = query.getResultList();

		return result;
	}
}
