class Hurr{
    public static void main(String[] a){
        A a;
        boolean ret;
        a = new A();
        ret = a.method1();
    }
}

class A
{
    int[] number;
    
    public boolean method1()
    {
        int i;
        int j;
        i = 2;
        j = 1;
        number[i] = number[j];
        return true;
    }
}