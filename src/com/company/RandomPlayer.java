package com.company;

import java.util.*;

public class RandomPlayer implements AbstractPlayer {
    private String myname;
    String mynumber;
    String moveNumber;
    GameRules myRules;
    int cows, bulls;
    //в сооветствии с правилами задумать число и занести его в mynumber // в оба числа заносится первое значениее
    RandomPlayer(String name) {
        myname = name;
    }
    public int rnd1(int max) {
        int s = (int) (Math.random() * (max + 1));
        return s;
    }

    /* public int rnd2() {
         int min = 0;
         int max = 9;
         max -= min;
         int s = (int) (Math.random() * ++max + min);
         return s;
     }
     @Override
     public void initialize(GameRules rules) throws Exception {
         int nNumber = rules.getdigits();//nчисло
         LinkedHashSet<String> list = new LinkedHashSet<>(nNumber);
         //нужно задумать число// в заносится число(игрок вносит число)
         do {
             String b = String.valueOf(rnd2());//беру масив от одного до 9 и генерирую рандом которым выбираю число из массива, и беру nчисел
             list.add(b);
         } while (list.size() != nNumber);
         Iterator<String> iterator = list.iterator();
         StringBuilder s = new StringBuilder();
         while (iterator.hasNext())
             s.append(iterator.next());
         String x = s.toString();
         System.out.println(x);

 */
    @Override
    public void initialize(GameRules rules) {
        List <Integer> list1 = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        int nnNumber = rules.getdigits();
        ArrayList<Integer> list2 = new ArrayList();
        for (int f = 0; f < nnNumber; f++) {
            int rand1 = rnd1(9-f);
            int getNumber = list1.get(rand1);
            list2.add(getNumber);
            list1.remove(rand1);
        }
        StringBuilder u = new StringBuilder();
        for (int q: list2) {
            u.append(q);
            //радном кроме предидуего числа
        }
        setMynumber(u.toString());
    }
        @Override
        public Challenge getChallenge(GameRules rules) {
        int rules1 = rules.getdigits();
            List<Integer> list1 = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
            int nnNumber = 3;
            ArrayList<Integer> list2 = new ArrayList();
            for (int f = 0; f < rules1; f++) {
                int rand1 = rnd1(9 - f);
                int getNumber = list1.get(rand1);
                list2.add(getNumber);
                list1.remove(rand1);
            }
            StringBuilder u = new StringBuilder();
            for (int q : list2) {
                u.append(Integer.toString(q));
                //радном кроме предидуего числа
            }
           moveNumber = u.toString();//просим игроков ввести число,в соответсвии с правилами(проверка на соответствие с правилами(в гейм рулес))
            return new Challenge(moveNumber);
        }// ДОБАВИТЬ ЕЩЕ ОДНО СРАВНИВАЕМОЕ ЧИСЛО
        @Override
        public Response getResponse (Challenge c){
            bulls = 0;
            cows = 0;
            String hisnumber = c.getChallenge();
            for (int i = 0; i < mynumber.length(); i++) {
                for (int j = 0; j < hisnumber.length(); j++) {
                    if (mynumber.charAt(i) != hisnumber.charAt(j)) continue;
                    if (i == j) {
                        bulls++;
                    } else {
                        cows++;
                    }
                }
            }
            return new Response(cows, bulls);
        }
        @Override
        public String getName () {
            return myname; //вместо нул вернуть имя
        }
        @Override
        public void processResponse (Challenge c, Response r){
        //заносим количество коров и быков игрока,в (Responce) количество (получаем ответ на челлендж)(процесс ответа должен говорить сколько быков и коров и давать новое число)
        }
        @Override
        public void getReply(int a){}
        void setMynumber (String a){
            mynumber = a;
            System.out.println(a);
    }
        int getReply(){
        System.out.println(cows);
        return cows;
    }
    }


        //загадываеет и ходит
        //инитиалайз генерирует случайное число
        //ходит на случайне число
        // посмотрреть коллекции листы глянуть
        //следующий консоль плеер
        //

