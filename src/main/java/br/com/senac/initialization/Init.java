package br.com.senac.initialization;



//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoCurso;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AvaliacaoRepository;
import br.com.senac.repository.ProfessorRepository;
//import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.ProfessorService;
import br.com.senac.service.TurmaService;


@Component
public class Init implements ApplicationListener<ContextRefreshedEvent>{
	@Autowired
	AlunoService alunoService;
	@Autowired
	ProfessorService professorService;
	@Autowired
	CursoService cursoService;
	@Autowired
	TurmaService turmaService;
	@Autowired
	AvaliacaoService avaliacaoService;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	
	//@Autowired
	//AlunoRepository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		Curso curso4 = new Curso();
		curso4.setNome("Matematica");
		cursoService.salvar(curso4);
		
		Aluno aluno1 = new Aluno();
		
		aluno1.setId(1);
		aluno1.setNome("Miguel");
		alunoService.salvar(aluno1);
		
		
		
		
		AlunoCurso alunoCurso1 = new AlunoCurso();
		alunoCurso1.setAluno(aluno1);
		alunoCurso1.setCurso(curso4);
		
		Avaliacao avaliacao1 = new Avaliacao();
		avaliacao1.setAlunoCurso(alunoCurso1);
		avaliacao1.setConceito("I");
		
		avaliacaoService.save(avaliacao1);
	
		
		
	}
}