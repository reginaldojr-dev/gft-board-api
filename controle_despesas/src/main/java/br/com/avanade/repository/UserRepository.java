package br.com.avanade.repository;

import br.com.avanade.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Aqui podemos adicionar métodos customizados se necessário
}
