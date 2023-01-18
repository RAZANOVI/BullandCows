package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public  class CompPlayer implements AbstractPlayer {
        private String myname;
        String mynumber;
        String moveNumber;
        int rd;
        int cows,bulls;
        ArrayList<String> arrayList1 = new ArrayList<>();
    ArrayList<String> arrayList3 = new ArrayList<>(Arrays.asList("0","1","2","3","4","5","6","7","8","9"));
        //в сооветствии с правилами задумать число и занести его в mynumber // в оба числа заносится первое значениее
        CompPlayer(String name) {
            myname = name;
        }
        public int rnd1(int max) {
            int s = (int) (Math.random() * (max + 1));
            return s;
        }
        @Override
        public void getReply(int a){
            rd = a;
    }
    //перенести в инициалайз сздание элементов, в листе не пропадают значения после хода, дописать getChallange
        @Override
        public void initialize(GameRules rules) {//генерирует список всех значений из 0-9 и загадывает 1е
            NumberGenerator numberGenerator = new NumberGenerator();
            String[] a;
            Integer [] elements = new Integer[]{0,1,2,3,4,5,6,7,8,9};
            a = numberGenerator.generateNumber(elements).split(",");
            Collections.addAll(arrayList1, a);
            System.out.println(arrayList1);
            String s = arrayList1.get(0);
            setMynumber(s);
        }
        @Override
        public Challenge getChallenge(GameRules rules){
            ArrayList<String> arrayList2 = new ArrayList<>();
            String[] b;
            // АЛГОРИТМ ИИ ОТВЕТА ИИ ЧИСЛА
            String s = "0123";
            //прощупываем быков если след ход 1234
            char [] m = s.toCharArray();
            Integer [] integer = new Integer[4];
            for (int i = 0; i < m.length; i++) {
                integer[i] = Integer.parseInt(String.valueOf(m[i]));
            }
            NumberGenerator numberGenerator2 = new NumberGenerator();
            b = numberGenerator2.generateNumber(integer).split(",");
            Collections.addAll(arrayList2,b);//
            for (String h : arrayList2)
                arrayList1.remove(h);//все выше это удаление массива с ненужными нам вариантами
            System.out.println(arrayList2);
            moveNumber = arrayList3.get(0);
            arrayList3.remove(0);
            System.out.println(arrayList1.size());
            return new Challenge(moveNumber);
        }//если коров больше 0 нужно идти по массиву со значениями пока не будет быков = коров
            //возможное число складывть из оставшихся чисел
            //как определить какое из числе бык проверка первого второго третьего
    //если первое число бык оставляем его в списке остальные удаляем
    //ищем второе число
    //упорядочить числа в массиве ходить пока не подберется первео второе третье
//вариант 2 идти по списку возможных чисел если коров больше 0 делать их быками
                //ходит 0 числом,если нет коров remove(число = ходу)012
    //КАК БЫСТРО ПОБЕДИТЬ В БЫКИ И КОРОВЫ??
            /*
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
            }*/
                // moveNumber = u.toString();//просим игроков ввести число,в соответсвии с правилами(проверка на соответствие с правилами(в гейм рулес))

            // ДОБАВИТЬ ЕЩЕ ОДНО СРАВНИВАЕМОЕ ЧИСЛО
        @Override
        public Response getResponse (Challenge c){
            cows = 0;
            bulls = 0;
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
    public void processResponse (Challenge c, Response r){
        //заносим количество коров и быков игрока,в (Responce) количество (получаем ответ на челлендж)(процесс ответа должен говорить сколько быков и коров и давать новое число)
    }
        public String getName(){
            return myname; //вместо нул вернуть имя
        }

        void setMynumber (String a){
            mynumber = a;
            System.out.println(a);
        }
     /*   void numbers() throws InterruptedException{
            Thread th = new Thread();
            th.start();
            th.join();
     */

     int getReply()
     {
         System.out.println(cows);
         return cows;
     }
    }



