public class FilaCircular<T>
{
	private T[] data;
	private int primeiro = 0, ultimo = -1, tamanho = 0, MAX;
	
	public FilaCircular(int size)
	{
		MAX = size;
		data = (T[]) new Object[MAX];
	}
	
	boolean vazia()							// tamanho for 0, está vazia
	{
		return tamanho == 0;		
	}
	
	boolean cheia()							// tamanho for MAX, está cheia
	{
		return tamanho == MAX;
	}

	int tamanho()
	{
		return MAX;
	}
	
	void insere(T t)
	{
		if (cheia())
		{
			System.out.println("Fila está cheia. Não é possível inserir elementos.");
		}
		
		else 											// último começa em -1, adiciona 1	
		{												// quando chegar no final da fila, volta para 0. incrementa tamanho para fila não ficar vazia
			ultimo = (ultimo + 1) % MAX;						
			data[ultimo] = t;							// se MAX = 5 e último está no 2, deverá seguir ser 3, 4, 0, 1.
			tamanho++;									// 2 mod 5 = 2
														// 3 mod 5 = 3
//			if (primeiro == -1)							// 4 mod 5 = 4	
//			{											// 5 mod 5 = 0
//				primeiro = ultimo;						// 6 mod 5 = 1
//			}
		}
	}
	
	T remove()
	{				
		T removido = null;
		
		if (vazia())
		{
			System.out.println("Fila está vazia. Não é possível remover elementos.");
		}
		
		else
		{
			removido = data[primeiro];				    // remove o delemento na posição do primeiro

			primeiro = (primeiro + 1) % MAX;			// incrementa a tira o resto da divisão, análogo ao inserir
			tamanho--;									// decrementa o tamanho para fila não ficar cheia
		}
		
		return removido;
	}
	
	T primeiro()
	{
		return data[primeiro];
	}
	
	T ultimo()
	{
		return data[ultimo];
	}	
	
	/* funções de display */
	
	void insereDisplay(T t)
	{
		if (cheia())
		{
			System.out.println("Fila está cheia. Não é possível inserir elementos.");
		}
		
		else
		{
			ultimo = (ultimo + 1) % MAX;
			data[ultimo] = t;
			tamanho++;
			
			System.out.println("Elemento " + t + " inserido.");
			imprimirFila();
			
			if (primeiro == -1)
			{
				primeiro = ultimo;
			}
		}
	}
	
	T removeDisplay()
	{				
		T removido = null;
		
		if (vazia())
		{
			System.out.println("Fila está vazia. Não é possível remover elementos.");
		}
		
		else
		{
			removido = data[primeiro];
			data[primeiro] = null;							// para ficar vazio na função de exibição
			
			primeiro = (primeiro + 1) % MAX;
			tamanho--;										
		}
		
		System.out.println("Elemento " + removido + " removido.");
		imprimirFila();
		
		return removido;
	}
	
	void imprimirFila()
	{			
		for (int i = 0; i < 30; i++)
		{
			System.out.print("---");
		}			
					
		System.out.println();
		
		for (int i = 0; i < MAX; i++)
		{			
			System.out.format("| %2s " + " ", i);
		}
		
		System.out.println("| (tam = " + MAX + ")");
		
		for(int i = 0; i < 30; i++)
		{
			System.out.print("---");
		}
		
		System.out.println();
		
		for (int i = 0; i < MAX; i++)
		{								
			if (data[i] == null)				 			// null para desempilhar
			{
				System.out.print("|     "); 				// preenche com vazio quando desempilhar
			}
			
			else
			{
				System.out.print(String.format("|  %2s " + " ", data[i]));
			}						
		}
		
		System.out.println("|");
		
		for(int i = 0; i < 30; i++)
		{
			System.out.print("---");
		}			
		
		System.out.println();
	}	
}