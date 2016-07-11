
package br.ufg.inf.es.saep.sandbox.persistencia;

/**
 * Thread para snapshots de 3 em 3 horas
 * Evita a re-execução dos logs na inicialização do sisema
 * @author marjorie.goncalves
 */
public class SnapshotTimer extends Thread {
     Prevayler prevayler;  
  
    public SnapshotTimer(Prevayler prevayler) {  
        this.prevayler = prevayler;  
        this.setDaemon(true);  
    }  
  
     @Override
    public void run() {  
        super.run();  
  
        while (true) {  
            try {  
                Thread.sleep(1000 * 60 * 60 * 3); //3 horas  
                prevayler.takeSnapshot();  
                System.out.println("Snapshot disparado as " + new java.util.Date() + "...");      
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
}
