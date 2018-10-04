package pl.weakpoint.library.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.weakpoint.library.model.Reservation;

@RestController
public class ReservationController {

	@RequestMapping(ReservationRequestMapping.RESERVATION_ROOT)
	public List<Reservation> getAllReservations(){
		return new ArrayList<>();
	}
}
