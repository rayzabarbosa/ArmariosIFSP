package br.com.propeest.armariosifsp.service;

import br.com.propeest.armariosifsp.exceptions.CriptoExistException;
import br.com.propeest.armariosifsp.exceptions.EmailExistsException;
import br.com.propeest.armariosifsp.models.Aluno;
import br.com.propeest.armariosifsp.repositories.AlunoRepository;
import br.com.propeest.armariosifsp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class ServiceAluno {

    @Autowired
    private AlunoRepository alunoRepository;

    public void salvarAluno(Aluno aluno) throws Exception{

        try {
            if (alunoRepository.findByEmail(aluno.getEmail()) != null) {
                throw new EmailExistsException("Email inserido já está sendo utilizado");
            }

            aluno.setSenha(Util.md5(aluno.getSenha()));
            aluno.setRg(Util.md5(aluno.getRg()));
            aluno.setCpf(Util.md5(aluno.getCpf()));
        } catch (NoSuchAlgorithmException e) {

            throw new CriptoExistException("Erro na criptografia da senha");

        }

        alunoRepository.save(aluno);
    }

    public Aluno loginAluno(String email, String senha) throws ServiceExc {

        Aluno alunoLogin = alunoRepository.buscarLogin(email, senha);
        return alunoLogin;

    }
}
