package TemplateMethodPattern;

/**
 * @Author :  warlock.deng
 * @Date :  Created in 2019/2/26 14:18
 * @Description :
 */
public abstract class TestPaper {

    public void testQuestion1() {
        System.out.println("testQuestion1[] a,jjj  b,dddd  c,dfdfdfd  d,llllll");
        System.out.println("答案："+answer1());
    }


    public void testQuestion2() {
        System.out.println("testQuestion2[] a,jjj  b,dddd  c,dfdfdfd  d,llllll");
        System.out.println("答案："+answer2());
    }


    public void testQuestion3() {
        System.out.println("testQuestion3[] a,jjj  b,dddd  c,dfdfdfd  d,llllll");
        System.out.println("答案："+answer3());
    }

    protected abstract String answer1();

    protected abstract String answer2();

    protected abstract String answer3();
}
