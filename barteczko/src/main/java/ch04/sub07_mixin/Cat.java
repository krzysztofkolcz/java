package ch04.sub07_mixin;

public interface Cat {
    default String cat() { return "Cat"; }
    default String x(){ return "XCat"; }
}
