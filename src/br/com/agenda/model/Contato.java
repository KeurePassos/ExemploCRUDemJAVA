package br.com.agenda.model;

import java.util.Date;

public class Contato {

private int id;
private String nome;
private int idade;
private Date dataCadastro;
private String email;
private String telefone;
private String endereco;

public int getId() {
    return id;
}
public void setId(int id) {
    this.id = id;
}
public String getNome() {
    return nome;
}
public void setNome(String nome) {
    this.nome = nome;
}
public int getIdade() {
    return idade;
}
public void setIdade(int idade) {
    this.idade = idade;
}
public Date getDataCadastro() {
    return dataCadastro;
}
public void setDataCadastro(Date dataCadastro) {
    this.dataCadastro = dataCadastro;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getTelefone() {
	return telefone;
}
public void setTelefone(String telefone) {
	this.telefone = telefone;
}
public String getEndereco() {
	return endereco;
}
public void setEndereco(String endereco) {
	this.endereco = endereco;
}
}