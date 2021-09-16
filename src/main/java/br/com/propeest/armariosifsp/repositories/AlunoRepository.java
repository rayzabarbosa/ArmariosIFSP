package br.com.propeest.armariosifsp.repositories;

import br.com.propeest.armariosifsp.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {

    @Query("select i from Aluno i where i.email = :email") //Linha não necessária
    public Aluno findByEmail(String email);

    @Query("select j from Aluno j where j.email = :email and j.senha = :senha") //Linha não necessária
    public Aluno buscarLogin(String email, String senha);
}
