package br.ufg.inf.es.saep.sandbox.persistencia.teste;


import br.ufg.inf.es.saep.sandbox.dominio.Nota;
import br.ufg.inf.es.saep.sandbox.dominio.Pontuacao;
import br.ufg.inf.es.saep.sandbox.dominio.Valor;
import br.ufg.inf.es.saep.sandbox.persistencia.FactoryParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.businessObject.ListaParecer;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerChangeAddNotaTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerChangeFundamentacaoTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerCreateTransaction;
import br.ufg.inf.es.saep.sandbox.persistencia.transaction.parecer.ParecerDeleteTransaction;
import org.prevayler.Prevayler;
import java.util.*;

/**
 * Classe com o método main() - Utiliza o padrão de projeto Factory para criar
 * objetos necessários para o Prevayler funcionar, indicando que as classes
 *
 * @author Marjorie
 */
public class Main {

    /**
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        //cria e configura factory de parecer
        FactoryParecer novaFactory = new FactoryParecer();
        //
        Prevayler prev = novaFactory.prevayler;
        
        //Criação de listas para testes e scanner
        Scanner scan = new Scanner(System.in);
        List<String> radoc = new ArrayList();
        radoc.add("radoc1");
        List<Pontuacao> pontos = new ArrayList();
        pontos.add(new Pontuacao("ponto", new Valor("12")));
        List<Nota> notas = new ArrayList();
                
        
        ListaParecer list = new ListaParecer();
        //transition criar e persistir parecer
        try {
                prev.execute(new ParecerCreateTransaction("1", "resolucaoId", radoc, pontos, "fundamentacao", notas));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        //remover parecer
        try {
                prev.execute(new ParecerDeleteTransaction("id"));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
        //adiciona nota
        try {
                //prev.execute(new ParecerChangeAddNotaTransaction("id",));
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                
        try {
                prev.execute(new ParecerChangeFundamentacaoTransaction("id", "fundamentacao"));
                System.out.println("Parecer .");
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
    }
}

