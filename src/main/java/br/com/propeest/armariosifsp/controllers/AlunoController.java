package br.com.propeest.armariosifsp.controllers;

import br.com.propeest.armariosifsp.dto.RequisicaoNovoAluno;
import br.com.propeest.armariosifsp.models.Aluno;
import br.com.propeest.armariosifsp.repositories.AlunoRepository;
import br.com.propeest.armariosifsp.service.ServiceAluno;
import br.com.propeest.armariosifsp.service.ServiceExc;
import br.com.propeest.armariosifsp.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;
import java.util.List;

@Controller
public class AlunoController {
    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private ServiceAluno serviceAluno;

    @GetMapping("/alunos")
    public ModelAndView index() {
        List<Aluno> alunos = this.alunoRepository.findAll();
        ModelAndView mv = new ModelAndView("alunos/index");
        mv.addObject("alunos", alunos);

        return mv;
    }

    @GetMapping("/login")
    public ModelAndView login() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("aluno", new Aluno());
        mv.setViewName("alunos/login");
        return mv;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("requisicaoNovoAluno", new RequisicaoNovoAluno());
        mv.setViewName("alunos/cadastro");
        return mv;
    }

    @GetMapping("/ajuda")
    public ModelAndView ajuda() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos/ajuda");
        return mv;
    }

    @GetMapping("/contrato")
    public ModelAndView contrato() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos/contrato");
        return mv;
    }

    @GetMapping("/contrato2")
    public ModelAndView contrato2() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos/contrato2");
        return mv;
    }

    @GetMapping("/blocosGremio")
    public ModelAndView blocosGremio() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos/blocosGremio");
        return mv;
    }

    @GetMapping("/armariosDisponiveis")
    public ModelAndView armariosDisponiveis() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos/armariosDisponiveis");
        return mv;
    }

    @GetMapping("/armario")
    public ModelAndView armario() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("alunos/armario");
        return mv;
    }

    @PostMapping("/alunos")
    public String create(@Valid RequisicaoNovoAluno requisicao, BindingResult br) throws Exception {
        if (br.hasErrors()) {
            System.out.println("\n****************************TEM ERR0******************************");
            return "redirect:/cadastro";
        }
        Aluno aluno = requisicao.toAluno();
        serviceAluno.salvarAluno(aluno);

        return "redirect:/login";
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid Aluno aluno, BindingResult br, HttpSession session) throws NoSuchAlgorithmException, ServiceExc {
        ModelAndView mv = new ModelAndView();
        mv.addObject("aluno", new Aluno());
        if (br.hasErrors()) {
            mv.setViewName("alunos/login");
        }

        Aluno alunoLogin = serviceAluno.loginAluno(aluno.getEmail(), Util.md5(aluno.getSenha()));
        if (alunoLogin == null) {
            mv.addObject("msg", "Usuário não encontrado");
        } else {
            session.setAttribute("alunoLogado", alunoLogin);
            return armario();
        }

        return mv;
    }
}
