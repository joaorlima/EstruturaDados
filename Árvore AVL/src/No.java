public class No
{
	No esquerda, direita;
	int dado, altura;
	
	public No()
	{
		esquerda = direita = null;
		dado = altura = 0;
	}
	
	public No(int i)
	{
		esquerda = direita = null;
		dado = i;
		altura = 1;
	}

	public int getAltura()
	{
		return altura;
	}

	public void setAltura(int altura)
	{
		this.altura = altura;
	}	
}