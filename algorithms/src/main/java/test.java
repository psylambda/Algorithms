public class Test {
    public static void main(String[] args)
    {
        try {
            Object o = (Object) Class.forName("Abstract").newInstance();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}


abstract class Abstract{

}
