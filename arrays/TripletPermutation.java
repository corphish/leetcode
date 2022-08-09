import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TripletPermutation {
    static List<List<Integer>> res = new ArrayList<>();
    static double min = Double.POSITIVE_INFINITY;

    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = 10; //sc.nextInt();
		while (t-- > 0) {
		    long x = (long) (Math.random() * 100L);
		    long y = x + (long) (Math.random() * 10L);
		    
		    //if (x > y) throw new IllegalArgumentException(x + " " + y);
            System.out.println("Start = " + x + ", " + y);
		    
		    boolean matchFound = false;
		    
		    //List<Segment> segments = new ArrayList<>();
		    
		    for (long i = 1; i * i <= y; i++) {
		        long l = i;
		        long r = y/i;
		        
		        long a = x/2;
		        long b = x - a;
		        
		        if (b < l || a > r) {
		            System.out.println(a + " " + b);
		            System.out.println(l + " " + r);
		            matchFound = true;
		            break;
		        }
		    }
		    
		    /*System.out.println(segments);
		    
		    for (int i = 0; i < segments.size(); i++) {
		        for (int j = 0; j < segments.size(); j++) {
		            if (i != j) {
		                if (!segments.get(i).intersectsWith(segments.get(j))) {
		                    System.out.println(segments.get(i));
		                    System.out.println(segments.get(j));
		                    matchFound = true;
		                    break;
		                }
		            }
		        }
		        
		        if (matchFound) {
		            break;
		        }
		    }*/
		    
		    if (!matchFound) {
		        System.out.println("-1");
		    }
		}
	}

    /*public static void main(String[] args) 
    { 
        for (int i = 3; i <= 10; i++) {
            // Prepare result
            int[] predicted = new int[i];
            int a = 0, b = i - 1, k = i, v = 0;
            while (b >= a) {
                if (v % 2 == 0) {
                    predicted[a] = k;
                    if (k != 1)
                        predicted[b] = k - 1;
                } else {
                    predicted[b] = k;
                    if (k != 1)
                        predicted[a] = k - 1;
                }

                k -= 2;
                a++;
                b--;
                v++;
            }

            List<Integer> processed = Arrays.stream(predicted).boxed().collect(Collectors.toList());
            System.out.println(processed);


            int[] arr = IntStream.rangeClosed(1, i).toArray();
            int n = arr.length; 

            permute(arr, 0, n-1); 
            // System.out.println(i + " -> " + res);
            for (List<Integer> el: res) {
                if (el.equals(processed)) {
                    System.out.println("Success for " + i);
                }
            }

            min = Double.POSITIVE_INFINITY;;
        }
    }*/

    /** 
    * permutation function 
    * @param str string to calculate permutation for 
    * @param l starting index 
    * @param r end index 
    */
    private static void permute(int[] arr, int l, int r) 
    { 
        if (l == r) 
            process(arr);
        else
        { 
            for (int i = l; i <= r; i++) 
            { 
                arr = swap(arr,l,i); 
                permute(arr, l+1, r); 
                arr = swap(arr,l,i); 
            } 
        } 
    } 

    /** 
    * Swap Characters at position 
    * @param a string value 
    * @param i position 1 
    * @param j position 2 
    * @return swapped string 
    */
    public static int[] swap(int[] arr, int i, int j) 
    { 
        int temp; 
        int[] cl = arr.clone(); 
        temp = cl[i]; 
        cl[i] = cl[j]; 
        cl[j] = temp; 
        return cl; 
    }
    
    static void process(int[] arr) {
        double sum = 0;
        for (int i = 2; i < arr.length; i++) {
            double avg = ((arr[i] * 1.0 ) + arr[i - 1] + arr[i - 2])/3;
            sum += avg;
        }

        if (sum < min) {
            min = sum;
            res.clear();
            res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        } else if (sum == min) {
            res.add(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }
    }
}