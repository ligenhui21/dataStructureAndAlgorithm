package recursive;

import java.util.ArrayList;

/**
 * 问题描述：
 * 一个整数可以被分解为多个整数的乘积，给定一个整数，求所有组合。
 * （每个组合中至多出现一次1）
 * @author ligh
 * @date 2019/7/18
 */
public class FactorCombination {
    public static void getDivisor(int number, ArrayList<Integer> result){
        if(number == 1){
            if(!result.contains(1)){
                result.add(1);
            }
            System.out.println(result);
            return;
        }else{
            for(int i = 1; i <= number; i++){
                ArrayList<Integer> newResult = (ArrayList<Integer>) result.clone();
                if((i == 1) && newResult.contains(i)){
                    continue;
                }
                if((number % i) > 0){
                    continue;
                }
                newResult.add(i);
                getDivisor(number/i, newResult);
            }
        }
    }

    public static void main(String[] args) {
        getDivisor(8, new ArrayList<Integer>());
    }
}
