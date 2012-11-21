class Hurr{
    public static void main(String[] useless)
    {
        A a;
        boolean res;
        a = new A();
        res = a.method1();
    }
}

class A
{
    int someValue;
    
    public boolean method1()
    { 
        System.out.println(someValue); 
        return true;
    }
}