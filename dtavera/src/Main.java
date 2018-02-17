public class Main {

    public static void main(String[] args) {
        ejercicio01("holla");
    }

    public static void ejercicio01(String allUnique){
        String[] allUniqueSplitted = allUnique.split("");
        boolean isUnique = true;
        for (int i = 0; i < allUniqueSplitted.length;i++){
            int c=0;
            //System.out.println(allUniqueSplitted[i]);
            for(int j = 0; j < allUniqueSplitted.length;j++){
                //System.out.println("j --> " + allUniqueSplitted[j]);
                if(allUniqueSplitted[i].equals(allUniqueSplitted[j])){
                    c++;
                }
            }
            //System.out.println("c -->" + c);
            if(c>1){
                isUnique = false;
                break;
            }
        }
        System.out.println(isUnique ? "unique chars! :D":"no unique chars");
    }
}
