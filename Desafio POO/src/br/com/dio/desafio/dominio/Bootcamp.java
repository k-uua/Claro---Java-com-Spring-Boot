package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Bootcamp {
	private String nome;
	private String descricao;
	private final LocalDate dataInicio = LocalDate.now();
	private final LocalDate dataFim = dataInicio.plusDays(45);
	private Set<Dev> devsInscritos = new HashSet();
	private Set<Conteudo> conteudos = new HashSet();
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Set<Dev> getDevsIncritos() {
		return devsInscritos;
	}
	public void setDevsIncritos(Set<Dev> devsInscritos) {
		this.devsInscritos = devsInscritos;
	}
	public Set<Conteudo> getConteudos() {
		return conteudos;
	}
	public void setConteudos(Set<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}
	public LocalDate getDataInicio() {
		return dataInicio;
	}
	public LocalDate getDataFim() {
		return dataFim;
	}
	@Override
	public int hashCode() {
		return Objects.hash(dataFim, dataInicio, descricao, devsInscritos, nome);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bootcamp other = (Bootcamp) obj;
		return Objects.equals(dataFim, other.dataFim) && Objects.equals(dataInicio, other.dataInicio)
				&& Objects.equals(descricao, other.descricao) && Objects.equals(devsInscritos, other.devsInscritos)
				&& Objects.equals(nome, other.nome);
	}
	//Função para ranquear devs por xp no bootcamp
	public List<Dev> rankingDevs(){
		return devsInscritos.stream()
				.sorted((dev1, dev2)-> Double.compare(dev2.calcularXp(), dev1.calcularXp()))
				.collect(Collectors.toList());
	}
	
	

	
}
