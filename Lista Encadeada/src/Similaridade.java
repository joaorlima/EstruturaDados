public class Similaridade
{
	static double norma(ListaSE<Integer> ls)
	{
		double norma = 0.0;
		
		for (int i = 0; i < ls.getTamanho(); i++)
		{
			norma += Math.pow(ls.getInfo(i), 2);
		}
		
		return Math.sqrt(norma);		
	}
	
	static double similaridade(ListaSE<Integer> ls, ListaSE<Integer> rs) throws Exception
	{
		double similaridade = 0.0, prodInterno = 0.0;
		
		
		if (ls.getTamanho() != rs.getTamanho())
		{
			throw new Exception("As listas devem possuir o mesmo tamanho.");
		}
		
		else
		{
			for (int i = 0; i < ls.getTamanho(); i++)
			{
				prodInterno += ls.getInfo(i) * rs.getInfo(i);				
			}
			
			similaridade += prodInterno / (norma(ls) * norma(rs));
		}
		
		return Math.round(similaridade * 100.0) / 100.0;
	}
	
	public static void main(String[] args) throws Exception
	{
		ListaSE<Integer> ls = new ListaSE<Integer>();
		
		ls.insereOrdenado(1);
		ls.insereOrdenado(2);
		ls.insereOrdenado(3);
		ls.insereOrdenado(4);	
		
		ListaSE<Integer> rs = new ListaSE<Integer>();
		
		rs.insereOrdenado(1);
		rs.insereOrdenado(2);
		rs.insereOrdenado(3);
		rs.insereOrdenado(4);
		
		System.out.println(similaridade(ls, rs));
	}

}
