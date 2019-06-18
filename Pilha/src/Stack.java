public class Stack<T>
{
	int top = -1;
	int MAX = 100;
	private T[] data = (T[]) new Object[MAX];
	
	/*
	public Stack(int size)
	{
		size = MAX;
		data = (T[]) new Object[size];
	}
	*/
	
	boolean vazia()
	{
		return (top == -1) ? true : false;
	}
	
	boolean cheia()
	{
		return (top + 1 == MAX) ? true : false;
	}
	
	void empilhar(T t)
	{
		if (!cheia())
		{
			top++;
			data[top] = t;
		}
		
		else
		{
			System.out.println("A pilha está cheia.");
		}
	}
	
	Object desempilhar() // deixar Object para retornar String
	{
		if (!vazia())
		{
			return data[top--];
		}
		
		else
		{
			return "A pilha está vazia";
		}		
	}
	
	Object topo()
	{
		return data[top];
	}
}