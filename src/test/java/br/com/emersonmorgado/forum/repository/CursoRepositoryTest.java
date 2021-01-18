package br.com.emersonmorgado.forum.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.util.Assert;

import br.com.emersonmorgado.forum.modelo.Curso;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)//Essa anotação não permite que o Spring substitua as configurações para utilizar o banco em memória.
@ActiveProfiles("test")
class CursoRepositoryTest {

	@Autowired
	private CursoRepository cursoRepository;
	
	@Autowired
	private TestEntityManager em;
	
	@Test
	public void deveriaCarregarUmCursoAoBuscarPeloSeuNome() {
		String nomeCurso = "HTML 5";
		
		//Popular o banco conforme cenario a ser testado.
		Curso html5 = new Curso();
		html5.setNome(nomeCurso);
		html5.setCategoria("Programacao");
		em.persist(html5);
		
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
