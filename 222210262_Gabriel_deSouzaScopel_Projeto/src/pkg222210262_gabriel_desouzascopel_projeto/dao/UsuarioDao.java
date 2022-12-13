/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg222210262_gabriel_desouzascopel_projeto.dao;

/**
 *
 * @author Gabriel Scopel
 * @class UsuarioDao. Responsável por intermediar as informações obtidas e o banco de dados
 * @version 1.0
 * @see Conexao
 */
import static java.lang.Math.pow;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import pkg222210262_gabriel_desouzascopel_projeto.model.Calcula;

public class UsuarioDao {

    //criando uma variável conn do tipo Conexao
    private Conexao conn;

    //settando o valor da variável conn usando a classe Conexao (pegando o valor retornado de getConexao)
    public UsuarioDao() throws Exception {
        this.conn = Conexao.getConexao();
    }
    
   //método responsável por inserir as informações obtidas no model no banco de dados
    public boolean insere(Calcula o) throws SQLException {
        
        //criando a string responsável por fazer a comunicação de cada coluna da tabela com as informações que desejamos inserir
        String sql = "INSERT INTO projeto (En, En2, energia, freq,lamb,vi,compi,vf,compf,funci,pi,funcf,pf) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
        //utilizando a string sql para fazer a inserção
        PreparedStatement ps = this.conn.getDriver().prepareStatement(sql);
        //setando cada valor em sua coluna
        ps.setDouble(1, o.getEn());
        ps.setDouble(2, o.getEn2());
        ps.setDouble(3, o.getEnergia());
        ps.setString(4, o.getFreq());
        ps.setString(5, o.getLamb());
        ps.setString(6, o.getVi());
        ps.setString(7, o.getCompi());
        ps.setString(8, o.getVf());
        ps.setString(9, o.getCompf());
        ps.setString(10, o.getFunci());
        ps.setString(11, o.getPi());
        ps.setString(12, o.getFuncf());
        ps.setString(13, o.getPf());
        //retornando um execute da solicitação
        return ps.execute();
    }
}
