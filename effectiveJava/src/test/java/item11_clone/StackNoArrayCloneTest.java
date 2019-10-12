package item11_clone;

import org.junit.Test;
import org.junit.Assert;

public class StackNoArrayCloneTest {

    @Test
    public void cloneTest(){
        StackNoArrayClone stack = new StackNoArrayClone();
        stack.push(new Element("x"));
        StackNoArrayClone stack2 = stack.clone();
        Element element = (Element)stack2.pop();
        System.out.println(element.getE());

    }

    private class Element{
        private String e;

        public Element(String e){
            this.e = e;
        }

        public String getE() {
            return e;
        }

        public void setE(String e) {
            this.e = e;
        }
    }
}
