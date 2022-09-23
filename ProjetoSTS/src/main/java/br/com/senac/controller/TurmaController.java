package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


import br.com.senac.entity.Turma;
import br.com.senac.service.TurmaService;

@Controller
@RequestMapping("turma")
public class TurmaController {
	@Autowired
	private TurmaService turmaService;
	@GetMapping("/listarTurmas")
	public ModelAndView listaTodasTurmas() {
		ModelAndView mv = new ModelAndView("turma/paginaListaTurmas");
		mv.addObject("turmas", turmaService.selectAll());
		return mv;
	}
	
	@GetMapping("/cadastrarTurma")
	public ModelAndView cadastrarTurma() {
		ModelAndView mv = new ModelAndView("turma/cadastrarTurma");
		mv.addObject("turmanova",new Turma());
		return mv;
	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarTurma(Turma turma) {
		turmaService.insert(turma);
		return listaTodasTurmas();
	}
	
	@GetMapping("/excluir/{idX}")
	public ModelAndView excluirTurma(@PathVariable ("idX")Integer id) {
		turmaService.delete(id);
		return listaTodasTurmas();
		
	}
	
	@GetMapping("/paginaAlterar/{id}")
	public ModelAndView alterarTurma(@PathVariable("id")Integer id) {
		ModelAndView mv = new ModelAndView("turma/alterarTurma");
		mv.addObject("turma",turmaService.select(id));
		return mv;
	}
}
