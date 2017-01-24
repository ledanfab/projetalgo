package xyz.alhdo;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Main {


    public static void main(String[] args) {
        PostFixe aux, current, root;
	    System.out.println("============================================================");
        System.out.println("============================================================");
        System.out.println("=============        ESIH L3 INFO MATIN            =========");
        System.out.println("=============           ALGORITHMIQUE              =========");
        System.out.println("=============             SESSION 1                =========");
        System.out.println("============================================================");
        System.out.println("============================================================\n\n");
        System.out.println("AFFICHAGE DE L EXPRESSION POSTFIXE \n \n");

        ArrayList<String> expres=new ArrayList<>();

        ArrayDeque<PostFixe> pile= new ArrayDeque<>();

        for (int i=0 ; i< args.length; i++){
            expres.add(args[i]);
            System.out.print(" "+args[i]);
        }

        for (String s : expres){
            current=new PostFixe(s);
            if(Utils.is_Op(s)){
                aux=pile.pop();
                current.setFils_gauche(pile.pop());
                current.setFils_droit(aux);
            }
           // System.out.println("....................................................");
            pile.push(current);
        }
        root=pile.pop();
        System.out.println("\n\n============================================================");
        System.out.println("Root is "+ root);
        System.out.println("============================================================");

        //Prefixe
        String v1,v2,xor;

        ArrayDeque<String> oper= new ArrayDeque<>();
        for(String s : expres){
            if(!Utils.is_Op(s)){
                oper.push(s);
            }else{
                v2 = oper.pop();
                v1= oper.pop();
                xor = s + " "+ v1 + " "+v2;
                oper.push(xor);
            }
        }

        System.out.println("============================================================");
        System.out.println("Prefixed expression "+ oper.pop());
        System.out.println("============================================================");
        // Evaluation du system

        Double P , P1, somme;
        ArrayDeque<Double> abc= new ArrayDeque<Double>();
        for (String s : expres)
        {
            if (!Utils.is_Op(s)){
                abc.push(Double.valueOf(s));
            }else{
                P1 = abc.pop();
                P = abc.pop();
                somme= Utils.operate(P,P1,s);
                abc.push(somme);
            }
        }

        System.out.println("============================================================");
        System.out.println("Resulat "+ abc.pop());
        System.out.println("============================================================");
    }
}
