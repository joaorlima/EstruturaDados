public class ListaSE<T>
{
	public No primeiro, ultimo;
	public int tamanho;
	
	public ListaSE()
	{
		this.primeiro = this.ultimo = null;
		tamanho = 0;
	}
	
	boolean vazia()
	{
		return this.primeiro == null;
	}	

	int getTamanho()
	{
		return tamanho;
	}
	
	void inserePrimeiro(int e)
	{
		No novo = new No(e);
		
		if(vazia())
		{
			this.primeiro = novo;
			this.ultimo = novo;
		}
		
		else
		{
			novo.setProximo(this.primeiro);
			this.primeiro = novo;
		}
		
		tamanho++;
	}
	
	No insereDepois(No p, int e)
	{
		No novo = new No(e);
		
		novo.setProximo(p.getProximo());
		
		p.setProximo(novo);
		
		tamanho++;
		
		return novo;		
	}
	
	void insereUltimo(int e)
	{
		if (vazia())
		{
			this.inserePrimeiro(e);
		}
		
		else
		{
			this.ultimo = this.insereDepois(this.ultimo, e);
		}	
	}
	
	void insereOrdenado(int e)
	{
		No aux = new No(e);
		
		if (this.vazia())
		{
			this.inserePrimeiro(e);
		}
		
		else
		{
			if (e < this.primeiro.getDado())
			{
				this.inserePrimeiro(e);
			}
			
			else
			{
				if (e >= this.ultimo.getDado())
				{
					this.insereUltimo(e);
				}
				
				else
				{
					No novo = primeiro;
					No prox = null;
					
					while (novo != null && novo.getDado() < aux.getDado())
					{

						prox = novo;						
						novo = novo.getProximo();
					}
															
					prox.setProximo(novo);
					
					this.insereDepois(prox, e);
					
				}
			}						
		}
	}
	
	int removePrimeiro() throws Exception
	{
		if (vazia())
		{
			throw new Exception("Lista está vazia. Não é possível remover o primeiro nó.");
		}
		
		else
		{			
			No novo = primeiro;
			
			primeiro = primeiro.getProximo();
			novo.setProximo(null);
			
			tamanho--;		
			
			return novo.getDado();	
		}	
	}
	
	int removeUltimo() throws Exception
	{
		if (vazia())
		{
			throw new Exception("Lista está vazia. Não é possível remover o último nó.");
		}
		
		else
		{
			No novo = primeiro;
			No anterior = null;
			
			while (novo.getProximo() != null)
			{
				anterior = novo;
				novo = novo.getProximo();
			}
			
			tamanho--;
			
			anterior.setProximo(null);

			return novo.getDado();			
		}
		
	}

	public No getPrimeiro()
	{
		return primeiro;
	}

	public void setPrimeiro(No primeiro)
	{
		this.primeiro = primeiro;
	}

	public No getUltimo()
	{
		return ultimo;
	}

	public void setUltimo(No ultimo)
	{
		this.ultimo = ultimo;
	}	
	
	public int getInfo(int index)
	{
		No current = primeiro;
		int count = 0;

		while (current != null)
		{
			if (count == index)
			{
				return current.getDado();
			}

			count++;
			current = current.getProximo();
		}

		return 0;
	}	  
	
	/* funções de display */	
	
	void mostrarLista()
	{				
		No p = this.primeiro;		
				
		for (int i = 0; i < 30; i++)
		{
			System.out.print("~~~");
		}			
					
		System.out.println();
		
		for (int i = 0; i < getTamanho(); i++)
		{			
			System.out.format("| %2s " + " ", i);
		}
		
		System.out.println("| (tam = " + getTamanho() + ")");
		
		for(int i = 0; i < 30; i++)
		{
			System.out.print("---");
		}
		
		System.out.println();
		
		for (int i = 0; i < getTamanho(); i++)
		{								
			if (p.getDado() == 37)				 			
			{
				System.out.print("|     "); 				
			}
			
			else
			{
				System.out.print(String.format("| %2s " + " ", p.getDado()));
				p = p.getProximo();
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
