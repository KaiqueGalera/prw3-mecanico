package app.repository;

import app.conserto.Conserto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Arrays;
import java.util.List;

public interface ConsertoRepository extends JpaRepository<Conserto, Long> {
    List<Conserto> findAllByAtivoTrue();
}
