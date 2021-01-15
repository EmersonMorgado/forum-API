package br.com.emersonmorgado.forum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.emersonmorgado.forum.modelo.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{

	Curso findByNome(String nome);

}
