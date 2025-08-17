package com.estudos.encurtadorlink.repository;
import com.estudos.encurtadorlink.model.EncurtadorLink;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EncurtadorLinkRepository extends JpaRepository<EncurtadorLink, Long> {
    Optional<EncurtadorLink> findByShortCode(String shortCode);
}

