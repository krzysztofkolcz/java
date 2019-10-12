package item12_comparable;

public class StringLength implements Comparable<StringLength>{

    private String string;

    public StringLength(String string) {
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    @Override
    public int compareTo(StringLength o) {
        if(string.length() < o.string.length()){
            return -1;
        }
        if(string.length() > o.string.length()){
            return 1;
        }
        //string.lenght() == o.string.length()
        return string.compareTo(o.string);
    }
}
