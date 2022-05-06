import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int answer = 0;

        String a = br.readLine();
        String b = br.readLine();

        String array1[] = a.split(" ");
        String array2[] = b.split(" ");

        int x = Integer.parseInt(array1[0]);    // 카드갯수
        int y = Integer.parseInt(array1[1]);    // 숫자합

        for(int i=0; i<x; i++){
            for(int j=i+1; j<x; j++){
                for(int k=j+1; k<x; k++){
                    if(y>=Integer.parseInt(array2[i])+Integer.parseInt(array2[j])+Integer.parseInt(array2[k])&&answer<Integer.parseInt(array2[i])+Integer.parseInt(array2[j])+Integer.parseInt(array2[k])){
                        answer = Integer.parseInt(array2[i])+Integer.parseInt(array2[j])+Integer.parseInt(array2[k]);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
