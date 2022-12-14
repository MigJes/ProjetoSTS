package br.com.senac.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.repository.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	private AlunoRepository alunoRepository;
	
	//Cadastrar alunos
	public Aluno salvar(Aluno aluno) {
		return alunoRepository.save(aluno);
	}
	//Buscar todos alunos
	public List<Aluno> buscarTodosAlunos(){
		return alunoRepository.findAll();
	}
	//Buscar Aluno por id
	public Aluno buscarPorId(Integer id) throws ObjectNotFoundException{
		Optional<Aluno> aluno = alunoRepository.findById(id);
		return aluno.orElseThrow(() -> new ObjectNotFoundException(1L, "Aluno não encontrado"));
	}
	//Deletar Aluno
	public void deletarPorId(Integer id) {
        Optional<Aluno> aluno = alunoRepository.findById(id);//Não precisa
        alunoRepository.deleteById(id);
    }
	//Atualizar Aluno
	public Aluno atualizarPorId(Integer id, Aluno o) {
		Aluno aluno = buscarPorId(id);
		aluno.setNome(o.getNome());
		return alunoRepository.save(aluno);
	}
	
	//Atualizar do Struct
	public Aluno salvarAlteracao(Aluno alunoAlterado) {
		Aluno aluno = buscarPorId(alunoAlterado.getId());
		aluno.setNome(alunoAlterado.getNome());
		aluno.setTurma(alunoAlterado.getTurma());
		return salvar(aluno);
	}
	
	public Aluno buscaPorNome(String nome) {
		Aluno aluno = alunoRepository.findByNome(nome);
		return aluno;
	}
	
	public List<Aluno> buscaAlunoComEndereco(){
		List<Aluno> lista = alunoRepository.buscarAlunoComEndereco();
		return lista;
				
	}
	
	public List<Aluno> buscaAlunoPeloNomeComEndereco(String nome){
		List<Aluno> lista = alunoRepository.buscaAlunoPeloNome(nome);
		
		return lista;
		
	}
	
}
