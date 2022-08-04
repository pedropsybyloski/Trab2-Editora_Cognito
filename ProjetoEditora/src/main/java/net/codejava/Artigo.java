package net.codejava;

import javax.persistence.*;

@Entity
@Table(name = "artigo")
public class Artigo {
	private long id;

	private String titulo;

	private String resumo;

	private boolean publicado;

	protected Artigo() {
	}

	protected Artigo(Long id, String titulo, String resumo, boolean publicado) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.resumo = resumo;
		this.publicado = publicado;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public void setResumo(String resumo) {
		this.resumo = resumo;
	}

	public boolean isPublicado() {
		return publicado;
	}

	public void setPublicado(boolean ispublicado) {
		this.publicado = ispublicado;
	}

}
