public class No
{
	private int dado = 0;
	private No proximo = null;
	
	No(int i)
	{
		this.dado = i;
	}

	public int getDado()
	{
		return dado;
	}

	public void setDado(int dado)
	{
		this.dado = dado;
	}

	public No getProximo()
	{
		return proximo;
	}

	public void setProximo(No proximo)
	{
		this.proximo = proximo;
	}
}
