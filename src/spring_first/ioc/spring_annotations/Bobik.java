package spring_first.ioc.spring_annotations;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class Bobik implements Dog {
    private String name;
    private String voice;

    public Bobik(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    @Override
    public void name() {
        System.out.println("Name: " + name);
    }

    @Override
    public void voice() {
        System.out.println("Voice: " + voice);
    }
}
