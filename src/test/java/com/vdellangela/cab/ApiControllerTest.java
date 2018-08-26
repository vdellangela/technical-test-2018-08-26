package com.vdellangela.cab;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vdellangela.cab.repository.CabTripRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiControllerTest {

	@Autowired
	CabTripRepository cabTripRepository;

	@Test
	public void testGetListTrips() throws Exception {
		List<String> listMedallions = new ArrayList<String>();
		listMedallions.add("D7D598CD99978BD012A87A76A7C891B7");

		List result = cabTripRepository.getCabTripByIdAndDate(listMedallions, LocalDate.parse("2013-12-01"), false);

		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(false));
	}

	@Test
	public void testGetListTripsSeveralMedallions() throws Exception {
		List<String> listMedallions = new ArrayList<String>();
		listMedallions.add("D7D598CD99978BD012A87A76A7C891B7");
		listMedallions.add("5455D5FF2BD94D10B304A15D4B7F2735");

		List result = cabTripRepository.getCabTripByIdAndDate(listMedallions, LocalDate.parse("2013-12-01"), false);

		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(false));
		assertThat(result.size(), is(2));
	}

	@Test
	public void testNoResult() throws Exception {
		List<String> listMedallions = new ArrayList<String>();
		listMedallions.add("11111111111111111111176A7C891B7");

		List result = cabTripRepository.getCabTripByIdAndDate(listMedallions, LocalDate.parse("2013-12-01"), false);

		assertThat(result, is(notNullValue()));
		assertThat(result.isEmpty(), is(true));
	}
}
