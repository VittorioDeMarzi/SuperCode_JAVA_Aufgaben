public class umwandeln {
    public static void main(String args[]) {


        /* 
- a ) Wandle folgende For-Schleife in eine While-Schleife um:
    public class ForInWhile{
        
        public static void main(String args[]){

            int summe;

            for(int i = 0; i < 10; i++){
                System.out.println("Durchlauf: " + i);
                    summe += i;
            }
            System.out.println(summe);

        }
    } */

        int summe = 0;
        int i = 0;
        while (i<10) { 
            System.out.println("Durchlauf: " + i);
            summe += i;
            i++;
        }

    /* b) Wandle folgende Do-While-Schleife in eine For-Schleife um:
    public class WhileInFor{
    
    public static void main(String args[]){
    
        int a = 0;
        do{
            a += 2;
            System.out.println(a);
        }while(a < 7);
    
    }
    } */
   
        for (int a = 2; a < 7; a+=2) {
            System.out.println(a);
        }
    }


}