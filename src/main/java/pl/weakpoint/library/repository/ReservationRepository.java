package pl.weakpoint.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.weakpoint.library.model.Reservation;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, String> {

}
