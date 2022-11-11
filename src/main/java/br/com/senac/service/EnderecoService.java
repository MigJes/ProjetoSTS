package br.com.senac.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.senac.entity.Aluno;
import br.com.senac.entity.Endereco;
import br.com.senac.repository.EnderecoRepository;

@Service
public class EnderecoService {

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	public Endereco salvar(Endereco endereco) {
		return enderecoRepository.save(endereco);
	}
	
	public List<Endereco> buscar(Aluno aluno){
		List<Endereco> objLstEndereco = enderecoRepository.findByAluno(aluno);
		return objLstEndereco;
	}
}
