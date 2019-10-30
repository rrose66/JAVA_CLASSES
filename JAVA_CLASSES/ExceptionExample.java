package training;

public class ExceptionExample 
{
	static String[] str = {"Mon","Tue","Wed"};
	int i=0,j;
	public void test()
	{
		try
		{
			j=i/0;
			j=i+2;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("Exception Thrown" + e);;
		}
		finally
		{
			
		}
		try
		{
			System.out.println("String is :" + str[0]);
			throw new ArrayIndexOutOfBoundsException("New arrayout of exception");
		}
		catch(Exception e)
		{
			e.printStackTrace();
			j=i/2;
			System.out.println("Exception Caught in test method " + e);
		}
	}
	public static void main(String[] args) 
	{
		

	}

}
