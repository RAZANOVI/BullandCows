package com.company;

public class Challenge {
 String num;

 Challenge(String num) {
  this.num = num;
 }
 void setChallenge (String c){
  this.num = c;
 }
 String getChallenge(){
  return num;
 }
 GameRules rules;
}

