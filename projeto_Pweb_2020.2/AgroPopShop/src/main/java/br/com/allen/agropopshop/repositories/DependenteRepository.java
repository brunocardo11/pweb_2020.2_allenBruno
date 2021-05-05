package br.com.allen.agropopshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import br.com.allen.agropopshop.models.Dependente;

public interface DependenteRepository extends JpaRepository<Dependente, Long> {
	List<Dependente> findByIdPrincipal (String id);
}
