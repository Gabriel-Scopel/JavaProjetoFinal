/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg222210262_gabriel_desouzascopel_projeto.controller;


import static java.lang.Math.pow;
import javax.swing.JTextField;
import pkg222210262_gabriel_desouzascopel_projeto.view.FrmUsuario;

import pkg222210262_gabriel_desouzascopel_projeto.dao.Conexao;
import pkg222210262_gabriel_desouzascopel_projeto.dao.UsuarioDao;
import pkg222210262_gabriel_desouzascopel_projeto.model.*;
import java.lang.Math.*;
import java.text.NumberFormat;
import java.text.DecimalFormat;

import java.sql.Connection;
import java.sql.SQLException;
import javax.swing.JOptionPane;




/**
 *
 * @author Gabriel Scopel
 * @classe UsuarioController. Tem por finalidade fazer a intermediação entre a view e o model
 * @version 1.0
 * @see FrmUsuario
 */
public class UsuarioController {
    
    //definindo os valores de constantes que serão utilizadas nos cálculos
    private double h = 6.626 * pow(10, -34);//j.s
    private double c = 3*pow(10,8);// m/s
    
    //criando a variável janela que será do tipo FrmUsuario
    private FrmUsuario janela;
    
    //criando um construtor para nossa classe 
    //@param janela é a view 
    public UsuarioController(FrmUsuario janela) {
        this.janela =janela;
    }

