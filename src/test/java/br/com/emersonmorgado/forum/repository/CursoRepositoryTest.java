package br.com.emersonmorgado.forum.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.util.Assert;

import br.com.emersonmorgado.forum.modelo.Curso;
@DataJpaTest
class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.notNull(curso, "Curso não é nulo");
		Assert.isTrue(nomeCurso.equals(curso.getNome()), "O nome dos cursos precisam ser iguais");
	}
	
	@Test
	public void naoDeveriaCarregarUmCursoCujoONomeNaoEstaCadastrado() {
		String nomeCurso = "JPA";
		Curso curso = cursoRepository.findByNome(nomeCurso);
		Assert.isNull(curso, "O valor tem que ser null");
	}

}
