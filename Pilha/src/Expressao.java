public class Expressao
{
	static String verificarExp(String exp) 								// LIFO (�ltimo aberto � o primeiro fechado)
	{
		Stack<Character> s = new Stack<Character>();
				
		String valida = exp + " � v�lida.";
		
		String invalida = exp + " � inv�lida.";
		
		for (int i = 0; i < exp.length(); i++) 							// verifica String, da esquerda pra direita (LIFO ->)
		{
			char c = exp.charAt(i);
			
			if (c == '(' || c == '{' || c == '[')						// se delimitador � aberto, empilha
			{
				s.empilhar(c);
			}
			
    		else if (c == ')')
    		{
    			if (s.vazia() || ! (s.topo().equals('(')))				// verifica se o delimitador fechado � o aberto que est� no topo
    			{
    				return invalida;
    			}    			
    			
    			else
    			{
    				s.desempilhar();
    			}
    		}
			
    		else if (c == '}')
    		{
    			if (s.vazia() || ! (s.topo().equals('{')))		// idem
    			{
    				return invalida;
    			}
    			
    			else
    			{
    				s.desempilhar();
    			}
    		}
			
    		else if (c == ']')
    		{
    			if (s.vazia() || ! (s.topo().equals('[')))		// idem
    			{
    				return invalida;
    			}
    			
    			else
    			{
    				s.desempilhar();
    			}
    		}			
		}
		
		return s.vazia() ? valida : invalida;						// se a pilha for vazia, ent�o � v�lida
	}
		
	public static void main(String[] args)
	{
		String exp1 = ")"; 		// v�lida
		String exp2 = "()(([))"; 		// inv�lida
		String exp3 = "))(("; 		// inv�lida
		String exp4 = "((()))((()))"; 		// v�lida	
		
		System.out.println(verificarExp(exp1));
		System.out.println(verificarExp(exp2));
		System.out.println(verificarExp(exp3));	
		System.out.println(verificarExp(exp4));
	}
}
