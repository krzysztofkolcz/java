package barteczko.ch07.functionalinterfaces;

import java.util.Collection;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ManipulationMethods {

    public static <T> List<T> findAll (Collection<T> src, Predicate<T> p){
        return src.stream().filter(p).collect(Collectors.toList());
        /*
        List<T> trg = new ArrayList<>();
        for(T e : src)if(p.test(e))trg.add(e);
        return trg;
         */
    }

    public static <S,T> List<T> transform(Collection<S> src, Function<S,T> f){
        return src.stream().map(f).collect(Collectors.toList());
        /*
        List<T> trg = new ArrayList<>();
        for(S e : src)trg.add(f.apply(e));
        return trg;
         */
    }

    public static <T> List<T> generate(int n, Supplier<T> s){
        return null;
        /*
        List<T> trg = new ArrayList<>();
        for(int i =0;i<n;i++){
            trg.add(s.get());
        }
        return trg;
         */
    }

    public static <T> void process(Collection<T> src, Consumer<T> c){
        src.stream().forEach(c);
        /*
        for(T e:src)c.accept(e);
         */
    }
}
