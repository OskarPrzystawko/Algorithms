package chapter_1.section_5.exercise_7;

public interface UnionFind {

    void union(int p, int q);

    int find(int p);

    boolean areConnected(int p, int q);

    int getComponentsAmount();

}