package br.com.agenda.aplicacao;


/*O código abaixo seria com dados fixos:
 
 
 import java.util.Date;
 

import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

//MVC
/*

Model
View
Controller */

/*public class Main {

public static void main(String[] args) {

    ContatoDAO contatoDao = new ContatoDAO();

    Contato contato = new Contato();
    contato.setNome("Clara Rodrigues");
    contato.setIdade(20);
    contato.setDataCadastro(new Date());

    contatoDao.save(contato);

    Contato c1 = new Contato();
    c1.setNome("Henrique Oliveira");
    c1.setIdade(15);
    c1.setDataCadastro(new Date());
    c1.setId(4);

    contatoDao.update(c1);

    //Deletar o contato pelo seu numero de ID
            contatoDao.deleteByID(3);

    //Visualização dos registros do banco de dados TODOS

    for(Contato c : contatoDao.getContatos()) {
        System.out.println("Contato: "+c.getNome());
    }
}
}
*/

//O código abaixo é com a interação do usuário

import java.util.Scanner;

import java.util.Date;
import br.com.agenda.dao.ContatoDAO;
import br.com.agenda.model.Contato;

public class Main {

public static void main(String[] args) {

    ContatoDAO contatoDao = new ContatoDAO();

    // Criar um objeto Scanner para ler as entradas do usuário
    Scanner input = new Scanner(System.in);

    // Pedir para o usuário digitar o nome e a idade do contato
    System.out.println("Digite o nome do contato:");
    String nome = input.nextLine();

    System.out.println("Digite a idade do contato:");
    int idade = input.nextInt();
    input.nextLine(); // Consumir a quebra de linha deixada pelo nextInt()

    // Criar o objeto Contato com os dados fornecidos pelo usuário
    Contato contato = new Contato();
    contato.setNome(nome);
    contato.setIdade(idade);
    contato.setDataCadastro(new Date());

    // Salvar o contato no banco de dados
    contatoDao.save(contato);

    // Fechar o objeto Scanner
    input.close();
}
}