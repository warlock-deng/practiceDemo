package array;

public class Test3 {


    public static void main(String[] args) {

        System.out.println(add("123","543326"));

    }

    private static String add(String one, String two) {
        String[] oneArr = one.split("");
        String[] twoArr = two.split("");

        int oneIndexCurr = oneArr.length - 1;
        int twoIndexCurr = twoArr.length - 1;
        int flag = 0;
        String response = "";
        while (oneIndexCurr >= 0 || twoIndexCurr >= 0) {
            int o = 0;
            if (oneIndexCurr >= 0) {
                o = Integer.parseInt(oneArr[oneIndexCurr]);
            }
            int t = 0;
            if (twoIndexCurr >= 0) {
                t = Integer.parseInt(twoArr[twoIndexCurr]);
            }
            int res = o + t;
            if (res > 9) {
                flag = 1;
                res -= 10;
            } else {
                flag = 0;
            }
            res = res + flag;
            response = res + response;
            oneIndexCurr--;
            twoIndexCurr--;
        }
        return response;
    }
}