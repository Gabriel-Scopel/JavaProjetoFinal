/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg222210262_gabriel_desouzascopel_projeto.controller;

import java.awt.Color;
import java.awt.Graphics;
import java.util.logging.Logger;
import java.util.logging.Level;
import pkg222210262_gabriel_desouzascopel_projeto.view.Animacao;

/**
 *
 * @author Gabriel Scopel
 * @classe AnimacaoController. Tem por finalidade organizar as informações do view da animação, definindo as propriedades que setão empregadas
 * @version 1.0
 * @see Animacao
 */
public class AnimacaoController {
    //criando variável j que será do tipo Animacao
    private Animacao j;
    //passando o valor de j pelo construtor da classe
    public AnimacaoController(Animacao j) {
        this.j = j;
    }
    //método responsável pela animação
    public void Anima(){
        //capturando o elemento gráfico da interface
        Graphics g = j.getCanvas1().getGraphics();
        
        //desenhando os principais elementos: colunas e linhas que representam os níveis de energia
        g.setColor(Color.blue);
        g.fillRect(200, 279, 350, 2);
        g.drawString("n=1", 215, 269);
        
        g.setColor(Color.red);
        g.fillRect(200, 249, 350, 2);
        g.drawString("n=2", 215, 239);
        
        g.setColor(Color.yellow);
        g.fillRect(200, 219, 350, 2);
        g.drawString("n=3", 215, 209);
        
        g.setColor(Color.green);
        g.fillRect(200, 189, 350, 2);
        g.drawString("n=4", 215, 179);
        
        g.setColor(Color.MAGENTA);
        g.fillRect(200, 159, 350, 2);
        g.drawString("n=5", 215, 149);
        /*
        dentro do for vamos desenhar de forma repetitiva o fóton e a partícula para que o efeito de animação seja produzido
        quando a partícula vai sendo desenhada no nível energético, estamos desenhando e apagando repetidamente a partícula 
        e o nível, apagando seu rastro e recriando um novo elemento
        */
        for(int x = 400; x>=200;x--){
            g.setColor(Color.pink);
            g.fillOval(x, 275, 10, 10);
            g.setColor(Color.ORANGE);
            g.fillOval(-1*(x-390), 275, 20, 15);
            try {
                Thread.sleep(15);
                g.setColor(Color.white);
                g.fillOval(x, 275, 10, 10);
                g.fillOval(-1*(x-390), 275, 20, 15);
                g.setColor(Color.blue);
                g.fillRect(250, 279, 350, 2);
                g.fillRect(200, 279, 350, 2);
                g.setColor(Color.black);
                g.fillRect(200, 0, 4, 500);
            } catch (InterruptedException e) {
                Logger.getLogger(Animacao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        for(int x = 200; x<=400;x++){
            g.setColor(Color.red);
            g.fillOval(x+10, 155, 10, 10);
            
            try {
                Thread.sleep(15);
                g.setColor(Color.white);
                g.fillOval(x+10, 160, 2, 2);
                g.fillOval(x, 154, 21, 15);
                g.setColor(Color.MAGENTA);
                g.fillRect(250, 160, 350, 2);
                g.fillRect(200, 160, 350, 2);
                g.setColor(Color.black);
                g.fillRect(200, 0, 4, 500);
                
                
            } catch (InterruptedException e) {
                Logger.getLogger(Animacao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        for(int x = 400; x>=200;x--){
            g.setColor(Color.red);
            g.fillOval(x, 155, 10, 10);
            
            try {
                
                Thread.sleep(15);
                g.setColor(Color.white);
                g.fillOval(x+10, 160, 10, 10);
                g.fillOval(x, 154, 20, 15);
                g.setColor(Color.MAGENTA);
                g.fillRect(250, 160, 350, 2);
                g.fillRect(200, 160, 350, 2);
                g.setColor(Color.black);
                g.fillRect(200, 0, 4, 500);
                
                
                
            } catch (InterruptedException e) {
                Logger.getLogger(Animacao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        for(int x = 200; x>=0;x--){
            g.setColor(Color.ORANGE);
            g.fillOval(x, 155, 10, 10);
            
            try {
                Thread.sleep(15);
                g.setColor(Color.white);
                g.fillOval(x, 155, 10, 10);
                g.fillOval(-1*(x-390), 150, 20, 15);
                g.setColor(Color.MAGENTA);
                g.fillRect(250, 160, 350, 2);
                g.fillRect(200, 160, 350, 2);
                g.setColor(Color.black);
                g.fillRect(200, 0, 4, 500);
            } catch (InterruptedException e) {
                Logger.getLogger(Animacao.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        g.setColor(Color.ORANGE);
            g.fillOval(210, 275, 10, 10);
        
        
        
    }
    
}

