package recursive;

import java.util.ArrayList;

/**
 * 问题描述：
 * 假如钱币的面额有1、2、5、10四种，发奖金的时候可以使用任意组合发放。
 * 给定奖金金额，求奖金的所有组合。
 * @author ligh
 * @date 2019/7/18
 */
public class Bounty {

    private static int[] rewards = {1, 2, 5, 10};

    public static void getRewards(int reward, ArrayList<Integer> result){
        if(reward == 0){
            System.out.println(result);
            return;
        }else if(reward < 0){
            return;
        }else {
            for(int i = 0; i < rewards.length; i++){
                ArrayList newResult = (ArrayList) result.clone();
                newResult.add(rewards[i]);
                getRewards(reward-rewards[i], newResult);
            }
        }
    }

    public static void main(String[] args) {
        getRewards(10, new ArrayList<Integer>());
    }
}
