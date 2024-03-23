package healthplan.beneficios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import healthplan.beneficios.entity.Beneficiario;

import java.util.List;

public interface BeneficiarioRepository extends JpaRepository<Beneficiario, Long> {
    List<Beneficiario> findAll();
}
