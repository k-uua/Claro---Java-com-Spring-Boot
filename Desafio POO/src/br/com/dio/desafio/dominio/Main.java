package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		
		
		
		
		Curso curso1 = new Curso();
		curso1.setTitulo("curso java");
		curso1.setDescricao("descrição curso java");
		curso1.setCargaHoraria(8);
		
		Curso curso2 = new Curso();
		curso2.setTitulo("curso python");
		curso2.setDescricao("descrição curso python");
		curso2.setCargaHoraria(4);
		
		Mentoria mentoria = new Mentoria();
		mentoria.setTitulo("mentoria java");
		mentoria.setDescricao("descricao mentoria java");
		mentoria.setData(LocalDate.now());
		/*
		System.out.println(curso1);
		System.out.println(curso2);
		System.out.println(mentoria);
		*/
		Bootcamp bootcamp = new Bootcamp();
		bootcamp.setNome("Bootcamp Java Developer");
		bootcamp.setDescricao("Descricao Bootcamp");
		bootcamp.getConteudos().add(curso1);
		bootcamp.getConteudos().add(curso2);
		bootcamp.getConteudos().add(mentoria);
		
		Dev devKaua = new Dev();
		devKaua.setNome("Kauã");
		devKaua.inscreverBootcamp(bootcamp);
		
		Dev devCarlos = new Dev();
		devCarlos.setNome("Carlos");
		devCarlos.inscreverBootcamp(bootcamp);
		
		
		
		System.out.println("Conteudos Inscristos Kauã" + devKaua.getConteudosInscritos());
		devKaua.progredir();

		System.out.println("Ranking dos Devs:");
		exibirRanking(bootcamp);

		System.out.println("Conteudos Inscristos Kauã" + devKaua.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Kauã" + devKaua.getConteudosConcluidos());
		System.out.println("--------------------------------");

		System.out.println("Conteudos Inscristos Carlos" + devCarlos.getConteudosInscritos());
		devCarlos.progredir();

		System.out.println("Ranking dos Devs:");
		exibirRanking(bootcamp);

		System.out.println("Conteudos Inscristos Carlos" + devCarlos.getConteudosInscritos());
		System.out.println("Conteudos Concluidos Carlos" + devCarlos.getConteudosConcluidos());
		System.out.println("--------------------------------");

	}

	public static void exibirRanking(Bootcamp bootcamp) {
	    List<Dev> ranking = bootcamp.rankingDevs();
	    System.out.println("Ranking dos Devs:");
	    for (int i = 0; i < ranking.size(); i++) {
	        Dev dev = ranking.get(i);
	        System.out.println((i + 1) + "º: " + dev.getNome() + " - XP: " + dev.calcularXp());
	    }
	}
}
