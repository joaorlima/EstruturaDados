import java.util.Arrays;

public class Pilha<T>
{
	int top = -1;
	private T[] data;
	int MAX;

	public Pilha(int size)
	{
		MAX = size;
		data = (T[]) new Object[size];
		Arrays.fill(data, null);
		System.out.println("Pilha de tamanho " + MAX + " criada.");
		mostrarPilha();
	}
	
	String topo()
	{
		if (vazia())
		{
			return "Pilha está vazia. Não existe elemento no topo.";
		}
		
		else
		{
			return "Elemento no topo: " + data[top];
		}		
	}
	
	boolean vazia() 		// boolean para usar nos outros métodos 
	{
		if (top == -1)
		{
			return true; 	// 1
		}
		
		else
		{
			return false; 	// 0
		}
	}
	
	boolean cheia() 		// boolean para usar nos outros métodos
	{
		if (top + 1 == MAX)
		{
			return true; 	// 1
		}
		
		else
		{
			return false; 	// 0
		}
	}
	
	void empilhar(T t)
	{
		if (!cheia()) 				// empilhar o elemento o caso a pilha não esteja cheia
		{
			top++;
			data[top] = t;
			
			System.out.println("Elemento " + t + " adicionado.");
			
			mostrarPilha();
		}
		
		else
		{
			System.out.println("A pilha está cheia. Não é possível adicionar mais elementos.");
		}		
	}
	
	Object desempilhar()
	{
		if (!vazia()) 				// desempilhar o elemento do topo caso a lista não esteja vazia
		{
			System.out.println("Elemento " + data[top] + " removido.");
			
			Object x = data[top]; 		// topo vira null e a pilha fica vazia na posição
			
			top--;
			
			mostrarPilha();
			
			return x; 	// valor do topo vai descendo
		}
		
		else
		{
			System.out.println("A pilha está vazia. Não existem elementos para remover.");
			
			return null; 			// para não mostrar na posição do elemento removido
		}
	}	
	
	void mostrarPilha()
	{				
		for (int i = 0; i < 30; i++)
		{
			System.out.print("~~~");
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
				System.out.print(String.format("| %2s "+ " ", data[i]));
			}						
		}
		
		System.out.println("|");
		
		for(int i = 0; i < 30; i++)
		{
			System.out.print("~~~");
		}			
		
		System.out.println();
	}	
}