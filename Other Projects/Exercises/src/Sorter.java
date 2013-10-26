public class Sorter {
	public static void main (String[] args){
		System.out.println(evenlySpaced(10,90,50));

	}
    public static boolean evenlySpaced(int a, int b, int c) {
        int small, medium, large;
        large = a;
        medium = b;
        small = c;

        if (small>large){
            int temp = large;
            large = small;
            small = temp;
        }
        if (medium > large){
            int temp = large;
            large = medium;
            medium = temp;
        }
        if ( small> medium){
            int temp = medium;
            medium = small;
            small = temp;
        }

        if(large-medium == medium-small) return true;
        return false;
    }
}
