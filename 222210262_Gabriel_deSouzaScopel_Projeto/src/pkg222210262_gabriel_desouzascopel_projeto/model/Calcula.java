/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pkg222210262_gabriel_desouzascopel_projeto.model;

import static java.lang.Math.pow;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import pkg222210262_gabriel_desouzascopel_projeto.dao.UsuarioDao;
import pkg222210262_gabriel_desouzascopel_projeto.view.FrmUsuario;

/**
 *
 * @author Gabriel Scopel
 * @class Calcula. Responsável pela parte lógica, fazer os cálculos desejados
 * @version 1.0
 * 
 */
public class Calcula {
    
    //inputs do usuário e variáveis que serão usadas nos cálculos
    private double largura;
    private double nInicial;
    private double nFinal;
    private double a;
    private double b;
    private double m;
    //valores retornados nos calculos que serão usados em novos cálculos e que serão encaminhados posteriormente para a view
    private double En;
    private double En2;
    private double energia;
    private String freq;
    private String lamb;
    private String vi;
    private String compi;
    private String vf;
    private String compf;
    private String funci;
    private String pi;
    private String funcf;
    private String pf;

    //Construtor que possui como parâmetro os valores digitados pelo usuário, esses valores serão settados e utilizados nos cálculos
    /*
    @param largura. Se refere a largura inserida pelo usuário
    @param nInicial. Se refere ao nível inicial inserido pelo usuário
    @param nFinal. Se refere ao nível final inserido pelo usuário
    @param a. Se refere ao A inserido pelo usuário
    @param b. Se refere ao B inserido pelo usuário
    A e B serão utilizados para calcular a probabilidade
    @param m. Se refere a massa definida pelo usuário (próton ou elétron)
    */
    public Calcula(double largura, double nInicial, double nFinal, double a, double b, double m) {
        this.largura = largura;
        this.nInicial = nInicial;
        this.nFinal = nFinal;
        this.a = a;
        this.b = b;
        this.m = m;
    }
    //os próximos méotodos são os getter e setter das propriedades acima
    public double getEn() {
        return En;
    }

    public double getLargura() {
        return largura;
    }

    public double getnInicial() {
        return nInicial;
    }

    public double getnFinal() {
        return nFinal;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getM() {
        return m;
    }

    public double getEn2() {
        return En2;
    }

    public double getEnergia() {
        return energia;
    }

    public String getFreq() {
        return freq;
    }

    public String getLamb() {
        return lamb;
    }

    public String getVi() {
        return vi;
    }

    public String getCompi() {
        return compi;
    }

    public String getVf() {
        return vf;
    }

    public String getCompf() {
        return compf;
    }

    public String getFunci() {
        return funci;
    }

    public String getPi() {
        return pi;
    }

    public String getFuncf() {
        return funcf;
    }

    public String getPf() {
        return pf;
    }
    //formatando os valores obtidos
    public String Formatador(double number) {
        NumberFormat numFormat = new DecimalFormat();
        numFormat = new DecimalFormat("0.###E0");

        return numFormat.format(number).replace(',', '.');
    }
    //calcula o valor de En
    //@param h é a constante de planck
    public double EnergiaInicial(double h){
        Double En = ((h * h * nInicial * nInicial)) / (8 * m * pow(largura, 2));
        this.En = En;
        return En;
    }
    //calcula o valor de Energia Final
    //@param h é a constante de planck
    public double EnergiaFinal(double h){
        Double En2 = ((h * h * nFinal * nFinal)) / (8 * m * pow(largura, 2));
        this.En2 = En2;
        return En2;
    }
    /*calcula o valor de Energia
    @param En1. Se refere a energia no nível inicial
    @param En2. Se refere a energia no nível final*/
    public double Energia(double En1, double En2){
        Double energia = Math.abs(En2 - En1);
        this.energia = energia;
        return energia;
    }
    /*
    Calcula a frequência
    @param energia. Se refere a energia calculada
    @param h. Se refere a constante de planck
    */
    public String Freq(Double energia, double h){
        Double freq = energia / h;
        this.freq = Formatador(freq);
        return "Frequencia: "+Formatador(freq) + " Hz";
    }
    /*
    Calcula o comprimento de onda
    @param energia. Se refere a energia calculada
    @param h. Se refere a constante de planck
    @param c. Se refere a velocidade da luz no vácuo
    */
    public String Comp(Double energia, double h, double c){
        Double lamb = (h * c / energia);
        this.lamb = Formatador(lamb);
        return "Comprimento de onda: "+Formatador(lamb)+" m";
    }
    /*
    Calcula a velocidade
    @param En. Se refere a energia 
    @param h. Se refere a constante de planck
    @param n. se refere ao nível
    */
    public String Velo(Double En, double h, int n){
        double V = Math.sqrt(2 * En / m);
        Double L = h/Math.sqrt(2 * En * m);
        
        if (n==1){
           this.vi = Formatador(V);
           this.compi = Formatador(L);
            return "\nVelocidade no Nível Inicial: "+Formatador(V) + "m/s"
                +"\nComprimento de Onda Broglie no Nível Incial(λ): "+Formatador(L)+ " m";
        }else{
            this.vf = Formatador(V);
            this.compf = Formatador(L);
            return "\nVelocidade no Nível Final: "+Formatador(V) + " m/s"
                +"\nComprimento de Onda Broglie no Nível Final(λ): "+Formatador(L) +" m";
        }
        
    }
    //calculo da probabilidade entre A e B
    public String FuncaoProb(int n){
        Double f = Math.sqrt(2 / largura);
        double K =0.00;
        double integral;
        
        //verificando se o nível é fundamental 
        if (n == 1){
            K = (nInicial*Math.PI)/largura;
            integral = (b - a) - (((Math.sin(2*K*b))/(2*K))- (Math.sin(2*K*a))/(2*K));
            this.funci = "ψ(x)= "+Formatador(f)+" sen( "+Formatador(K)+" x)";
            this.pi = Formatador((integral/largura)*100)+"%";
            return "\nFunção Quantica no Nível Inicial:  ψ(x)= "+Formatador(f)+" sen( "+Formatador(K)+" x)"
                    + "\nP( "+a+" ≤ X ≤ "+b+") no Nível Inicial: "+Formatador((integral/largura)*100)+" %";
        }
        else{
            
            K = (nFinal*Math.PI)/largura;
            integral = (b - a) - (((Math.sin(2*K*b))/(2*K))- (Math.sin(2*K*a))/(2*K));
            this.funcf = "ψ(x)= "+Formatador(f)+" sen( "+Formatador(K)+" x)";
            this.pf = Formatador((integral/largura)*100)+"%";
            return "\nFunção Quantica no Nível Final:  ψ(x)= "+Formatador(f)+" sen( "+Formatador(K)+" x)"
                    + "\nP( "+a+" ≤ X ≤ "+b+") no Nível Final: "+Formatador((integral/largura)*100)+" %";
        }
        
    }
    
    
    
   
    
    


    
    
}
