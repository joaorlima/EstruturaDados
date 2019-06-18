public class Interseccao
{
	  static boolean pertence(No p, int info) 
	  {
		  No novo = p; 
	      
		  while (novo != null)
		  {
			  if (novo.getDado() == info)
			  {
				  return true;
			  }
			  
			  novo = novo.getProximo();
		  }
		  
		  return false;
	  }
	
	static ListaSE<Integer> interseccao(ListaSE<Integer>ls, ListaSE<Integer> rs)
	{
		No aux = ls.primeiro;
		No novo = null;
		
		ListaSE<Integer> ms = new ListaSE<Integer>();
		
		while (aux != null)			
		{
			if(pertence(rs.primeiro, aux.getDado()))
			{
				ms.insereOrdenado(aux.getDado());				
			}
			
			aux = aux.getProximo();		
		}
		
		return ms;
	}	
		
	public static void main(String[] args) 
	{
		ListaSE<Integer> ls = new ListaSE<Integer>();
	
		ls.inserePrimeiro(3);
		ls.inserePrimeiro(24);
		ls.insereUltimo(4);
		ls.inserePrimeiro(13);
		
		ListaSE<Integer> rs = new ListaSE<Integer>();
		
		rs.inserePrimeiro(24);
		rs.inserePrimeiro(4);
		rs.insereUltimo(9);
		rs.inserePrimeiro(-1);
		
		ListaSE<Integer> ms = new ListaSE<Integer>();
		
		ms = interseccao(ls, rs);
		
		ms.mostrarLista();
	}

}
