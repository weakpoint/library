package pl.weakpoint.library.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.Reservation;
import pl.weakpoint.library.service.ReservationService;

@RestController
@RequestMapping(ReservationRequestMapping.RESERVATION_ROOT)
public class ReservationController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping("")
	public List<Reservation> getAllReservations() {
		return reservationService.getAllReservations();
	}
}
