package br.com.senac.initialization;



import java.util.List;import org.hibernate.internal.build.AllowSysOut;

//import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;


import br.com.senac.entity.Aluno;
import br.com.senac.entity.AlunoCurso;
import br.com.senac.entity.Avaliacao;
import br.com.senac.entity.Curso;
import br.com.senac.entity.Endereco;
import br.com.senac.entity.Turma;
import br.com.senac.repository.AvaliacaoRepository;
import br.com.senac.repository.ProfessorRepository;
import br.com.senac.repository.TurmaRepository;
//import br.com.senac.repository.AlunoRepository;
import br.com.senac.service.AlunoService;
import br.com.senac.service.AvaliacaoService;
import br.com.senac.service.CursoService;
import br.com.senac.service.EnderecoService;
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
	EnderecoService enderecoService;
	@Autowired
	ProfessorRepository professorRepository;
	@Autowired
	AvaliacaoRepository avaliacaoRepository;
	@Autowired
	TurmaRepository turmaRepository;
	
	//@Autowired
	//AlunoRepository repo;

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		
		
		
	
		
	
		Turma turma1 = new Turma();
		turma1.setNome("2022.1");
		turmaService.salvar(turma1);
		
		Turma turma2 = new Turma();
		turma2.setNome("2022.2");
		turmaService.salvar(turma2);
		
		
		Turma turma3 = new Turma();
		turma3.setNome("2021.2");
		turmaService.salvar(turma3);
		
		Turma turma4 = new Turma();
		turma4.setNome("2022.2");
		turmaService.salvar(turma4);
		
		
		
		
		Curso curso1 = new Curso();
		curso1.setNome("Português");
		cursoService.salvar(curso1);
		
		Curso curso2 = new Curso();
		curso2.setNome("Geografia");
		cursoService.salvar(curso2);
		
		Curso curso3 = new Curso();
		curso3.setNome("História");
		cursoService.salvar(curso3);
		
		Curso curso4 = new Curso();
		curso4.setNome("Matematica");
		cursoService.salvar(curso4);
		
		Aluno aluno1 = new Aluno();
		
		aluno1.setId(1);
		aluno1.setNome("Miguel");
		aluno1.setTurma(turma1);
		
		alunoService.salvar(aluno1);
		
		Aluno aluno2 = new Aluno();
		
		aluno2.setId(2);
		aluno2.setNome("Lucas");
		aluno2.setTurma(turma2);
		
		alunoService.salvar(aluno2);
		
		
		Aluno aluno3 = new Aluno();
		
		aluno3.setId(3);
		aluno3.setNome("Caio");
		aluno3.setTurma(turma3);
		
		alunoService.salvar(aluno3);
		
		Aluno aluno4 = new Aluno();
		
		aluno4.setId(4);
		aluno4.setNome("Fernando");
		aluno4.setTurma(turma4);
		
		alunoService.salvar(aluno4);
		
		Endereco endereco1 = new Endereco();
		endereco1.setId(1);
		endereco1.setBairro("Botafogo");
		endereco1.setCep("11111");
		endereco1.setComplemento("APT:600");
		endereco1.setNumero(200);
		endereco1.setRua("Barâo de Lucena");
		endereco1.setAluno(aluno4);
		enderecoService.salvar(endereco1);
		
		Endereco endereco2 = new Endereco();
		endereco2.setId(2);
		endereco2.setBairro("Flamengo");
		endereco2.setCep("22222222");
		endereco2.setComplemento("APT:500");
		endereco2.setNumero(100);
		endereco2.setRua("Marquês");
		endereco2.setAluno(aluno1);
		enderecoService.salvar(endereco2);
		
		Endereco endereco3 = new Endereco();
		endereco3.setId(3);
		endereco3.setBairro("Copacabana");
		endereco3.setCep("33333333");
		endereco3.setComplemento("APT:400");
		endereco3.setNumero(300);
		endereco3.setRua("Olinda");
		endereco3.setAluno(aluno2);
		enderecoService.salvar(endereco3);
		
		
		Endereco endereco4 = new Endereco();
		endereco4.setId(4);
		endereco4.setBairro("Ipanema");
		endereco4.setCep("444444");
		endereco4.setComplemento("APT:300");
		endereco4.setNumero(400);
		endereco3.setAluno(aluno3);
		enderecoService.salvar(endereco4);
		
		
		
		
		
		
		
		
		AlunoCurso alunoCurso1 = new AlunoCurso();
		alunoCurso1.setAluno(aluno1);
		alunoCurso1.setCurso(curso4);
		
		Avaliacao avaliacao1 = new Avaliacao();
		avaliacao1.setAlunoCurso(alunoCurso1);
		avaliacao1.setConceito("I");
		
		avaliacaoService.save(avaliacao1);
		
		
		
//		List<Turma> listaTurmas = turmaService.buscarTodasTurmas();
//		for(Turma turma : listaTurmas) {
//			System.out.println(turma.getNome());
//			for(Aluno aluno : turma.getAlunos()) {
//				System.out.println(aluno.getNome());
//			}
//		}
		
		
//		List<Turma> listaTurmas = turmaRepository.findAllByIdTruma(4);
//		for(Turma  turma : listaTurmas) {
//			for(Aluno aluno : turma.getAlunos()) {
//				System.out.println(aluno.getNome());
//			}
//		}
		
//		Aluno al1 = alunoService.buscaPorNome("Miguel");
//		
//		al1.getEnderecos().forEach((e)-> System.out.println("Bairro " +e.getBairro()+"Rua: " +e.getRua() +"Numero: " +e.getNumero() +"Cep: "+e.getCep()));
//	
	
//		List<Endereco> listaEnderecoAluno1 = enderecoService.buscar(aluno4);
//		
//		listaEnderecoAluno1.forEach((e) -> System.out.println("Rua "+ e.getRua() + " Numero:" +e.getNumero() + " Bairro: " + e.getBairro()));
//		
		
//		List<Aluno> listaAlunoComEndereco = alunoService.buscaAlunoComEndereco();
//		
//		listaAlunoComEndereco.forEach(a -> a.getEnderecos().forEach(end -> System.out.println("Aluno nome: " +end.getAluno().getNome() +"/ "+" Rua: " + end.getRua())));
		
		List<Aluno> alunoComEndereco = alunoService.buscaAlunoPeloNomeComEndereco("Lucas");
		
//		alunoComEndereco.forEach(a -> a.getEnderecos().forEach(end -> System.out.println("Aluno nome: " + end.getAluno().getNome() + "Rua: " + end.getRua())));
//		
//		Turma turma = turmaService.buscaListaAlunosTurma(3);
//		List<Aluno> alunosDaTurma = turma.getAlunos();
//		
//		alunosDaTurma.forEach((aluno) -> System.out.println("Nome do Aluno: "+ aluno.getNome()));
//		
		Turma turma = turmaService.findTurmaByIdTruma(1);
		List<Aluno> alunosDaTurma = turma.getAlunos();
		
		alunosDaTurma.forEach((aluno) -> System.out.println("Nome do Aluno: "+ aluno.getNome()));
		
		
		
	}
}