package com.vdellangela.cab.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;

import com.vdellangela.cab.repository.CabTripRepository;

@Controller
public class ApiController {

	@Autowired
	private CabTripRepository cabTripRepository;

	@RequestMapping("/cabs")
	public @ResponseBody List getCabTrip(@RequestParam(value = "medallion") List<String> listMedallions,
			@RequestParam(value = "date") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
			@RequestParam(value = "cache", required = false, defaultValue = "true") Boolean cache) {
		List cabTrip = cabTripRepository.getCabTripByIdAndDate(listMedallions, date, cache);

		return cabTrip;
	}

	@ExceptionHandler(MissingServletRequestParameterException.class)
	public ResponseEntity<Object> handleMissingParams(MissingServletRequestParameterException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		String name = ex.getParameterName();
		System.out.println(name + " parameter is missing");
		return handleMissingParams(ex, headers, status, request);
	}

}
