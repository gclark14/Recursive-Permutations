package dna.rosalind;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by gabe.clark on 6/20/17.
 */
public class GeneOrderEnumerator {
    int target;
    int[] original;
    String permutation;
    char[] cPerm;
    ArrayList<Integer> permutations = new ArrayList<>();
    int count = 0;
    GeneOrderEnumerator(int target) {
        this.target = target;

        original = new int[target];

        StringBuilder builder = new StringBuilder();

        for(int i = 0; i < target; i++) {
            original[i] = i+1;
            builder.append(String.valueOf(i+1));
        }

        permutation = builder.toString();
    }

    void printPermutations(){
        for (int anOriginal : original) {
            System.out.print(anOriginal + " ");
        }
        System.out.println("");
    }

    private void permute(int l, int r) {
        if (l == r)
            printPermutations();
        else
            for (int i = l; i <= r; i++) {
                swap(original[l],original[i]);
                System.out.println("Before");
                permute(l+1, r);
                System.out.println("After");
                swap(original[l],original[i]);
            }
    }

    private void permute(String s, int l, int r) {
        if (l == r) {
            count++;
            for(int i = 0; i < permutation.length();i++){
                System.out.print(permutation.charAt(i));
                if(i+1 != permutation.length()){
                    System.out.print(" ");
                }
            }
            System.out.println("");
        }
        else
            for (int i = l; i <= r; i++) {
                swap(permutation,l,i);
                permute(permutation,l+1, r);
                swap(permutation,l,i);
            }
    }

    private void swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
    }

    private void swap(String s, int a, int b){
        char temp;
        char[] c = s.toCharArray();
        temp = c[a];
        c[a] = c[b];
        c[b] = temp;
        permutation = String.valueOf(c);
    }

    void generatePermutations(char type) {
        if (Character.toLowerCase(type) == 's') {
            permute(permutation, 0, permutation.length() - 1);
        } else {
            permute(0, original.length - 1);
        }
    }
}
