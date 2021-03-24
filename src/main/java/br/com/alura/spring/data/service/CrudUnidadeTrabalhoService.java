package br.com.alura.spring.data.service;

import java.util.Scanner;

import org.springframework.stereotype.Service;

import br.com.alura.spring.data.orm.UnidadeTrabalho;
import br.com.alura.spring.data.repository.UnidadeTrabalhoRepository;

@Service
public class CrudUnidadeTrabalhoService {

	private final UnidadeTrabalhoRepository UnidadeTrabalhoRepository;

	private boolean system = true;

	public CrudUnidadeTrabalhoService(UnidadeTrabalhoRepository UnidadeTrabalhoRepository) {
		this.UnidadeTrabalhoRepository = UnidadeTrabalhoRepository;
	}

	public void inicial(Scanner scanner) {
		while (system) {
			System.out.println("Qual acao de UnidadeTrabalho deseja executar");
			System.out.println("0 - Sair");
			System.out.println("1 - Salvar");
			System.out.println("2 - Atualizar");
			System.out.println("3 - Visualizar");
			System.out.println("4 - Deletar");

			int action = scanner.nextInt();

			switch (action) {
			case 1:
				salvar(scanner);
				break;
			case 2:
				atualizar(scanner);
				break;
			case 3:
				visualizar();
				break;
			case 4:
				deletar(scanner);
				break;
			default:
				system = false;
				break;
			}
		}
	}

	private void salvar(Scanner scanner) {
		System.out.println("Descricao do UnidadeTrabalho");
		String descricao = scanner.next();

		UnidadeTrabalho UnidadeTrabalho = new UnidadeTrabalho();
		UnidadeTrabalho.setDescricao(descricao);

		UnidadeTrabalhoRepository.save(UnidadeTrabalho);
		System.out.println("Salvo");
	}

	private void atualizar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();

		System.out.println("Descricao do UnidadeTrabalho");
		String descricao = scanner.next();

		UnidadeTrabalho UnidadeTrabalho = new UnidadeTrabalho();
		UnidadeTrabalho.setId(id);
		UnidadeTrabalho.setDescricao(descricao);

		UnidadeTrabalhoRepository.save(UnidadeTrabalho);
		System.out.println("Atualizado");
	}

	private void visualizar() {
		Iterable<UnidadeTrabalho> UnidadeTrabalhos = UnidadeTrabalhoRepository.findAll();
		UnidadeTrabalhos.forEach(UnidadeTrabalho -> System.out.println(UnidadeTrabalho));
	}

	private void deletar(Scanner scanner) {
		System.out.println("Id");
		int id = scanner.nextInt();

		UnidadeTrabalhoRepository.deleteById(id);
		System.out.println("Deletado");
	}
}
