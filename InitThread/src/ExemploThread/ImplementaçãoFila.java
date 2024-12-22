package ExemploThread;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ImplementaçãoFila extends Thread{
	
	/*CRIAMOS UM OBJETO QUE NA VERDADE É UMA THREAD*/
	
	
	private static ConcurrentLinkedQueue<ObjetoFilaThread> 
	
	                            pilha_fila = new ConcurrentLinkedQueue<ObjetoFilaThread>();
	
	public static void add(ObjetoFilaThread objetoFilaThread) {
		pilha_fila.add(objetoFilaThread);
	}
	
	
	@Override
	public void run() {
		
		
		while (true) {
		
		synchronized (pilha_fila) { /* Bloqueia o acesso a está lista por outros processos */     /* Oque fiz foi que apenas essa minha Therad acesse essa minha lista (Pilha_fila)*/
			
			Iterator iteraçao = pilha_fila.iterator();

			while (iteraçao.hasNext()) /*Enquanto conter dados na lista irá processar*/ {
				
				ObjetoFilaThread processar = (ObjetoFilaThread) iteraçao.next(); /* Pega o objeto atual*/
				
				System.out.println("------------------------------------");
				
				System.out.println(processar.getEmail());
				
				System.out.println("________________________________________");
				
				System.out.println(processar.getNome());
				
				System.out.println("------------------------------------");


				
				iteraçao.remove();
				
				
				/* Pega o objeto, faz oque foi nessessario de acordo com a regra de negocio*/
				
				try {
					Thread.sleep(1000); /*Da um tempo para a descarga de memoria*/ 
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
			}
			
		}
		try {
			Thread.sleep(1000); /* Tempo para a limpeza e descarga de memoria*/
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		}
	}
	

}
