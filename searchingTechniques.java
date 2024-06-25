import java.util.*;
public class searchingTechniques {
    
    static int      arr[];
    static boolean  answerSearch;
    static Scanner  readData = new Scanner(System.in);
    static String   userName;
    static int      neededItem;

    public static boolean linearSearch(int arr[] , int neededElement){
        answerSearch = false;
        for(int index = 0 ; index < arr.length ; index++){
            if(arr[index] == neededElement){
                answerSearch = true;
                break;
            }
        }
        return answerSearch;
    }

    public static void binarySearch(int arr[] , int neededElement){
        int left  = 0;
        int right = arr.length-1;
        answerSearch = false;

        while(left <= right){
            int middle = ( left + right ) / 2;
            
            if(arr[middle] == neededElement){
                System.out.println("Your element: " + (Arrays.toString(arr)));
                System.out.println("Your " + (neededElement) + " is exist in this location: " + (middle+1));
                answerSearch = true;
                return;
            
            }else if(arr[middle] > neededElement){
                right = middle - 1;
            
            }else{
                left = middle + 1;
            }
        }

        if(!answerSearch){
            System.out.println("Sorry but you " + (neededElement) + " not exist!");
        }
    } 

    // needed any sorting algorithm for binary search
    public static void insertionSort(int array[]){
        int outerLoop , innerLoop , temp;

        for(outerLoop = 1 ; outerLoop < array.length ; outerLoop++){
            innerLoop = outerLoop;
            temp = array[outerLoop];

            while(innerLoop > 0 && array[innerLoop-1] >= temp ){
                array[innerLoop] = array[innerLoop - 1];
                innerLoop-=1;
            }
            array[innerLoop] = temp;   
        }
    }

    public static void jumpSearch(int arr[] , int neededElement){
        answerSearch = false;
        int jumpSize = (int)Math.sqrt(arr.length);

        int left = 0;
        int right = jumpSize;     

        while(right < arr.length){
            for(int i = left ; i <= right ; i++){
                if(arr[i] == neededElement){
                    System.out.println("Your element: " + (Arrays.toString(arr)));
                    System.out.println("Your " + (neededElement) + " is exist in this location: " + (i+1));
                    answerSearch = true;
                    return; 
                }
            }

            if(!answerSearch){
                left += jumpSize;
                right = left + jumpSize;
            }
        }
        
        if(!answerSearch){
            System.out.println("Sorry but you " + (neededElement) + " not exist!");
        }
    }

    public static void main(String[] args) {
        show();
    }

    public static void show() {        
        userScreen();        
        System.out.print("\nAre you want to re-search element (True/False)? : ");
        boolean answerOption = readData.nextBoolean();

        if(answerOption){
            userScreen();
        }System.out.println("\nFinally , thank you " + (userName) + " for visit us [ Good Luck :) ]\n");
    }

    public static void userScreen() {        
        System.out.print("\nHello , enter your first name please: ");
        userName = readData.next();

        System.out.println("\nWelcome " + (userName) + " in sorting application\n");
        selectSearchingAlgorithm(showSearchingAlgorithm());
    }

    public static void selectSearchingAlgorithm(int numberOFAlgorithm){
        switch(numberOFAlgorithm){
            case 1:
                linearSearch(getElement(),neededItem);
                break;
            case 2:
                int[] arrayForBinarySearch = getElement();
                insertionSort(arrayForBinarySearch);
                binarySearch(arrayForBinarySearch, neededItem);
                break;
            case 3:
                int[] arrayForJumpSearch = getElement();
                insertionSort(arrayForJumpSearch);
                jumpSearch(arrayForJumpSearch, neededItem);
                break;
            case 4:
                System.out.println("\nNo problem and thank you for visit us\n");
                break;
            default:
                System.out.println("\nSorry , please enter correct number as exist in you screen..!\n");
                break;
        }
    }


    public static int [] getElement() {
        System.out.print("\nEnter size of your element's: ");
        int arrSize = readData.nextInt();
        arr = new int[arrSize];

        for(int index = 0 ; index < arrSize ; index +=1){
            System.out.print("\nEnter element number " + (index+1) + " : ");
            arr[index] = readData.nextInt();
        }

        System.out.print("\nEnter here needed number for do searching: ");
        neededItem = readData.nextInt();
        return arr;
    }

    public static int showSearchingAlgorithm() {
        System.out.println("1.linear      search");
        System.out.println("2.binary      search");
        System.out.println("3.jump search search");
        System.out.println("4.None        search");

        System.out.print("\nPlease enter number of any algorithm as you need: ");
        int algorithmNumber = readData.nextInt();
        
        return algorithmNumber;
    }
}