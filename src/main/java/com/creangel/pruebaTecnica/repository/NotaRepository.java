package com.creangel.pruebaTecnica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.creangel.pruebaTecnica.dto.NotaDTO;
import java.util.Optional;

@Repository
public interface NotaRepository extends JpaRepository<NotaDTO, Integer> {

    @Override
    Optional<NotaDTO> findById(Integer id);

}
