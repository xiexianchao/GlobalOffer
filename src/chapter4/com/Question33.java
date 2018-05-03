package chapter4.com;

/**
 * @author:xiehcao
 * @Date:2018/5/3
 * @Time:11:30
 * @description：
 */
public class Question33 {
    public boolean VerifySequenceOfBST(int[] sequence)
    {
        if(sequence == null || sequence.length<=0)
            return false;
        int root =sequence[sequence.length-1];
        int i = 0;
        for (; i < sequence.length-1; i++) {
            if(sequence[i]>root)
                break;
        }

        int j = i;
        for (; j < sequence.length-1; j++) {
            if(sequence[j]<root)
                return false;
        }

        int[] lefts = new int[i];
        int[] rights = new int[sequence.length-i-1];

        for (int k = 0; k < i; k++) {
            lefts[k] = sequence[k];
        }
        for (int k = i; k < sequence.length-1; k++) {
            rights[k-i] = sequence[k];
        }

        boolean left = true;
        boolean right = true;

        if(i>0)
            left = VerifySequenceOfBST(lefts);
        if(j<sequence.length-1)
            right = VerifySequenceOfBST(rights);
        return left&&right;

    }

}