    public void calculaUsuario() throws Exception {
        //valores digitados pelo usuário e constantes
        Boolean tipo = janela.getProton().isSelected();
        char entrada = tipo ?  'P' : 'E';
        Double largura = Double.valueOf(janela.getTxtLargura().getText());
        Double nInicial = Double.valueOf(janela.getTxtNinicial().getText());
        Double nFinal = Double.valueOf(janela.getTxtnFinal().getText());
        Double A = Double.valueOf(janela.getTxtA().getText());
        Double B = Double.valueOf(janela.getTxtB().getText());
        Double m = 0.00;
        
        //formatação decimal
        DecimalFormat df = new DecimalFormat("0.##");
       
        //muda o valor da massa se for próton ou elétron
        if ('E' == entrada) {
                
            m = 9.109 * pow(10, -31);

        } else if ('P' == entrada) {

            m = 1.672 * pow(10, -27);
 
        } else {
            System.out.println("Entrada inválida");
        }
        
        //instanciando calcula como "conta"
        /*
        @parame largura. Se refere a largura informada pelo usuário
        @param nInicial. Se refere ao nível inicial informado pelo usuário
        @param nFinal. Se refere ao nível Final informado pelo usuário
        @param A. Se refere ao A informado pelo usuário
        @param B. Se refere ao B informado pelo usuário
        A e B serão utilizados para calcular a probabilidade
        @param m. Se refere a massa da partícula definida pelo usuário (próton ou elétron)
        */
        Calcula conta = new Calcula(largura, nInicial, nFinal, A, B, m);
        
        //calculando os valores no model
        /*
        @param h. Se refere a constante de planck
        @param En1. Se refere a energia no nível inicial
        @param En2. se refere a energia no nível final
        @param c. Se refere a velocidade da luz no vácuo
        */
        Double En1 = conta.EnergiaInicial(h);
        String EnInicioJ = conta.Formatador(En1);//j
        String EnInicioEv = conta.Formatador(En1/1.602e-19);// eV
        Double En2 = conta.EnergiaFinal(h);
        String EnFinalJ = conta.Formatador(En2);//j
        String EnFinalEv = conta.Formatador(En2/1.602e-19);// eV
        
        Double En = conta.Energia(En1, En2);
        String EnergiaJ = conta.Formatador(En);//J
        String EnergiaEv = conta.Formatador(En/1.602e-19);//eV
        
        
        String Freq = conta.Freq(En, h);
        String Comp = conta.Comp(En, h, c);
        
        String VLinicio = conta.Velo(En1, h,1);
        String VLfinal = conta.Velo(En2, h,2);
        
        String Funcao1 = conta.FuncaoProb(1);
        String Funcao2 = conta.FuncaoProb(2);
        //print dos resultados
        janela.getResposta().setText(
                "Energia de Início: "+ EnInicioJ +" J ou "+ EnInicioEv+" eV\n"
                +"Energia de Final: "+ EnFinalJ +" J ou "+EnFinalEv+" eV\n\n"
                +"Energia Total: "+ EnergiaJ+" J ou "+EnergiaEv+" eV\n"
                + Freq +"\n"
                + Comp +"\n"
                + VLinicio +"\n"
                + VLfinal +"\n"
                + Funcao1 +"\n"
                + Funcao2
                
        );
        //instanciando a classe UsuarioDao que cuidará do banco de dados e passando para ela os valores que serão inseridos
        UsuarioDao u = new UsuarioDao();
        u.insere(conta);

    }
    //Classe semelhante a classe de cima (calculaUsuario) porém aqui não teremos a utilização do banco de dados, dessa forma, o usuário pode obter 
    //os valores desejados fisicamente sem que ele tenha o banco de dados instalado e sem que necessite fazer alguma modificação no código que o banco local
    public void calculaUsuario2(){
        //valores digitados pelo usuário e constantes
        Boolean tipo = janela.getProton().isSelected();
        char entrada = tipo ?  'P' : 'E';
        Double largura = Double.valueOf(janela.getTxtLargura().getText());
        Double nInicial = Double.valueOf(janela.getTxtNinicial().getText());
        Double nFinal = Double.valueOf(janela.getTxtnFinal().getText());
        Double A = Double.valueOf(janela.getTxtA().getText());
        Double B = Double.valueOf(janela.getTxtB().getText());
        Double m = 0.00;
        
        //formatação decimal
        DecimalFormat df = new DecimalFormat("0.##");
       
        //muda o valor da massa se for próton ou elétron
        if ('E' == entrada) {
                
            m = 9.109 * pow(10, -31);

        } else if ('P' == entrada) {

            m = 1.672 * pow(10, -27);
 
        } else {
            System.out.println("Entrada inválida");
        }
        
        //instanciando calcula como "conta"
        /*
        @parame largura. Se refere a largura informada pelo usuário
        @param nInicial. Se refere ao nível inicial informado pelo usuário
        @param nFinal. Se refere ao nível Final informado pelo usuário
        @param A. Se refere ao A informado pelo usuário
        @param B. Se refere ao B informado pelo usuário
        A e B serão utilizados para calcular a probabilidade
        @param m. Se refere a massa da partícula definida pelo usuário (próton ou elétron)
        */
        Calcula conta = new Calcula(largura, nInicial, nFinal, A, B, m);
        //utilizando o model para realizar os cálculos
        Double En1 = conta.EnergiaInicial(h);
        String EnInicioJ = conta.Formatador(En1);//j
        String EnInicioEv = conta.Formatador(En1/1.602e-19);// eV
        Double En2 = conta.EnergiaFinal(h);
        String EnFinalJ = conta.Formatador(En2);//j
        String EnFinalEv = conta.Formatador(En2/1.602e-19);// eV
        
        Double En = conta.Energia(En1, En2);
        String EnergiaJ = conta.Formatador(En);//J
        String EnergiaEv = conta.Formatador(En/1.602e-19);//eV
        
        
        String Freq = conta.Freq(En, h);
        String Comp = conta.Comp(En, h, c);
        
        String VLinicio = conta.Velo(En1, h,1);
        String VLfinal = conta.Velo(En2, h,2);
        
        String Funcao1 = conta.FuncaoProb(1);
        String Funcao2 = conta.FuncaoProb(2);
        //print dos resultados
        janela.getResposta().setText(
                "Energia de Início: "+ EnInicioJ +" J ou "+ EnInicioEv+" eV\n"
                +"Energia de Final: "+ EnFinalJ +" J ou "+EnFinalEv+" eV\n\n"
                +"Energia Total: "+ EnergiaJ+" J ou "+EnergiaEv+" eV\n"
                + Freq +"\n"
                + Comp +"\n"
                + VLinicio +"\n"
                + VLfinal +"\n"
                + Funcao1 +"\n"
                + Funcao2
                
        );
    
    }
    
    

}
