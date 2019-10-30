package selTraining;

public class Localvariable 
{
	public static void Age()
	{
		int age = 0;
		age = age + 7;
		System.out.println("Puppy age is : " + age);
	}
	public void add(int x, int y)
	{
		int z = x+y;
		System.out.println("Sum is -----"+z);
	}
	public void training()
	{
		System.out.println("today training is java");
	}
	public static void main(String[] args) 
	{
		Localvariable test = new Localvariable();
		test.Age();
		test.training();
		test.add(5, 7);
	}
}
