public class TextLab03 {
	public static void main(String args[]){
		System.out.println("TextLab03, Student Version\n");

		double inputPrincipal  = 259000;
		double inputAnnualRate = 5.75;
		double inputNumberYears   = 30;

		double n = inputNumberYears *12; //Years to months
		double R = ( (inputAnnualRate/100)/12);  //  percent to decimal then divide the rate into months
		double p = inputPrincipal;
		//It's not unusual to use single letters as variable names when there are strong conventions for the letters meaning in a certain field of work. That's why you see so many letters when you break open a geometry/physics class (see a physics engine).
		double top =  R * Math.pow( (1+R), n);
		double bottom = Math.pow( (1+R), n)  - 1;

		double monthlyPayment =  (top/bottom) * p;
		double roundedMonthlyPayment =  (double)Math.round( monthlyPayment * 100)/100;//We must cast here because Math.round returns an int. Dividing by 100 leads to truncation.
		double totalPayment = (roundedMonthlyPayment*12) * inputNumberYears;
		double totalInterest = totalPayment - inputPrincipal;

		System.out.println("Principal: \t$" + p);
		System.out.println("Annual Rate: \t" + inputAnnualRate+"%");
		System.out.println("Number of Years:\t" + inputNumberYears);
		System.out.println("Monthly Payment:\t$" + roundedMonthlyPayment);
		System.out.println("Total Payments:\t$" + totalPayment);
		System.out.println("Total Interest:\t$" + totalInterest);

		//[R * (1+R)^n]
		//[  ((1+R)^n)  -1]
		//all times p
	}
}
