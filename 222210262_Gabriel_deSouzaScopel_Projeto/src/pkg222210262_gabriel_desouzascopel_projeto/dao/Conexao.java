/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg222210262_gabriel_desouzascopel_projeto.dao;

/**
 *
 * @author Gabriel Scopel
 * @class Conexao. Realiza conexao com o banco de dados
 * @version 1.0
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

import java.sql.DriverManager;

public class Conexao {
    //criando a variável conn que será do tipo Conexao
    private static Conexao conn;
    //criando a variável driver que será do tipo Connection
    private Connection driver;

    //criando o construtor da classe
    public Conexao() throws SQLException {
        this.criaConexao();
    }
    //criando um novo construtor de forma com que ele só estabelecerá uma nova conexão se outra anterior já não tiver sido feito nesse momento
    public static Conexao getConexao() throws SQLException {
        if (conn == null) {
            conn = new Conexao();
        }
        return conn;
    }
    //criaConexao é um método responsável nos conectar ao banco de dados local 
    private void criaConexao() throws SQLException {
        /*setando o valor do driver como o valor do endereço do banco de dados local desejado, passando como 
        parâmetro da função o endereço, o host e a senha*/
        this.driver = DriverManager.getConnection("jdbc:postgresql://localhost:8080/postgres", "postgres", "123");
    }
    //getter responsável por devolver o valor setado na variável driver
    public Connection getDriver() {
        return driver;
    }
}
