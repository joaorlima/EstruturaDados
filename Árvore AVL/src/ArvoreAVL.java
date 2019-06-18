class ArvoreAVL
{
	No raiz;	
	int tam = 0;			// conta o número de Nós
	
	boolean vazia()
	{
		return raiz == null;
	}
	
	int altura(No n)
	{
		return n == null ? 0 : n.altura;
	}
	
	int balanceado(No n)
	{
		return n == null ? -1 : (altura(n.esquerda) - altura(n.direita));
	}
	
	int getAltura()
	{
		return altura(raiz);
	}	

	int getNumeroElementos()
	{
		return tam;
	}

	int max(int a, int b)
	{
		return (a > b) ? a : b;
	}
	
	No min(No n)
	{
		No aux = n;

		while (aux.esquerda != null)
		{
			aux = aux.esquerda;
		}

		return aux;
	}

	No rotacionarDireita(No dir)
	{
		No novo = dir.esquerda;
		No aux = novo.direita;

		// rotaciona aqui
		novo.direita = dir;
		dir.esquerda = aux;

		dir.altura = max(altura(dir.esquerda), altura(dir.direita)) + 1;	 // altura é o max + 1
		novo.altura = max(altura(novo.esquerda), altura(novo.direita)) + 1;	 // altura é o max + 1

		return novo;
	}

	No rotacionarEsquerda(No esq)
	{
		No novo = esq.direita;
		No aux = novo.esquerda;

		// rotaciona aqui
		novo.esquerda = esq;
		esq.direita = aux;

		esq.altura = max(altura(esq.esquerda), altura(esq.direita)) + 1;		// altura é o max + 1
		novo.altura = max(altura(novo.esquerda), altura(novo.direita)) + 1;		// altura é o max + 1

		return novo;
	}
	
	/* -------------------------- INSERE -------------------------- */
	
	No insere(int dado, No n)
	{
		No novo = new No(dado);
		
		if (n == null)
		{			
			return novo;			
		}

		if (dado < n.dado)													// se o dado é menor, então está na esquerda
		{
			n.esquerda = insere(dado, n.esquerda);
		}
		
		else if (dado > n.dado)							   					// se o dado é maior, então está na direita			
		{
			n.direita = insere(dado, n.direita);
		}
		
		else 
		{
			return n;
		}
		
		n.altura = 1 + max(altura(n.esquerda), altura(n.direita));   		// atualizar altura

		int balance = balanceado(n);

		/* são 4 casos 
		 * esquerda-esquerda 	(b > 1 e n.esq > dado)
		 * esquerda-direita 	(b > 1 e n.esq < dado)
		 * direita-direita 		(b < -1 e n.dir <= dado)
		 * direita-esquerda 	(b < -1 e n.dir > dado)
		 */
		
		if (balance > 1 && dado < n.esquerda.dado)
		{
			return rotacionarDireita(n);
		}		

		if (balance > 1 && dado > n.esquerda.dado)
		{
			n.esquerda = rotacionarEsquerda(n.esquerda);
			return rotacionarDireita(n);
		}

		if (balance < -1 && dado > n.direita.dado)
		{
			return rotacionarEsquerda(n);
		}

		if (balance < -1 && dado < n.direita.dado)
		{
			n.direita = rotacionarDireita(n.direita);
			return rotacionarEsquerda(n);
		}

		return n;
	}
	
	void insere(int dado)
	{
		raiz = insere(dado, raiz);
		tam++;
	}	
	
	/* -------------------------- INSERE -------------------------- */
	
	/* -------------------------- REMOVE -------------------------- */
	
	No remove(int dado, No n)
	{
		if (n == null)
		{
			return n;
		}

		if (dado < n.dado) 										// se o dado é menor, então está na esquerda
		{
			n.esquerda = remove(dado, n.esquerda);
		}

		else if (dado > n.dado)							   		// se o dado é maior, então está na direita
		{
			n.direita = remove(dado, n.direita);		
		}

		else							                   		// se o dado é igual, então deleta o no		
		{   	
			
			if ((n.esquerda == null) || (n.direita == null)) 	// nó nulos à esquerda e direita
			{
				No novo = null;
				if (novo == n.esquerda)
				{
					novo = n.direita;
				}
				
				else
				{
					novo = n.esquerda;
				}
				
				if (novo == null)
				{
					novo = n;
					n = null;
				} 
				
				else 
				{
					n = novo; 
				}
									
			} 
			
			else
			{
				No novo = min(n.direita);								// inordem

				n.dado = novo.dado;

				n.direita = remove(novo.dado, n.direita);
			}
		}
		
		if (n == null)
		{
			return n;
		}
		
		n.altura = max(altura(n.esquerda), altura(n.direita)) + 1;				// atualiza altura

		int balance = balanceado(n);

		/* 4 casos, análogo ao insere */
		
		if (balance > 1 && balanceado(n.esquerda) >= 0)
		{
			return rotacionarDireita(n);
		}

		if (balance > 1 && balanceado(n.esquerda) < 0)
		{
			n.esquerda = rotacionarEsquerda(n.esquerda);
			return rotacionarDireita(n);
		}

		if (balance < -1 && balanceado(n.direita) <= 0)
		{
			return rotacionarEsquerda(n);
		}
		
		if (balance < -1 && balanceado(n.direita) > 0)
		{
			n.direita = rotacionarDireita(n.direita);
			return rotacionarEsquerda(n);
		}

		return n;
	}	
	
	void remove(int dado)
	{
		raiz = remove(dado, raiz);
		tam--;
	}

	/* -------------------------- REMOVE -------------------------- */
	
	/* -------------------------- PROCURA ELEMENTO -------------------------- */	
	
	boolean existeElemento(int dado, No n)
	{
		boolean procura = false;

		while ((n != null) && (!procura))
		{
			int valorProcura = n.dado;

			if (dado < valorProcura)
			{
				n = n.esquerda;
			}

			else if (dado > valorProcura)
			{
				n = n.direita;
			}
			
			else
			{
				procura = true;

				break;
			}

			procura = existeElemento(dado, n);
		}
		
		return procura;
	}
	
	boolean existeElemento(int val)
	{
		return existeElemento(val, raiz);
	}
	
	/* -------------------------- PROCURA ELEMENTO -------------------------- */	
	
	/* IN ORDEM */ 
	private void inOrdem(No n)
	{			
		if (n != null)
		{
			inOrdem(n.esquerda);	

			System.out.print(String.format("%2s " + " ", n.dado));

			inOrdem(n.direita);
		}
	}

	public void imprimeInOrdem()
	{
		inOrdem(raiz);
	}
	
	private void preOrdem(No n)
	{
		if (n != null)
		{
			System.out.print(String.format("%2s " + " ", n.dado));

			preOrdem(n.esquerda);

			preOrdem(n.direita);
		}
	}	
	
	public void imprimePreOrdem()
	{
		preOrdem(raiz);
	}
	
	private void posOrdem(No n)
	{
		if (n != null)
		{
			posOrdem(n.esquerda);
			
			posOrdem(n.direita);
			
			System.out.print(String.format("%2s " + " ", n.dado));
		}
	}
	
	public void imprimePosOrdem()
	{
		posOrdem(raiz);
	}	
}