package com.algorithm.hash;

import java.util.HashMap;
import java.util.Map;

public class Question_01 {

    // https://school.programmers.co.kr/learn/courses/30/lessons/42576

    public static void main(String[] args) {
        Solution solution = new Solution();

        // 테스트 케이스 1
        String[] participant1 = {"leo", "kiki", "eden"};
        String[] completion1 = {"eden", "kiki"};
        System.out.println(solution.solution(participant1, completion1)); // leo

        // 테스트 케이스 2
        String[] participant2 = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] completion2 = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution.solution(participant2, completion2)); // vinko

        // 테스트 케이스 3 (동명이인)
        String[] participant3 = {"mislav", "stanko", "mislav", "ana"};
        String[] completion3 = {"stanko", "ana", "mislav"};
        System.out.println(solution.solution(participant3, completion3)); // mislav
    }
}

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        // 1. 참가자 카운팅
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // 2. 완주자 제거
        for (String name : completion) {
            map.put(name, map.get(name) - 1);
        }

        // 3. 값이 1인 사람 찾기
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 0) {
                return entry.getKey();
            }
        }
        return "";
    }
}
