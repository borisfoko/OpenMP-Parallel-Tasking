public class Example1 {
	public static void main(String[] args) {
		int foo = 5;
		//omp parallel
		{
			System.out.println("hello");
			System.out.println("word");
			System.out.println(foo);
		}
		
		System.out.println("last line");
	}
}