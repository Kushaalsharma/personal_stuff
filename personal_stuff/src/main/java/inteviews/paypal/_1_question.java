package inteviews.paypal;

public class _1_question {
	/**
	 * WAP to find whether sum of all divisor's add up to the number itself Return
	 * YES or NO eg: 1 = 1 return YES 5 = 1 return NO 6 = 1 +2 +3 return YES
	 */

	public static void main(String[] args) {
		System.out.println("");
		int input = 5;
		System.out.println("input is :: " + input);
		System.out.println("output with first method : "+ func(input));
		System.out.println("output with Second method : "+ func2(input));
		System.out.println("++++++++++++++++");
		input = 6;
		System.out.println("input is :: " + input);
		System.out.println("output with first method : "+ func(input));
		System.out.println("output with Second method : "+ func2(input));

	}

	/**
	 * function with N/2 complexity
	 */
	public static String func(int input) {
		int sum = 0;
		for (int i = 1; i <= input / 2; i++) {
			if (input % i == 0)
				sum += i;
		}
		return sum == input ? "YES" : "NO";
	}

	/**
	 * function with square root N complexity
	 */
	public static String func2(int input) {
		int sum = 1;
		int temp_sqrt = (int) Math.sqrt(input);

		for (int i = 2; i <= temp_sqrt; i++) {
			if (input % i == 0) {
				sum += i;
				if (i * i != input) // take perfect square root only once
					sum += input / i;
			}
		}
		return sum == input ? "YES" : "NO";
	}
}