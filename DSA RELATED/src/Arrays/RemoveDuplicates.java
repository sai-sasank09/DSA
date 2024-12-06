package Arrays;
import java.util.*;
class RemoveDuplicates {
 public static void main(String[] args) {
     int[] arr= {1,1,2,2,2,3,3};
     int k=function(arr);
//     System.out.println("return value"+ " "+ k);
     for (int i=0;i<k;i++){
         System.out.println(arr[i]);
     }
     
 }
 static int function(int[] arr){
    int i=0;
    for (int j=1;j<arr.length;j++){
        if (arr[j] != arr[i]){
            i++;
             arr[i]= arr[j];
        }
        
    }
    return i+1;
 }
}