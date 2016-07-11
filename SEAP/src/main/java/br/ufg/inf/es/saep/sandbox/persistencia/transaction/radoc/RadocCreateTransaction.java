
package br.ufg.inf.es.saep.sandbox.persistencia.transaction.radoc;

import br.ufg.inf.es.saep.sandbox.dominio.Parecer;
import br.ufg.inf.es.saep.sandbox.dominio.Radoc;
import br.ufg.inf.es.saep.sandbox.persistencia.bo.ListaParecer;
import java.util.Date;
import org.prevayler.TransactionWithQuery;

/**
 *Transaction criação/persistencia de radoc
 * 
 * @author Marjorie
 */
public class RadocCreateTransaction implements TransactionWithQuery {
    private final String idParecer;
    private final String idRadoc;
    
    public RadocCreateTransaction(String idP, String idR){
        this.idParecer = idP;
        this.idRadoc = idR;
    }

    @Override
    public Object executeAndQuery(Object prevalentSystem, Date executionTime) throws Exception {
        Parecer novoParecer = ((ListaParecer) prevalentSystem).byId(idParecer);
        Radoc novoRadoc = ((ListaParecer) prevalentSystem).radocById(idRadoc);
        novoParecer.getRadocs().add(idRadoc);
        ((ListaParecer) prevalentSystem).persisteRadoc(novoRadoc);

        return novoRadoc;
    }
}
