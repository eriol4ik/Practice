package spring_first.ioc.spring_xml;

/**
 * Created by eriol4ik on 18.02.2017.
 */
public class Cat {
    private String name;
    private String voice;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
