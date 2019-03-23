public class TopHorStrSumOfNumberTar{
    public static void main(String[] args){
        int tar = 4;
        String res = "";
        new TopHorStrSumOfNumberTar().solvePrint(tar,tar, res);

    }

    public void solvePrint(int num, int cur, String res){
        if(cur == 0){
            System.out.println(res);
            return;
        }

        for(int i=1; i<=num; i++){
            if(i<= cur){
                solvePrint(num,cur-i,res+i);
            }
        }
    }
}