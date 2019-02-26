/*

To perform basic array operations

*/
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.IntStream;
import java.util.ArrayList;
import java.util.List;

public class BasicArrOper {
    public static void main(String[] args){

        // Declaring single dimensional array and later assigning the values manually
        int[] singleArr = new int[6];

        // Creating and assisgning values to 2 dimensional array
        int[][] twoDArr = {{3,7,2},{5,1,9},{8,6,4}};

        singleArr[0] = 2;
        singleArr[1] = 3;
        singleArr[2] = 4;
        singleArr[3] =5;
        singleArr[4] = 6;
        singleArr[5] = 7;

        // Iterating array from first to last
        for(int i=0; i<singleArr.length; i++){
            System.out.println("Printing single dimensional array : " + singleArr[i]);
        }


        // Printing two D array
        System.out.println("\n Printing 2 D array:");
        for(int outer=0; outer<twoDArr.length; outer ++){
            for(int inner=0; inner<twoDArr[outer].length; inner ++){
                System.out.print(twoDArr[outer][inner] + " ");
            }
        }

        // Printing 2 D using Arrays.toString method:
        System.out.println("\n \n Printing 2 D array using Arrays.toString method ");
        for(int[] nums : twoDArr ){
            System.out.println(Arrays.toString(nums));
        }


        // converting array elements to streams
        String[] strEle = {"st1","st2","st3"};
        Stream<String> stout = Arrays.stream(strEle);
        System.out.println(stout.collect(Collectors.joining(" ")));

        // Converting Integer elements
        Integer[] intEle = {new Integer(1), new Integer(2), new Integer(3)};;
        System.out.println("printing this Integer value: " + intEle[1]);

        // Not possible:
        //Stream<Integer> intstream = Arrays.stream(intEle);
        //System.out.println(intstream.collect(Collectors.joining(" - ")));





        // Not possible for:  printing integers using streams
        //Stream<Integer> intstream = Arrays.stream(singleArr);
        //System.out.println(intstream.collect(Collectors.joining(" - ")));

        // Find array index of an element in array - skipping regular method:
        // using binarysearch :
        int binNum = Arrays.binarySearch(singleArr,6);
        System.out.println("Binarysearch method of finding array : " + binNum);

        // using List only for non-primitive data types:
        String[] strlist = {"A", "B", "C", "D", "E"};
        List<String> listInt = Arrays.asList(strlist);
        System.out.println(listInt.indexOf("D"));

        //cloning an arr
        int[] newclone = singleArr.clone();
        System.out.println("Original array : " + Arrays.toString(singleArr) + "\n" + "New clonned array : " + Arrays.toString(newclone));

        //Copying using copyOf
        int[] a = {5,8,2,7,9,1,3};
        int[] b = Arrays.copyOf(a,a.length-2);
        System.out.println("\n Original array - a : " + Arrays.toString(a) + "\n" + "New clonned array - b : " + Arrays.toString(b));

        // copying from specific length:

        int[] c = new int[a.length];
        System.arraycopy(a,0,c,0,a.length-2);
        System.out.println("\n array - c : " + Arrays.toString(c) );

    }
}

