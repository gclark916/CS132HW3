class Hurr{
    public static void main(String[] useless)
    {
        A a;
        B b;
        boolean res;
        a = new A();
        b = new B();
        res = a.method1();
        {
            res = b.method1();
        }
    }
}

class A
{
    public boolean method1()
    { 
        System.out.println(1); 
        return true;
    }
}
    
class B 
{
    public boolean method1() 
    { 
        B b;
        b = this;
        System.out.println(2); 
        return b.method1();
    }
}