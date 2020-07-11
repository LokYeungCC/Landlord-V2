import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Ready state
        //Create an poker list.
        HashMap<Integer,String> poker = new HashMap<>();

        //Create an poker index
        ArrayList<Integer> pokerIndex = new ArrayList<>();

        //Put color and numbers
        List<String> colors = List.of("♣", "♦", "♥", "♠");
        List<String> numbers = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        int index = 0;
        poker.put(index,"Big Boss");
        pokerIndex.add(index);
        index++;
        poker.put(index,"Little Boss");
        pokerIndex.add(index);
        index++;

        for (String number:numbers){
            for (String color:colors){
                poker.put(index,color+number);
                pokerIndex.add(index);
                index++;
            }
        }

        //2. Wash poker
        Collections.shuffle(pokerIndex);

        //3. Deliver to 4 players
        ArrayList<Integer> player01 = new ArrayList<>();
        ArrayList<Integer> player02 = new ArrayList<>();
        ArrayList<Integer> player03 = new ArrayList<>();
        ArrayList<Integer> diPai = new ArrayList<>();

        for (int i = 0;i < pokerIndex.size();i++){
            Integer in = pokerIndex.get(i);
            if (i>=51){
                diPai.add(in);
            }else if (i%3==0){
                player01.add(in);
            }else if (i%3==1){
                player02.add(in);
            }else if (i%3==2){
                player03.add(in);
            }
        }

        // 4. Order the poker
        Collections.sort(player01);
        Collections.sort(player02);
        Collections.sort(player03);
        Collections.sort(diPai);

        //5. look pokers
        lookPoker("Lok",poker,player01);
        lookPoker("Ginny",poker,player02);
        lookPoker("Gary",poker,player03);
        lookPoker("Victor",poker,diPai);
    }



    private static void lookPoker(String name,HashMap<Integer,String> poker,ArrayList<Integer> list){
        System.out.println("name:" + name);
    for (Integer key:list){
        String value = poker.get(key);
        System.out.println(value + " ");
    }
        System.out.println();
    }
}
