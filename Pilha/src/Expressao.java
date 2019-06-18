public class Expressao
{
	static String verificarExp(String exp) 								// LIFO (último aberto é o primeiro fechado)
	{
		Stack<Character> s = new Stack<Character>();
				
		String valida = exp + " é válida.";
		
		String invalida = exp + " é inválida.";
		
		for (int i = 0; i < exp.length(); i++) 							// verifica String, da esquerda pra direita (LIFO ->)
		{
			char c = exp.charAt(i);
			
			if (c == '(' || c == '{' || c == '[')						// se delimitador é aberto, empilha
			{
				s.empilhar(c);
			}
			
    		else if (c == ')')
    		{
    			if (s.vazia() || ! (s.topo().equals('(')))				// verifica se o delimitador fechado é o aberto que está no topo
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
		
		return s.vazia() ? valida : invalida;						// se a pilha for vazia, então é válida
	}
		
	public static void main(String[] args)
	{
		String exp1 = ")"; 		// válida
		String exp2 = "()(([))"; 		// inválida
		String exp3 = "))(("; 		// inválida
		String exp4 = "((()))((()))"; 		// válida	
		
		System.out.println(verificarExp(exp1));
		System.out.println(verificarExp(exp2));
		System.out.println(verificarExp(exp3));	
		System.out.println(verificarExp(exp4));
	}
}
