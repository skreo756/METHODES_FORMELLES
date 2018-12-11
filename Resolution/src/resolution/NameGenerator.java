package resolution;

public class NameGenerator {
    protected static String name = "f";
    protected static int cpt = 0;
    
    public static String generateFonctionName()
    {
        cpt++;
        return name+cpt;
    }
}
