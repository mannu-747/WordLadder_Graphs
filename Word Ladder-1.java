/*
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.

Note: If no possible way to transform sequence from startWord to targetWord return 0


Example 1:

Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:
3
Explanation:
The length of the smallest transformation
sequence from "der" to "dfs" is 3
i,e "der" -> "dfr" -> "dfs".*/

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Solution
{
    public int wordLadderLength(String start, String target, String[] wordList)
    {
        // Code here
        Set<String> set= new HashSet<>();
        for(int i=0;i<wordList.length;i++)
        set.add(wordList[i]);
        //set.addAll(wordList);
        Queue<Pair> qu= new LinkedList<>();
        qu.offer(new Pair(start,1));
        while(!qu.isEmpty()){
            String word= qu.peek().first;
            int steps= qu.peek().second;
            qu.poll();
            if(word.compareTo(target)==0) return steps;
            
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] temp = word.toCharArray();
                    temp[i]=ch;
                    String te=new String(temp);
                    if(set.contains(te)){
                        qu.add(new Pair(te,steps+1));
                        set.remove(te);
                    }
                }
            }
        }
        return 0;
    }
}class Pair{

    String first;

    int second;

    Pair(String first,int second){

        this.first=first;

        this.second=second;

    }

}