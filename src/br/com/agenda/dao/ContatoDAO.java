package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;

public class ContatoDAO {

/*
* CRUD c: CREATE - OK - INSERT r: READ - SELECT u: UPDATE - UPDATE d: DELETE -
* DELETE
*/

@SuppressWarnings("unchecked")
public <PreparedStatement> void save(Contato contato) {

    String sql = "INSERT INTO contatos(nome, idade, datacadastro, email, telefone, endereco) VALUES (?, ?, ?, ?, ?, ?)";

    Connection conn = null;
    PreparedStatement pstm = null;

    try {
        // Criar uma conexão com o banco de dados
        conn = ConnectionFactory.createConnectionToMySQL();

        // Criamos uma PreparedStatement, para executar uma query
        pstm = (PreparedStatement) conn.prepareStatement(sql);
        // Adicionar os valores que são esperados pela query
        ((java.sql.PreparedStatement) pstm).setString(1, contato.getNome());
        ((java.sql.PreparedStatement) pstm).setInt(2, contato.getIdade());
        ((java.sql.PreparedStatement) pstm).setDate(3, new Date(contato.getDataCadastro().getTime()));
        ((java.sql.PreparedStatement) pstm).setString(4, contato.getEmail());
        ((java.sql.PreparedStatement) pstm).setString(5, contato.getTelefone());
        ((java.sql.PreparedStatement) pstm).setString(6, contato.getEndereco());

        // Executar a query
        ((java.sql.PreparedStatement) pstm).execute();

        System.out.println("Contato salvo com sucesso!");
    } catch (Exception e) {
        e.printStackTrace();
    } finally {

        // Fechar as conexões
        try {
            if (pstm != null) {
                ((Statement) pstm).close();
            }

            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

public void update (Contato contato) {
    String sql = "UPDATE contatos SET nome = ?, idade = ?, datacadastro = ?, email = ?, telefone = ?, endereco = ?" + "WHERE id = ?";

    Connection conn = null;
    java.sql.PreparedStatement pstm = null;

    try {
        conn = ConnectionFactory.createConnectionToMySQL();

        pstm = (java.sql.PreparedStatement) conn.prepareStatement(sql);

        pstm.setString(1, contato.getNome());
        pstm.setInt(2, contato.getIdade());
        pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));
        pstm.setString(4, contato.getEmail());
        pstm.setString(5, contato.getTelefone());
        pstm.setString(6, contato.getEndereco());
        pstm.setInt(7, contato.getId());

        pstm.execute();

    } catch (Exception e) {
        e.printStackTrace();
    }finally {
        try {
            if(pstm!=null) {
                pstm.close();
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
public void deleteByID(int id) {

    String sql = "DELETE FROM contatos WHERE id =?";

    Connection conn = null;
    java.sql.PreparedStatement pstm = null;

    try {

        // Criar uma conexao com o banco de dados
        conn = ConnectionFactory.createConnectionToMySQL();

        // Criamos uma PreparedStatement, para executar uma query
        pstm = (java.sql.PreparedStatement) conn.prepareStatement(sql);

        pstm.setInt(1, id);

        pstm.execute();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
    finally {
        try {
        if(pstm!=null) {
                pstm.close();
            }   
        if(conn!=null) {
            conn.close();
        }

        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}



public List<Contato> getContatos(){

    String sql = "SELECT * FROM contatos";

    List<Contato> contatos = new ArrayList<Contato>();

    Connection conn = null;
    java.sql.PreparedStatement pstm = null;
    //Classe que vai recuperar os dados do banco. ***SELECT****
    ResultSet rset = null;

    try {
        conn = ConnectionFactory.createConnectionToMySQL();

        pstm = (java.sql.PreparedStatement) conn.prepareStatement(sql);

        rset = pstm.executeQuery();

        while (rset.next()) {

            Contato contato = new Contato();

            //Recuperar o id
            contato.setId(rset.getInt("id"));
            //Recuperar o nome
            contato.setNome(rset.getString("nome"));
            //Recuperar a idade
            contato.setId(rset.getInt("idade"));
            //Recuperar a data de cadastrado
            contato.setDataCadastro(rset.getDate("datacadastro"));
          //Recuperar o email
            contato.setEmail(rset.getString("email"));
          //Recuperar o nome
            contato.setTelefone(rset.getString("telefone"));
          //Recuperar o nome
            contato.setEndereco(rset.getString("endereco"));

            contatos.add(contato);

        }
    }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if(rset!=null) {
                    rset.close();
                }

                if(pstm!=null) {
                    pstm.close();
                }

                if(conn!=null) {
                    conn.close();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }

        return contatos;
}
}

