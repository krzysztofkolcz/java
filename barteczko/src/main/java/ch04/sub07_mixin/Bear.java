package ch04.sub07_mixin;

public interface Bear {
    default String bear() { return "Bear"; }
    default String x(){ return "XBear"; }
}
