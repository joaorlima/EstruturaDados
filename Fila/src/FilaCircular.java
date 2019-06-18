public class FilaCircular<T>
{
	private T[] data;
	private int primeiro = 0, ultimo = -1, tamanho = 0, MAX;
	
	public FilaCircular(int size)
	{
		MAX = size;
		data = (T[]) new Object[MAX];
	}
	
	boolean vazia()							// tamanho for 0, est� vazia
	{
		return tamanho == 0;		
	}
	
	boolean cheia()							// tamanho for MAX, est� cheia
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
			System.out.println("Fila est� cheia. N�o � poss�vel inserir elementos.");
		}
		
		else 											// �ltimo come�a em -1, adiciona 1	
		{												// quando chegar no final da fila, volta para 0. incrementa tamanho para fila n�o ficar vazia
			ultimo = (ultimo + 1) % MAX;						
			data[ultimo] = t;							// se MAX = 5 e �ltimo est� no 2, dever� seguir ser 3, 4, 0, 1.
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
			System.out.println("Fila est� vazia. N�o � poss�vel remover elementos.");
		}
		
		else
		{
			removido = data[primeiro];				    // remove o delemento na posi��o do primeiro

			primeiro = (primeiro + 1) % MAX;			// incrementa a tira o resto da divis�o, an�logo ao inserir
			tamanho--;									// decrementa o tamanho para fila n�o ficar cheia
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
	
	/* fun��es de display */
	
	void insereDisplay(T t)
	{
		if (cheia())
		{
			System.out.println("Fila est� cheia. N�o � poss�vel inserir elementos.");
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
			System.out.println("Fila est� vazia. N�o � poss�vel remover elementos.");
		}
		
		else
		{
			removido = data[primeiro];
			data[primeiro] = null;							// para ficar vazio na fun��o de exibi��o
			
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