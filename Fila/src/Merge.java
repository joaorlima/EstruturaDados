public class Merge<T>
{
	static FilaCircular<Integer> merge(FilaCircular<Integer> a, FilaCircular<Integer> b)
	{
		FilaCircular<Integer> r = new FilaCircular<Integer>(a.tamanho() + b.tamanho());
		
		do
		{
			if (a.vazia() && b.vazia())							// se a ou b forem vazias, não tem o que fazer
			{
				break;
			}
			
			else if (a.vazia())
			{
				r.insere(b.remove());							// a vazia -> insere o primeiro elemento de a (menor pois é crescente)
			}
			
			else if (b.vazia())
			{
				r.insere(a.remove());							// b vazia -> insere o primeiro elemento de b (menor pois é crescente)
			}
			
			else if (a.primeiro() < b.primeiro())
			{
				r.insere(a.remove());							// insere o menor elemento entre a e b
			}
			
			else if (a.primeiro() > b.primeiro())			   // insere o menor elemento entre a e b
			{
				r.insere(b.remove());
			}			
		}
		
		while(true);
		
		return r;	
	}
	
	public static void main(String[] args)
	{
		FilaCircular<Integer> f = new FilaCircular<Integer>(4);
		
		f.insere(12);
		f.insere(35);
		f.insere(52);	
		f.insere(64);
		
		FilaCircular<Integer> g = new FilaCircular<Integer>(5);
		
		g.insere(5);
		g.insere(15);
		g.insere(23);
		g.insere(55);
		g.insere(75);
		
		FilaCircular<Integer> r = merge(f, g);
		
		r.imprimirFila();
		
		System.out.println("\nPrimeiro Elemento: " + r.primeiro());
		System.out.println("Último Elemento: " + r.ultimo());	
	}
}
